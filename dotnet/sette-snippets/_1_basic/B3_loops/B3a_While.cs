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

namespace BME.MIT.SETTE.Basic.B3
{
    public static class B3a_While
    {
        /**
         * Calculates the sum of numbers from 1 to min(10, x)
         * 
         * @param x
         * @return
         */
        public static int withLimit(int x)
        {
            int i = 1;
            int sum = 0;

            while (i <= x && i <= 10)
            {
                sum += i;
                i++;
            }

            return sum;
        }

        /**
         * Calculates the sum of even numbers from 1 to min(10, x)
         * 
         * @param x
         * @return
         */
        public static int withConditionAndLimit(int x)
        {
            int i = 1;
            int sum = 0;

            while (i <= x && i <= 10)
            {
                if (i % 2 == 0)
                {
                    sum += i;
                }

                i++;
            }

            return sum;
        }

        /**
         * Calculates the sum of even numbers from 1 to x
         * 
         * @param x
         * @return
         */
        public static int withConditionNoLimit(int x)
        {
            int i = 1;
            int sum = 0;

            while (i <= x)
            {
                if (x % 2 == 0)
                {
                    sum += i;
                }

                i++;
            }

            return sum;
        }

        /**
         * Calculates the sum of even numbers from 1 to min(100, x)
         * 
         * @param x
         * @return
         */
        public static int withContinueBreak(int x)
        {
            int i = 1;
            int sum = 0;

            while (i <= x)
            {
                if (i % 2 != 0)
                {
                    i++;
                    continue;
                }

                if (i > 100)
                {
                    break;
                }

                sum += i;
                i++;
            }

            return sum;
        }

        /**
         * Calculates the sum of even numbers from 1 to min(limit, x), excluding
         * skip
         * 
         * @param x
         * @param limit
         *            When this number is reached the loop breaks
         * @param skip
         *            When this number is reached the loop continues
         * @param stop
         *            When this number is reached the loop immediately stops
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 78)
        public static int complex(int x, int limit, int skip, int stop)
        {
            int i = 1;
            int sum = 0;

            while (i <= x)
            {
                sum += i;

                if (i == limit)
                {
                    break;
                }
                else if (i == skip)
                {
                    i++;
                    continue;
                }
                else if (i == stop)
                {
                    return -1;
                }
                else if (sum < 0)
                {
                    // only if overflow
                    return -2;
                }
                else if (i < 0)
                {
                    // unreachable code
                    return -3;
                }

                i++;
            }

            return sum;
        }

        /**
         * Please note that the infinite loop may be removed by the compiler or JIT. <br/>
         * See {@link https
         * ://www.securecoding.cert.org/confluence/display/java/MSC01
         * -J.+Do+not+use+an+empty+infinite+loop}.
         * 
         * @param x
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 0)
        public static int infinite(int x)
        {
            while (true)
            {
            }
        }

        /**
         * Please note that it is highly unlikely that the infinite loop will be
         * removed by the compiler or JIT.
         * 
         * @param x
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 0)
        public static int infiniteNotOptimalizable(int x)
        {
            int i = 1;

            while (true)
            {
                if (i < 0)
                {
                    // unreachable code
                    return i;
                }

                i += x;

                if (i < 0)
                {
                    // only if overflow
                    i = 1;
                }
            }
        }

        public static int nestedLoop(int x, int y)
        {
            int i = 0, j = 0;
            int sum = 0;

            while (i < x && i < 10)
            {
                if (x % 2 == 0)
                {
                    while (j < y && i < 10)
                    {
                        if (j % 2 == 0)
                        {
                            sum += x * y;
                        }
                        j++;
                    }
                    i++;
                }
            }

            return sum;
        }

        public static int nestedLoopWithLabel(int x, int y)
        {
            // in C#.NET it is not allowed to break to a label, use goto instead
            int i = 0, j = 0;
            int sum = 0;

            while (i < x && i < 10)
            {
                if (x % 2 == 0)
                {
                    while (j < y && i < 10)
                    {
                        if (y == 6)
                        {
                            goto breakInnerLoop;
                        }
                        else if (x == 8 && y == 8)
                        {
                            goto breakOuterLoop;
                        }

                        if (j % 2 == 0)
                        {
                            sum += x * y;
                        }

                        j++;
                    }
                breakInnerLoop: i++;
                }
            }

        breakOuterLoop: return sum;
        }
    }
}