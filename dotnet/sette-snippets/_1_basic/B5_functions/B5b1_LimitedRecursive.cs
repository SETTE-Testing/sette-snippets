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
 * Copyright 2014
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

namespace BME.MIT.SETTE.Basic.B5
{
    public static class B5b1_LimitedRecursive
    {
        //@SetteIncludeCoverage(classes = { B5b_LimitedRecursive.class }, methods = { "simple_(int, int)" })
        public static int simple(int x)
        {
            return simple_(x, 1);
        }

        private static int simple_(int x, int depth)
        {
            if (depth > 10)
            {
                return -1;
            }

            if (x % 100 == 0)
            {
                return x;
            }
            else
            {
                return simple_(x - 1, depth + 1);
            }
        }

        //@SetteIncludeCoverage(classes = { B5b_LimitedRecursive.class }, methods = { "fibonacci_(int, int)" })
        public static int fibonacci(int x)
        {
            return fibonacci_(x, 1);
        }

        private static int fibonacci_(int x, int depth)
        {
            if (depth > 10)
            {
                return 0;
            }

            if (x <= 0)
            {
                return 0;
            }
            else if (x == 1)
            {
                return 1;
            }
            else
            {
                return fibonacci_(x - 1, depth + 1)
                        + fibonacci_(x - 2, depth + 2);
            }
        }
    }
}