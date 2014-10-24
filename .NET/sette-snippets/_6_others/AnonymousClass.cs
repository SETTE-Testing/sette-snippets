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

using BME.MIT.SETTE.Others.Dependencies;

namespace BME.MIT.SETTE.Others
{
    public static class AnonymousClass
    {
        // Anonymous class is a different concept in .NET, the Java anonymous class equivalent feature is delegate.
        public delegate int Method(int x);

        public static int test(int x)
        {
            //AnonymousClassInterface a = new AnonymousClassInterface() {			
            //    public int method(int x) {
            //        if (x < 0) {
            //            return -x;
            //        } else {
            //            return x;
            //        }
            //    }
            //};

            Method method = delegate(int x_)
            {
                if (x_ < 0)
                {
                    return -x_;
                }
                else
                {
                    return x_;
                }
            };

            return method(x);
        }
    }
}