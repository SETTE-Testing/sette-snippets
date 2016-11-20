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

namespace BME.MIT.SETTE.Reflection
{
    public static class R3_ObjectsAndReflection
    {
        // @SetteRequiredStatementCoverage(100)
        public static int guessObjectWithClass(Object o)
        {
            if (o == null)
            {
                return -1;
            }
            else if (o.GetType() == typeof(MyClassChild))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessObjectWithInstanceOfClass(object o)
        {
            if (o == null)
            {
                return -1;
            }
            else if (o is MyClassChild)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessObjectWithInstanceOfInterface(object o)
        {
            if (o == null)
            {
                return -1;
            }
            else if (o is MyInterface2)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        // @SetteIncludeCoverage(classes = { MyClassParent.class }, methods = "value(int)")
        public static int useObjectWithDirectCall(object o, int v)
        {
            if (o == null)
            {
                return -1;
            }
            else if (o is MyClassChild)
            {
                MyClassChild obj = (MyClassChild)o;
                obj.Value(v);
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        // @SetteIncludeCoverage(classes = { MyClassParent.class }, methods = "value(int)")
        public static int useObjectWithInvoke(object o, string methodName, int v)
        {
            if (o == null)
            {
                return -1;
            }
            else if (o is MyClassChild)
            {
                MethodInfo m;
                try
                {
                    Type[] parameterTypes = { typeof(int) };
                    m = o.GetType().GetMethod(methodName, parameterTypes);
                    m.Invoke(o, new object[] { v });
                    return 1;
                }
                catch (Exception)
                {
                    return 2;
                }
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int instantiateObject(Type type)
        {
            if (type == null)
            {
                return -1;
            }

            try
            {
                object o = Activator.CreateInstance(type);

                if (o is MyClassChild)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            catch (Exception)
            {
                return -2;
            }
        }
    }
}