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

using BME.MIT.SETTE.Others.Dependencies;

namespace BME.MIT.SETTE.Others
{
    public static class Others_Varargs
    {
        public static int varargsGuess(params int[] numbers)
        {
            if (numbers == null || numbers.Length < 2)
            {
                // make safe
                return -1;
            }

            if (numbers[0] == 1 && numbers[1] == 2)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public static int varargsGuessWithLength(params int[] numbers)
        {
            if (numbers == null)
            {
                // make safe
                return -1;
            }

            if (numbers.Length == 3 && numbers[0] == 1 && numbers[1] == 2)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public static int[] varargsIterateWithFor(params int[] numbers)
        {
            if (numbers == null)
            {
                // make safe
                return new int[0];
            }
            else if (numbers.Length > 3)
            {
                // prevent path explosion
                return new int[0];
            }

            int[] ret = new int[numbers.Length];

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] > 0)
                {
                    ret[i] = 1;
                }
            }

            return numbers;
        }

        public static int[] varargsIterateWithForeach(params int[] numbers)
        {
            if (numbers == null)
            {
                // make safe
                return new int[0];
            }
            else if (numbers.Length > 3)
            {
                // prevent path explosion
                return new int[0];
            }

            int[] ret = new int[numbers.Length];

            int i = 0;
            foreach (int n in numbers)
            {
                if (n > 0)
                {
                    ret[i] = 1;
                }
                i++;
            }

            return numbers;
        }
    }
}