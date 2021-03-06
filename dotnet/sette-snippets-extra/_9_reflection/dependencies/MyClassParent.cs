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

namespace BME.MIT.SETTE.Reflection.Dependencies
{
    [MyClassAttribute(true)]
    public class MyClassParent : MyInterface1
    {
        protected int value = 0;

        [MyMethodAttribute(true)]
        public void Value(int v)
        {
            if (v == 12345)
            {
                // just to make sure that the tools directly try this value to cover this branch
                this.value = 12345;
            }
            else if (v >= 0)
            {
                this.value = v;
            }
            else
            {
                this.value = -v;
            }
        }
    }
}