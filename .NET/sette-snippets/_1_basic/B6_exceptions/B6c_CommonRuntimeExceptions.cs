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

namespace BME.MIT.SETTE.Basic.B6
{
    public static class B6c_CommonRuntimeExceptions
    {
        public static int arithmeticException(bool b)
        {
            if (b)
            {
                throw new ArithmeticException();
            }
            return 1;
        }

        public static int arrayIndexOutOfBoundsException(bool b)
        {
            if (b)
            {
                throw new IndexOutOfRangeException();
            }
            return 1;
        }

        public static int classCastException(bool b)
        {
            if (b)
            {
                throw new InvalidCastException();
            }
            return 1;
        }

        public static int illegalArgumentException(bool b)
        {
            if (b)
            {
                throw new ArgumentException();
            }
            return 1;
        }

        public static int illegalStateException(bool b)
        {
            if (b)
            {
                // InvalidOperationException is the .NET equivalent
                throw new InvalidOperationException();
            }
            return 1;
        }

        public static int indexOutOfBoundsException(bool b)
        {
            if (b)
            {
                throw new IndexOutOfRangeException();
            }
            return 1;
        }

        public static int nullPointerException(bool b)
        {
            if (b)
            {
                throw new NullReferenceException();
            }
            return 1;
        }

        public static int securityException(bool b)
        {
            if (b)
            {
                throw new System.Security.SecurityException();
            }
            return 1;
        }

        public static int unsupportedOperationException(bool b)
        {
            if (b)
            {
                // NotSupportedException is the .NET equivalent
                throw new NotSupportedException();
            }
            return 1;
        }
    }
}