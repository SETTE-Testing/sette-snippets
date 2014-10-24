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

namespace BME.MIT.SETTE.Basic.B2
{
    public static class B2b_Ternary
    {
        public static bool oneParamBoolean(bool x)
        {
            return x ? true : false;
        }

        public static bool twoParamsBoolean(bool x, bool y)
        {
            return x && y ? true : false;
        }

        public static int oneParamInt(int x)
        {
            return x == 5 ? 1 : 0;
        }

        public static int twoParamsInt(int x, int y)
        {
            return x == 5 && y == 10 ? 1 : 0;
        }
    }
}