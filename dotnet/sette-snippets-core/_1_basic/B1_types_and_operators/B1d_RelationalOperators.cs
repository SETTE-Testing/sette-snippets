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
    public static class B1d_RelationalOperators
    {
        public static bool equal(int x, int y)
        {
            return x == y;
        }

        public static bool notEqual(int x, int y)
        {
            return x != y;
        }

        public static bool smaller(int x, int y)
        {
            return x < y;
        }

        public static bool smallerOrEqual(int x, int y)
        {
            return x <= y;
        }


        public static bool greater(int x, int y)
        {
            return x > y;
        }

        public static bool greaterOrEqual(int x, int y)
        {
            return x >= y;
        }

        public static bool and(bool x, bool y)
        {
            return x && y;
        }

        public static bool or(bool x, bool y)
        {
            return x || y;
        }


        public static bool negate(bool x)
        {
            return !x;
        }
    }
}