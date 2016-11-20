/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 *
 * SETTE is a tool to help the evaluation and comparison of symbolic execution based test input
 * generator tools.
 *
 * Budapest University of Technology and Economics (BME)
 *
 * Authors: Lajos Cseppentő <lajos.cseppento@inf.mit.bme.hu>, Zoltán Micskei <micskeiz@mit.bme.hu>
 *
 * Copyright 2014-2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

using BME.MIT.SETTE.Reflection.Dependencies;
using System;
using System.Reflection;

namespace BME.MIT.SETTE.Reflection.Tests
{
    public static class R1b_ClassWithLoading
    {
        private static Type loadClass(string className)
        {
            try
            {
                return Type.GetType(className);
            }
            catch (TypeLoadException)
            {
                return null;
            }
            catch (NullReferenceException)
            {
                return null;
            }
            catch (ArgumentException)
            {
                return null;
            }
        }

        //@SetteRequiredStatementCoverage(100)
        public static int guessClassByName(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }
            else if ("System.String".Equals(type.FullName))
            {
                return 1;
            }
            else if ("System.Int32[]".Equals(type.FullName))
            {
                return 2;
            }
            else if ("BME.MIT.SETTE.Reflection.Dependencies.MyClassParent"
                  .Equals(type.FullName))
            {
                return 3;
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(100)
        public static int guessClassBySimpleName(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }
            else if ("String".Equals(type.Name))
            {
                return 1;
            }
            else if ("Int32[]".Equals(type.Name))
            {
                return 2;
            }
            else if ("MyClassParent"
                  .Equals(type.Name))
            {
                return 3;
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(100)
        public static int guessClassByMethodWithoutParams(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }

            if (type.GetMethod("Value") == null)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessClassByMethodWithParams(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }

            if (type.GetMethod("Value", new Type[] { typeof(int) }) == null)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessClassByField(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }

            if (type.GetField("value", BindingFlags.NonPublic | BindingFlags.Instance) == null)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessClassByInterface(String className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }

            Type[] ifaces = type.GetInterfaces();

            if (ifaces.Length == 1 && ifaces[0] == typeof(MyInterface1))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessClassBySuperclass(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }
            else if (type.BaseType == typeof(MyClassParent))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessClassByAnnotation(string className)
        {
            Type type = loadClass(className);

            if (type == null)
            {
                return -1;
            }

            object[] attrs = type.GetCustomAttributes(typeof(MyClassAttribute), true);

            if (attrs.Length > 0)
            {
                MyClassAttribute attr = (MyClassAttribute)attrs[0];

                if (attr.Value)
                {
                    return 1;
                }
                else
                {
                    return 2;
                }
            }
            else
            {
                return 0;
            }
        }
    }
}