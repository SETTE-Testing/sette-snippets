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

namespace BME.MIT.SETTE.Library
{
    public static class L3_Wrappers
    {
        // no real wrappers in .NET
        public static int guessInteger(int a)
        {
            int i = 2;

            if (a == 1)
            {
                return 1;
            }
            else if (a.Equals(i))
            {
                return 2;
            }
            else
            {
                return -1;
            }
        }

        public static int integerOverflow(int a, int b)
        {
            int sum = a + b;

            if (sum < a || sum < b)
            {
                return int.MaxValue;
            }
            else
            {
                return sum;
            }
        }

        public static double guessDouble(double a)
        {
            double d = 2;

            if (a == 1)
            {
                return 1.0;
            }
            else if (a.Equals(d))
            {
                return 2.0;
            }
            else
            {
                return -1.0;
            }
        }
    }
}