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

namespace BME.MIT.SETTE.Basic.B1
{
    public static class B1e_BitwiseOperators
    {
        public static int shiftLeft(int x, int y)
        {
            return x << y;
        }

        public static int shiftLeftAssignment(int x, int y)
        {
            x <<= y;
            return x;
        }

        public static int shiftRight(int x, int y)
        {
            return x >> y;
        }

        public static int shiftRightAssignment(int x, int y)
        {
            x >>= y;
            return x;
        }

        public static int shiftRightUnsigned(int x, int y)
        {
            // no >>> operator in C#
            return x >> y;
        }

        public static int shiftRightUnsignedAssignment(int x, int y)
        {
            // no >>>= operator in C#
            x >>= y;
            return x;
        }

        public static int and(int x, int y)
        {
            return x & y;
        }

        public static int andAssignment(int x, int y)
        {
            x &= y;
            return x;
        }

        public static int or(int x, int y)
        {
            return x | y;
        }

        public static int orAssignment(int x, int y)
        {
            x |= y;
            return x;
        }

        public static int xor(int x, int y)
        {
            return x ^ y;
        }

        public static int xorAssignment(int x, int y)
        {
            x ^= y;
            return x;
        }

        public static int negate(int x)
        {
            return ~x;
        }
    }
}