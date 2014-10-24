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
    public static class B1b_Constants
    {
        public static bool CONST_BOOLEAN = true;
        public static byte CONST_BYTE = 123;
        public static short CONST_SHORT = 12345;
        public static int CONST_INT = 1234567890;
        public static long CONST_LONG = 1234567890123456789L;
        public static float CONST_FLOAT = 12345.67890f;
        public static double CONST_DOUBLE = 1.2345678e90;
        public static char CONST_CHAR = 'C';

        public static bool constBoolean()
        {
            return B1b_Constants.CONST_BOOLEAN;
        }

        public static byte constByte()
        {
            return B1b_Constants.CONST_BYTE;
        }

        public static short constShort()
        {
            return B1b_Constants.CONST_SHORT;
        }

        public static int constInt()
        {
            return B1b_Constants.CONST_INT;
        }

        public static long constLong()
        {
            return B1b_Constants.CONST_LONG;
        }

        public static float constFloat()
        {
            return B1b_Constants.CONST_FLOAT;
        }

        public static double constDouble()
        {
            return B1b_Constants.CONST_DOUBLE;
        }

        public static char constChar()
        {
            return B1b_Constants.CONST_CHAR;
        }
    }
}