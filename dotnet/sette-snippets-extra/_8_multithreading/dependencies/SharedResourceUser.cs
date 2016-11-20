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

using System.Threading;

namespace BME.MIT.SETTE.Multithreading.Dependencies
{
    public class SharedResourceUser
    {
        private readonly Thread thread;
        private readonly SharedResource resource;
        private volatile bool done = false;

        public Thread Thread { get { return thread; } }

        public SharedResourceUser(SharedResource resource)
        {
            this.thread = new Thread(() =>
            {
                int trials = 0;
                while (resource.getUser() != this)
                {
                    if (trials > 10)
                    {
                        return;
                    }
                    // take the resource forcefully
                    trials++;
                    resource.setUser(this);
                    ThreadUtils.busyWait(100);
                }

                done = true;
            });

            this.resource = resource;
        }

        public bool isDone()
        {
            return done;
        }
    }
}