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

using BME.MIT.SETTE.Multithreading.Dependencies;
using System.Threading;

namespace BME.MIT.SETTE.Multithreading
{
    public static class T1_Threads
    {
        // @SetteRequiredStatementCoverage(100)
        public static int canNameThread()
        {
            string tn = Thread.CurrentThread.Name;
            if ("custom thread name".Equals(tn))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(30)
        public static int canInterruptSleep()
        {
            try
            {
                Thread.Sleep(int.MaxValue);
                return 0; // never reaches
            }
            catch (ThreadInterruptedException)
            {
                return 1;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int canStartEnoughThreads(int maxDepth)
        {
            Thread t = new Thread(() =>
            {
                forkBomb(0, maxDepth);
            });

            t.Start();

            while (t.IsAlive)
            {
                // for maxDepth 10-15 it usually works
                int tc = System.Diagnostics.Process.GetCurrentProcess().Threads.Count;
                if (20 <= tc && tc <= 50)
                {
                    return 1;
                }
            }

            return 0;
        }

        private static void forkBomb(int depth, int maxDepth)
        {
            if (depth > maxDepth)
            {
                return;
            }

            new Thread(() =>
            {
                forkBomb(depth + 1, maxDepth);
                forkBomb(depth + 1, maxDepth);
            }).Start();

            ThreadUtils.sleep(100);
        }
    }
}