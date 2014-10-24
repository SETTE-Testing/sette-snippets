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
    public static class G2_Objects
    {
        public static bool guessInteger(GenericTriplet<int> obj)
        {
            int i = 1;
            if (obj.get(0).Equals(i))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // No direct method for wildcard 
        public static bool guessIntegerNoHelp<T>(GenericTriplet<T> obj)
        {
            int i = 1;
            if (obj.get(0).Equals(i))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool guessImpossible(GenericTriplet<double> obj)
        {
            if (obj.get(0).Equals(new object()))
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        public static bool guessDescendant(IntegerTriplet obj)
        {
            int i = 1;
            if (obj.get(0).Equals(i))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool guessSafe<T>(SafeGenericTriplet<T> obj)
        {
            if (obj.get(4) != null)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool guessSafeNoHelp<T>(GenericTriplet<T> obj)
        {
            if (obj.get(4) != null)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return false;
            }
        }
    }
}