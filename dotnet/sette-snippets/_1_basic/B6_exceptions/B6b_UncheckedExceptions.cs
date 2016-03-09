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

using BME.MIT.SETTE.Basic.B6.Dependencies;
using System;

namespace BME.MIT.SETTE.Basic.B6
{
    // all exceptions in C# are unchecked
    public static class B6b_UncheckedExceptions
    {
        public static void always()
        {
            throw new Exception();
        }

        public static int conditionalAndLoop(int x)
        {
            if (x < 0)
            {
                throw new Exception();
            }

            int sum = 0;
            for (int i = 1; i <= x; i++)
            {
                sum += i;

                if (i >= 10)
                {
                    throw new Exception();
                }
            }

            return sum;
        }

        private static int calledFunction(int x, int y)
        {
            if (x > 0 && y > 0)
            {
                return 1;
            }
            else if (x < 0 && y > 0)
            {
                return 2;
            }
            else if (x < 0 && y < 0)
            {
                return 3;
            }
            else if (x > 0 && y < 0)
            {
                return 4;
            }
            else
            {
                throw new Exception();
            }
        }

        public static int call(int x, int y)
        {
            return calledFunction(x, y);
        }

        public static int recursive(int x)
        {
            return recursive_(x, 1);
        }

        private static int recursive_(int x, int depth)
        {
            if (depth >= 10)
            {
                throw new Exception();
            }

            if (x % 100 == 0)
            {
                return x;
            }
            else
            {
                return B6b_UncheckedExceptions.recursive_(x - 1, depth + 1);
            }
        }

        public static int tryCatch(int x, int y)
        {
            try
            {
                return B6b_UncheckedExceptions.calledFunction(x, y);
            }
            catch (Exception)
            {
                throw new Exception();
            }
        }

        public static int tryCatchFinally(int x, int y, int z)
        {
            int returnValue = 0;
            try
            {
                return B6b_UncheckedExceptions.calledFunction(x, y);
            }
            catch (Exception)
            {
                throw new MyException();
            }
            finally
            {
                // note: return statements in the finally block is not advised
                // - it overwrites the original return value
                // - it absorbs the thrown exception

                // In C# return statement not possible
                if (z > 0)
                {
                    returnValue = -1;
                }
                else if (z < 0)
                {
                    returnValue = -2;
                }

                // return statement in the finally block causes compile error
            }

            // this is intended, even if it is unreachable
#pragma warning disable
            return returnValue;
#pragma warning enable
        }
    }
}