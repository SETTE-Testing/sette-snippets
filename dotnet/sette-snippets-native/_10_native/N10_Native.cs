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

using BME.MIT.SETTE.Native.Dependencies;
using System;

namespace BME.MIT.SETTE.Native
{
    public static class N10_Native
    {
        // @SetteRequiredStatementCoverage(100)
        public static int guessNumber(int x)
        {
            if (NativeFunction.fun(x) == 1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int reachState(int a, int b, int c)
        {
            NativeObject obj = new NativeObject();

            obj.calculate(a);
            obj.calculate(b);
            obj.calculate(c);

            if (obj.getX() == 2016)
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