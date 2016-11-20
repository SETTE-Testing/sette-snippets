/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 *
 * SETTE is a tool to help the evaluation and comparison of symbolic execution
 * based test input generator tools.
 *
 * Budapest University of Technology and Economics (BME)
 *
 * Authors: Lajos Cseppento <lajos.cseppento@inf.mit.bme.hu>, Zoltan Micskei
 * <micskeiz@mit.bme.hu>
 *
 * Copyright 2014-2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

using System;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace BME.MIT.SETTE.Environment
{
    public static class Env3_Networking
    {
        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessHost(string host)
        {
            Server server = new Server();
            server.startServer();

            TcpClient socket = null;
            try
            {
                // just find a host with this port
                socket = new TcpClient(host, 1111 * 4);
                return 1;
            }
            catch (Exception)
            {
                return 0;
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessPort(int port)
        {
            Server server = new Server();
            server.startServer();

            TcpClient socket = null;
            try
            {
                // just find a valid port on this host
                socket = new TcpClient("localhost", port);
                return 1;
            }
            catch (Exception)
            {
                return 0;
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessHostAndPort(string host, int port)
        {
            Server server = new Server();
            server.startServer();

            TcpClient socket = null;
            try
            {
                // just find a host:port combination
                socket = new TcpClient(host, port);
                return 1;
            }
            catch (Exception)
            {
                return 0;
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessPositiveAnswer(string question)
        {
            Server server = new Server();
            server.startServer();

            TcpClient socket = null;
            try
            {
                socket = new TcpClient("localhost", 1111 * 4);

                StreamReader input = new StreamReader(socket.GetStream());
                StreamWriter output = new StreamWriter(socket.GetStream());
                output.AutoFlush = true;

                output.WriteLine(question);
                if (input.ReadLine().Equals("4"))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessNegativeAnswer(string question)
        {
            Server server = new Server();
            server.startServer();

            TcpClient socket = null;
            try
            {
                socket = new TcpClient("localhost", 1111 * 4);

                StreamReader input = new StreamReader(socket.GetStream());
                StreamWriter output = new StreamWriter(socket.GetStream());
                output.AutoFlush = true;

                output.WriteLine(question);
                if (input.ReadLine().Equals("Not a number: a"))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessBothCases(string[] questions)
        {
            if (questions == null)
            {
                return -1;
            }

            Server server = new Server();
            server.startServer();

            TcpClient socket = null;

            try
            {
                socket = new TcpClient("localhost", 1111 * 4);
                StreamReader input = new StreamReader(socket.GetStream());
                StreamWriter output = new StreamWriter(socket.GetStream());
                output.AutoFlush = true;

                bool hasValid = false;
                bool hasInvalid = false;

                for (int i = 0; i < questions.Length; i++)
                {
                    output.WriteLine(questions[i]);

                    if (input.ReadLine().StartsWith("Not a number:"))
                    {
                        hasInvalid = true;
                    }
                    else
                    {
                        hasValid = true;
                    }
                }

                if (hasValid && hasInvalid)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        // @SetteRequiredStatementCoverage(value = 0)
        public static int deadlock()
        {
            // server will not send anything if it does not receive anything
            // the test input generator should detect the deadlock
            Server server = new Server();
            server.startServer();

            TcpClient socket = null;
            try
            {
                socket = new TcpClient("localhost", 1111 * 4);
                socket.GetStream().ReadByte();
                return 1;
            }
            finally
            {
                closeSilently(socket);
                server.stopServer();
            }
        }

        private static void handleRequest(TcpClient socket)
        {
            StreamReader input = new StreamReader(socket.GetStream());
            StreamWriter output = new StreamWriter(socket.GetStream());
            output.AutoFlush = true;
            while (true)
            {
                String line = input.ReadLine();
                if (line == null)
                {
                    break;
                }

                try
                {
                    int i = int.Parse(line);
                    output.WriteLine(i * 2);
                }
                catch (FormatException)
                {
                    output.WriteLine("Not a number: " + line);
                }
            }
            closeSilently(socket);
        }

        public class Server
        {
            private readonly Thread thread;
            private TcpListener server;

            public Server()
            {
                this.thread = new Thread(() =>
                {
                    server = null;
                    try
                    {
                        server = new TcpListener(IPAddress.Loopback, 1111 * 4);
                        server.Start();

                        while (true)
                        {
                            TcpClient socket = server.AcceptTcpClient();
                            handleRequest(socket);
                        }
                    }
                    catch (Exception)
                    {
                        // ignore exception in server
                    }
                    finally
                    {
                        closeSilently(server);
                    }
                });
            }

            public void startServer()
            {
                thread.Start();
            }

            public void stopServer()
            {
                thread.Interrupt();
                closeSilently(server);
            }
        }

        private static void closeSilently(IDisposable disposable)
        {
            try
            {
                disposable.Dispose();
            }
            catch (Exception)
            {
                // ignore
            }
        }

        private static void closeSilently(TcpListener closeable)
        {
            try
            {
                closeable.Stop();
            }
            catch (Exception)
            {
                // ignore
            }
        }
    }
}