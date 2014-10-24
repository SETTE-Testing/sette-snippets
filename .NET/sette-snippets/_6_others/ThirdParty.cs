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
using BME.MIT.SETTE.External;

namespace BME.MIT.SETTE.Others
{
    public static class ThirdParty
    {
        public static bool minMax(int a, int b)
        {
            if (MyMath.min(a, b) == -10 && MyMath.max(a, b) == 20)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool minMaxWithOrder(int a, int b)
        {
            if (MyMath.min(a, b) == -10 && MyMath.max(a, b) == 20 && a < b)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool minMaxImpossible(int a, int b)
        {
            if (MyMath.min(a, b) == -10 && MyMath.max(a, b) == 10
                    && Math.Max(a, b) == 20)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return false;
            }
        }
    }
}