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

using BME.MIT.SETTE.Objects.Dependencies;

namespace BME.MIT.SETTE.Objects
{
    public static class O3c_Abstract
    {
        public static int guess(MyAbstract obj, int v)
        {
            if (obj == null)
            {
                return -1;
            }

            obj.setValue(v);

            if (obj.getValue() == 10)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 71)
        public static int validate(MyAbstract obj, int v)
        {
            if (obj == null)
            {
                return -1;
            }

            obj.setValue(v);

            if (obj.getValue() == v)
            {
                return 1;
            }
            else
            {
                // impossible, no such an implementation is present
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 71)
        public static int guessImpossible(MyAbstract obj, int v)
        {
            if (obj == null)
            {
                return -1;
            }

            obj.setValue(v);

            if (obj.getValue() == v + 1)
            {
                // impossible, no such an implementation is present
                throw new Exception();
            }
            else
            {
                return 1;
            }
        }
    }
}