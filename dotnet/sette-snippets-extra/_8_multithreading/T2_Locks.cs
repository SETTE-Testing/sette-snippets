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
    public static class T2_Locks
    {
        // @SetteRequiredStatementCoverage(100)
        public static int createsLock(object lockObject)
        {
            if (lockObject == null)
            {
                return -1;
            }
            else if (Monitor.TryEnter(lockObject))
            {
                Monitor.Exit(lockObject);
                return 1;
            }
            else
            {
                return 0;
            }
        }

        private static volatile bool success;

        // @SetteRequiredStatementCoverage(100)
        public static int signalAwait(int x)
        {
            success = false;
            object lockObject = new object();

            Thread t1 = new Thread(() =>
            {
                ThreadUtils.sleep(50);
                Monitor.Enter(lockObject);
                try
                {
                    if (x == 12345)
                    {
                        Monitor.Pulse(lockObject);
                    }
                }
                finally
                {
                    Monitor.Exit(lockObject);
                }
            });
            Thread t2 = new Thread(() =>
            {
                Monitor.Enter(lockObject);
                try
                {
                    success = ThreadUtils.await(lockObject, 100);
                }
                finally
                {
                    Monitor.Exit(lockObject);
                }
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
    }
}