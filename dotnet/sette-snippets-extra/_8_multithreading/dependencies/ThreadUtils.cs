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
 * Copyright 2014-2016
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

using System;
using System.Threading;

namespace BME.MIT.SETTE.Multithreading.Dependencies
{
    public static class ThreadUtils
    {
        public static void startAll(params Thread[] threads)
        {
            foreach (Thread thread in threads)
            {
                thread.Start();
            }
        }

        public static void joinAll(params Thread[] threads)
        {
            foreach (Thread thread in threads)
            {
                try
                {
                    thread.Join();
                }
                catch (ThreadInterruptedException)
                {
                    // ignore
                }
            }
        }

        public static void sleep(int ms)
        {
            Thread.Sleep(ms);
        }

        public static void busyWait(long ms)
        {
            long start = DateTime.Now.Ticks / TimeSpan.TicksPerMillisecond;
            while (start + ms >= DateTime.Now.Ticks / TimeSpan.TicksPerMillisecond)
            {
                // wait
            }
        }

        public static void await(object condition)
        {
            try
            {
                Monitor.Wait(condition);
            }
            catch (ThreadInterruptedException)
            {
                // ignore
            }
        }

        public static bool await(object condition, int time)
        {
            try
            {
                return Monitor.Wait(condition, time);
            }
            catch (ThreadInterruptedException)
            {
                // ignore
                return false;
            }
        }
    }
}