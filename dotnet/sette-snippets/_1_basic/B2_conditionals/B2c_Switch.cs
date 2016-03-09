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
    public static class B2c_Switch
    {
        public static int simple(int x)
        {
            int ret;

            switch (x)
            {
                case 0:
                    ret = 0;
                    break;

                case 1:
                    ret = 1;
                    break;

                case 2:
                    ret = 4;
                    break;

                default:
                    ret = -1;
                    break;
            }

            return ret;
        }

        public static int missingBreaks(int x)
        {
            // compiler error would be on missing break, explicit fall through is required
            int ret;

            switch (x)
            {
                case 0:
                    ret = 0;
                    goto case 1; // miss break

                case 1:
                    ret = 1;
                    break;

                case 2:
                    ret = 4;
                    // compiler error would be on missing break
                    goto default; // miss break

                default:
                    ret = -1;
                    break;
            }

            return ret;
        }

        public static int withReturn(int x)
        {
            int ret;

            switch (x)
            {
                case 0:
                    return 0;

                case 1:
                    return 1;

                case 2:
                    ret = 4;
                    break;

                default:
                    ret = -1;
                    break;
            }

            return ret;
        }
    }
}