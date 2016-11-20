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
using System.Reflection;

namespace BME.MIT.SETTE.Reflection
{
    public static class R2a_MethodAsObject
    {
        // @SetteRequiredStatementCoverage(100)
        public static int guessMethodByNameAndDeclaringClass(MethodInfo m)
        {
            if (m == null)
            {
                return -1;
            }
            else if ("Value".Equals(m.Name) && m.DeclaringType == typeof(MyClassParent))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessMethodByNameAndReturnType(MethodInfo m)
        {
            if (m == null)
            {
                return -1;
            }
            else if ("Value".Equals(m.Name) && m.ReturnType == typeof(int))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessMethodByNameAndParameter(MethodInfo m)
        {
            if (m == null)
            {
                return -1;
            }

            ParameterInfo[] parameters = m.GetParameters();

            if ("Value".Equals(m.Name) && parameters.Length == 1 && parameters[0].ParameterType == typeof(int))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(100)
        public static int guessMethodByAnnotation(MethodInfo m)
        {
            if (m == null)
            {
                return -1;
            }

            object[] attrs = m.GetCustomAttributes(typeof(MyMethodAttribute), true);

            if (attrs.Length > 0)
            {
                MyMethodAttribute attr = (MyMethodAttribute)attrs[0];

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