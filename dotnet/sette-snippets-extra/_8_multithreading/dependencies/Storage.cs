﻿/*
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

using System.Runtime.CompilerServices;
using System.Threading;

namespace BME.MIT.SETTE.Multithreading.Dependencies
{
    public class Storage
    {
        private volatile int data;
        private volatile bool hasData;

        [MethodImpl(MethodImplOptions.Synchronized)]
        public int get()
        {
            while (!hasData)
            {
                try
                {
                    Monitor.Wait(this);
                }
                catch (ThreadInterruptedException)
                {
                    // ignore
                }
            }

            hasData = false;
            Monitor.PulseAll(this);
            return data;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void put(int value)
        {
            while (hasData)
            {
                try
                {
                    Monitor.Wait(this);
                }
                catch (ThreadInterruptedException)
                {
                    // ignore
                }
            }

            data = value;
            hasData = true;
            Monitor.PulseAll(this);
        }
    }
}