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
    public static class B2d_Linear
    {
        /**
         * Equation: 20x+2 = 42<br/>
         * Solution: x = 2
         * 
         * @param x
         * @return
         */
        public static bool oneParamInt(int x)
        {
            if (20 * x + 2 == 42)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 20x+2 = 41<br/>
         * Solution: x = 1 (not integer)
         * 
         * @param x
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 50)
        public static bool oneParamIntNoSolution(int x)
        {
            if (20 * x + 2 == 41)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y = 3<br/>
         * 3x+4y = 11<br/>
         * <br/>
         * Solution: {x, y} = {5, -1}
         * 
         * @param x
         * @param y
         * @return
         */
        public static bool twoParamsInt(int x, int y)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            int e1 = x + 2 * y;
            int e2 = 3 * x + 4 * y;

            if (e1 == 3 && e2 == 11)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y = 3<br/>
         * 3x+4y = 10<br/>
         * <br/>
         * Solution: {x, y} = {4, -0.5} (not integer)
         * 
         * @param x
         * @param y
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 66)
        public static bool twoParamsIntNoSolution(int x, int y)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            int e1 = x + 2 * y;
            int e2 = 3 * x + 4 * y;

            if (e1 == 3 && e2 == 10)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y+3z = 9<br/>
         * 3x+y-2z = 10<br/>
         * 5x-y-z = 24<br/>
         * <br/>
         * Solution: {x, y, z} = {5, -1, 2}
         * 
         * @param x
         * @param y
         * @param z
         * @return
         */
        public static bool threeParamsInt(int x, int y, int z)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            int e1 = x + 2 * y + 3 * z;
            int e2 = 3 * x + y - 2 * z;
            int e3 = 5 * x - y - z;

            if (e1 == 9 && e2 == 10 && e3 == 24)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y+3z = 9<br/>
         * 3x+y-2z = 10<br/>
         * 5x-y-z = 23<br/>
         * <br/>
         * Solution: {x, y, z} = {198/41, -30/41, 77/41}<br/>
         * Solution with overflow (32bit integer): {x, y, z} = {-1257063594,
         * 1361818898, 942797701}
         * 
         * @param x
         * @param y
         * @param z
         * @return
         */
        //@SetteRequiredStatementCoverage(value = 71)
        public static bool threeParamsIntNoSolution(int x, int y, int z)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            int e1 = x + 2 * y + 3 * z;
            int e2 = 3 * x + y - 2 * z;
            int e3 = 5 * x - y - z;

            if (e1 == 9 && e2 == 10 && e3 == 23)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 20x+2 = 17<br/>
         * Solution: x = 0.75
         * 
         * (0.75 = 3/4 can be precisely represented, see IEEE 754)
         * 
         * @param x
         * @return
         */
        public static bool oneParamFloat(float x)
        {
            if (20 * x + 2 == 17)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y = 3<br/>
         * 3x+4y = 10<br/>
         * <br/>
         * Solution: {x, y} = {4, -0.5}
         * 
         * (-0.5 = -1/2 can be precisely represented, see IEEE 754)
         * 
         * @param x
         * @param y
         * @return
         */
        public static bool twoParamsFloat(float x, float y)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            float e1 = x + 2 * y;
            float e2 = 3 * x + 4 * y;

            if (e1 == 3 && e2 == 10)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y+3z = 9<br/>
         * 3x+y-2z = 10<br/>
         * 5x-y-z = 23<br/>
         * <br/>
         * Solution: {x, y, z} = {198/41, -30/41, 77/41}<br/>
         * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
         * they may not be supported)
         * 
         * @param x
         * @param y
         * @param z
         * @return
         */
        public static bool threeParamsFloat(float x, float y, float z)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            float e1 = x + 2 * y + 3 * z;
            float e2 = 3 * x + y - 2 * z;
            float e3 = 5 * x - y - z;

            if (8.999f < e1 && e1 < 9.001f && 9.999f < e2 && e2 < 10.001f
                    && 22.999f < e3 && e3 < 23.001f)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation: 20x+2 = 17<br/>
         * Solution: x = 0.75
         * 
         * (0.75 = 3/4 can be precisely represented, see IEEE 754)
         * 
         * @param x
         * @return
         */
        public static bool oneParamDouble(double x)
        {
            if (20 * x + 2 == 17)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y = 3<br/>
         * 3x+4y = 10<br/>
         * <br/>
         * Solution: {x, y} = {4, -0.5}
         * 
         * (-0.5 = -1/2 can be precisely represented, see IEEE 754)
         * 
         * @param x
         * @param y
         * @return
         */
        public static bool twoParamsDouble(double x, double y)
        {
            // it is usual that the results are saved into variables and the
            // variables are used in conditional statements
            double e1 = x + 2 * y;
            double e2 = 3 * x + 4 * y;

            if (e1 == 3 && e2 == 10)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Equation system:<br/>
         * <br/>
         * x+2y+3z = 9<br/>
         * 3x+y-2z = 10<br/>
         * 5x-y-z = 23<br/>
         * <br/>
         * Solution: {x, y, z} = {198/41, -30/41, 77/41} <br/>
         * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
         * they may not be supported)
         * 
         * @param x
         * @param y
         * @param z
         * @return
         */
        public static bool threeParamsDouble(double x, double y, double z)
        {
            double e1 = x + 2 * y + 3 * z;
            double e2 = 3 * x + y - 2 * z;
            double e3 = 5 * x - y - z;

            if (8.999 < e1 && e1 < 9.001 && 9.999 < e2 && e2 < 10.001
                    && 22.999 < e3 && e3 < 23.001)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}