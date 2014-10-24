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
    public static class B5a_CallPublic
    {
        //@SetteNotSnippet
        public static int calledFunction(int x, int y)
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
                return -1;
            }
        }

        //@SetteIncludeCoverage(classes = { B5a_CallPublic.class }, methods = { "calledFunction(int, int)" })
        public static int simple(int x, int y)
        {
            return calledFunction(x, y);
        }

        //@SetteIncludeCoverage(classes = { B5a_CallPublic.class }, methods = { "calledFunction(int, int)" })
        public static int useReturnValue(int x, int y)
        {
            if (calledFunction(x, y) >= 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        //@SetteIncludeCoverage(classes = { B5a_CallPublic.class }, methods = { "calledFunction(int, int)" })
        public static int conditionalCall(int x, int y, bool z)
        {
            if (z)
            {
                return calledFunction(x, y);
            }
            else
            {
                return -2;
            }
        }
    }
}