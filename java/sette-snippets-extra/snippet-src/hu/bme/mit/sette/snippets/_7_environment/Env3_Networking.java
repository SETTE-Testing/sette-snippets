/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 *
 * SETTE is a tool to help the evaluation and comparison of symbolic execution based test input 
 * generator tools.
 *
 * Budapest University of Technology and Economics (BME)
 *
 * Authors: Lajos Cseppentő <lajos.cseppento@inf.mit.bme.hu>, Zoltán Micskei <micskeiz@mit.bme.hu>
 *
 * Copyright 2014-2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except 
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package hu.bme.mit.sette.snippets._7_environment;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;

@SetteSnippetContainer(category = "Env3", goal = "Check support for networking support")
public final class Env3_Networking {
    private Env3_Networking() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessHost(String host) {
        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            // just find a host with this port
            socket = new Socket(host, 1111 * 4);
            return 1;
        } catch (Exception ex) {
            return 0;
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessPort(int port) {
        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            // just find a valid port on this host
            socket = new Socket("localhost", port);
            return 1;
        } catch (Exception ex) {
            return 0;
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessHostAndPort(String host, int port) {
        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            // just find a host:prot combination
            socket = new Socket(host, port);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessPositiveAnswer(String question) throws IOException {
        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            socket = new Socket("localhost", 1111 * 4);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(question);
            if (in.readLine().equals("4")) {
                return 1;
            } else {
                return 0;
            }
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessNegativeAnswer(String question) throws IOException {
        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            socket = new Socket("localhost", 1111 * 4);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(question);
            if (in.readLine().equals("Not a number: a")) {
                return 1;
            } else {
                return 0;
            }
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessBothCases(String[] questions) throws IOException {
        if (questions == null) {
            return -1;
        }

        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            socket = new Socket("localhost", 1111 * 4);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            boolean hasValid = false;
            boolean hasInvalid = false;

            for (int i = 0; i < questions.length; i++) {
                out.println(questions[i]);

                if (in.readLine().startsWith("Not a number:")) {
                    hasInvalid = true;
                } else {
                    hasValid = true;
                }
            }

            if (hasValid && hasInvalid) {
                return 1;
            } else {
                return 0;
            }
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    @SetteRequiredStatementCoverage(value = 0)
    public static int deadlock() throws IOException {
        // server will not send anything if it does not receive anything
        // the test input generator should detect the deadlock  
        Server server = new Server();
        server.startServer();

        Socket socket = null;
        try {
            socket = new Socket("localhost", 1111 * 4);
            socket.getInputStream().read();
            return 1;
        } finally {
            closeSilently(socket);
            server.stopServer();
        }
    }

    private static void handleRequest(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }

            try {
                int i = Integer.parseInt(line);
                out.println(i * 2);
            } catch (NumberFormatException ex) {
                out.println("Not a number: " + line);
            }
        }
        closeSilently(socket);
    }

    private static final class Server extends Thread {
        private ServerSocket server;

        @Override
        public void run() {
            server = null;
            try {
                server = new ServerSocket(1111 * 4);
                while (true) {
                    Socket socket = server.accept();
                    handleRequest(socket);
                }
            } catch (IOException ex) {
                if (!ex.getMessage().equals("Socket is closed")
                        && !ex.getMessage().equals("socket closed")) {
                    throw new RuntimeException(ex);
                }
            } finally {
                closeSilently(server);
            }
        }

        public void startServer() {
            start();
        }

        public void stopServer() {
            interrupt();
            closeSilently(server);
        }
    }

    private static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception ex) {
            // ignore
        }
    }
}
