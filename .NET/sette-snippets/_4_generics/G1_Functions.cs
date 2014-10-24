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

using BME.MIT.SETTE.Generics.Dependencies;

namespace BME.MIT.SETTE.Generics
{
    public static class G1_Functions
    {
        //@SetteRequiredStatementCoverage(value = 80)
        public static int guessType<T>(T o)
        {
            if (o == null)
            {
                return 0;
            }
            else if (o is int)
            {
                return 1;
            }
            else if (o is double)
            {
                return 2;
            }
            else if (o is object)
            {
                return 3;
            }
            else
            {
                // impossible branch
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 88)
        public static int guessTypeAndUse<T>(T o)
        {
            if (o == null)
            {
                return 0;
            }
            else if (o is int)
            {
                int i = (int)(object)o;

                if (i > 0)
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else if (o is double)
            {
                double d = (double)(object)o;

                if (d > 0)
                {
                    return 2;
                }
                else
                {
                    return -2;
                }
            }
            else if (o is object)
            {
                return 3;
            }
            else
            {
                // impossible branch
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 60)
        public static int guessTypeWithExtends<T>(T o) where T : IComparable<T>
        {
            // similar to <T extends Number> in Java
            // no common Number base class/interface in .NET
            if (o == null)
            {
                return 0;
            }
            else if (o is int)
            {
                return 1;
            }
            else if (o is double)
            {
                return 2;
            }
            else if (o is object)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                // impossible branch
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 77)
        public static int guessTypeWithExtendsAndUse<T>(T o) where T : IComparable<T>
        {
            // similar to <T extends Number> in Java
            // no common Number base class/interface in .NET
            if (o == null)
            {
                return 0;
            }
            else if (o is int)
            {
                int i = (int)(object)o;

                if (i > 0)
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else if (o is double)
            {
                double d = (double)(object)o;

                if (d > 0)
                {
                    return 2;
                }
                else
                {
                    return -2;
                }
            }
            else if (o is object)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                // impossible branch
                throw new Exception();
            }
        }
    }
}