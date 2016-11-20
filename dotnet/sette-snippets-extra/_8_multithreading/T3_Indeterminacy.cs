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
    public class T3_Indeterminacy
    {
        private volatile static bool success;

        // @SetteRequiredStatementCoverage(100)
        public static int raceCondition()
        {
            success = false;

            Thread t1 = new Thread(() =>
            {
                ThreadUtils.busyWait(200);
                success = false;
            });
            Thread t2 = new Thread(() =>
            {
                success = true;
            });

            ThreadUtils.startAll(t1, t2);
            ThreadUtils.joinAll(t1, t2);

            if (success)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        private static object lock1;
        private static object lock2;
        private volatile static int data;

        // @SetteRequiredStatementCoverage(100)
        public static int deadlock()
        {
            lock1 = new object();
            lock2 = new object();
            data = 0;

            Thread t1 = new Thread(() =>
            {
                lock (lock1)
                {
                    ThreadUtils.busyWait(100);
                    lock (lock2)
                    {
                        data++;
                    }
                }
            });
            Thread t2 = new Thread(() =>
            {
                lock (lock2)
                {
                    ThreadUtils.busyWait(100);
                    lock (lock1)
                    {
                        data++;
                    }
                }
            });

            ThreadUtils.startAll(t1, t2);
            ThreadUtils.joinAll(t1, t2);

            // happens ~0 out of 100 runs normally
            return data;
        }

        // @SetteRequiredStatementCoverage(100)
        public static int livelock()
        {
            SharedResource res = new SharedResource();
            SharedResourceUser u1 = new SharedResourceUser(res);
            SharedResourceUser u2 = new SharedResourceUser(res);

            u1.Thread.Start();
            ThreadUtils.sleep(50);
            u2.Thread.Start();

            ThreadUtils.joinAll(u1.Thread, u2.Thread);

            if (u1.isDone() && u2.isDone())
            {
                // happens ~0 out of 100 runs normally
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int starvation()
        {
            data = 0;

            Storage storage = new Storage();

            Thread producer = new Thread(() =>
            {
                for (int i = 1; i <= 10; i++)
                {
                    storage.put(i);
                }
            });

            Thread[] greedyConsumers = new Thread[5];
            for (int i = 0; i < greedyConsumers.Length; i++)
            {
                greedyConsumers[i] = new Thread(() =>
                {
                    while (true)
                    {
                        storage.get();
                    }
                });
                greedyConsumers[i].IsBackground = true;
            }

            Thread slowConsumer = new Thread(() =>
            {
                while (true)
                {
                    ThreadUtils.busyWait(50);
                    data = storage.get();
                }
            });
            slowConsumer.IsBackground = true;

            ThreadUtils.startAll(greedyConsumers);
            ThreadUtils.sleep(50); // wait for greedy consumers to start
            ThreadUtils.startAll(producer, slowConsumer);
            ThreadUtils.joinAll(producer);

            if (data > 0)
            {
                // happens ~0 out of 100 runs normally
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}