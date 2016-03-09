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

namespace BME.MIT.SETTE.Library.Dependencies
{
    // no base class for number types in .NET, extend Tuple<T1> instead
    public sealed class FingerNumber : Tuple<int>
    {
        public int Value
        {
            get
            {
                return Item1;
            }
        }

        public FingerNumber(int v)
            : base(v)
        {
            if (0 > v || v > 10)
            {
                throw new ArgumentException();
            }
        }

        public FingerNumber add(FingerNumber o)
        {
            int r = Value + o.Value;
            if (r > 10)
            {
                throw new ArgumentOutOfRangeException("Out of range");
            }
            return new FingerNumber(r);
        }
    }
}