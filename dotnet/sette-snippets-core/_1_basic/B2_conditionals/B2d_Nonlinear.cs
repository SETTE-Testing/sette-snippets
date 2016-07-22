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

namespace BME.MIT.SETTE.Basic.B2
{
    public static class B2d_Nonlinear
    {
        /**
         * Equation: x²+3x-10 = 0<br/>
         * Solution: {x1, x2} = {-5, 2}
         * 
         * @param x1
         * @param x2
         * @return
         */
        public static bool quadraticInt(int x1, int x2)
        {
            int e1 = x1 * x1 + 3 * x1 - 10;
            int e2 = x2 * x2 + 3 * x2 - 10;

            if (e1 == 0 && e2 == 0 && x1 < x2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 2x²+3x-10 = 0<br/>
         * Solution: {x1, x2} = {-3.108495, 1.608495} (not integer)
         * 
         * @param x1
         * @param x2
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 66)
        public static bool quadraticIntNoSolution(int x1, int x2)
        {
            int e1 = 2 * x1 * x1 + 3 * x1 - 10;
            int e2 = 2 * x2 * x2 + 3 * x2 - 10;

            if (e1 == 0 && e2 == 0 && x1 < x2)
            {
                // impossible
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 2x²+3x-10 = 0 <br/>
         * Solution: {x1, x2} = {-3.108495, 1.608495}<br/>
         * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
         * they may not be supported)
         * 
         * @param x1
         * @param x2
         * @return
         */
        public static bool quadraticFloat(float x1, float x2)
        {
            float e1 = 2 * x1 * x1 + 3 * x1 - 10;
            float e2 = 2 * x2 * x2 + 3 * x2 - 10;

            if (-0.001f < e1 && e1 < 0.001f && -0.001f < e2 && e2 < 0.001f
                    && (x1 + 0.001f) < (x2 - 0.001f))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 2x²+3x+10 = 0 <br/>
         * Solution: {x1, x2} = {-0.75-2.1065i, -0.75+2.1065i} (not real)<br/>
         * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
         * they may not be supported)
         * 
         * @param x1
         * @param x2
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 66)
        public static bool quadraticFloatNoSolution(float x1, float x2)
        {
            float e1 = 2 * x1 * x1 + 3 * x1 + 10;
            float e2 = 2 * x2 * x2 + 3 * x2 + 10;

            if (-0.001f < e1 && e1 < 0.001f && -0.001f < e2 && e2 < 0.001f
                    && (x1 + 0.001f) < (x2 - 0.001f))
            {
                // impossible
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 2x²+3x-10 = 0 <br/>
         * Solution: {x1, x2} = {-3.108495, 1.608495}<br/>
         * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
         * they may not be supported)
         * 
         * @param x1
         * @param x2
         * @return
         */
        public static bool quadraticDouble(double x1, double x2)
        {
            double e1 = 2 * x1 * x1 + 3 * x1 - 10;
            double e2 = 2 * x2 * x2 + 3 * x2 - 10;

            if (-0.001 < e1 && e1 < 0.001 && -0.001 < e2 && e2 < 0.001
                    && (x1 + 0.001) < (x2 - 0.001))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 2x²+3x+10 = 0 <br/>
         * Solution: {x1, x2} = {-0.75-2.1065i, -0.75+2.1065i} (not real)<br/>
         * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
         * they may not be supported)
         * 
         * @param x1
         * @param x2
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 66)
        public static bool quadraticDoubleNoSolution(double x1, double x2)
        {
            double e1 = 2 * x1 * x1 + 3 * x1 + 10;
            double e2 = 2 * x2 * x2 + 3 * x2 + 10;

            if (-0.001 < e1 && e1 < 0.001 && -0.001 < e2 && e2 < 0.001
                    && (x1 + 0.001) < (x2 - 0.001))
            {
                // impossible
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}