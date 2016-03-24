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

namespace BME.MIT.SETTE.Library
{
    public static class L1_Arithmetics
    {
        public static double EPSILON = 10e-3;

        public static bool abs(int x, int y)
        {
            if (Math.Abs(x) == 5 || Math.Abs(y) == 10)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool absImpossible(int x, int y)
        {
            if (Math.Abs(x) == -5 || Math.Abs(y) == -10)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        public static bool minMax(int a, int b)
        {
            if (Math.Min(a, b) == -10 && Math.Max(a, b) == 20)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool minMaxWithOrder(int a, int b)
        {
            if (Math.Min(a, b) == -10 && Math.Max(a, b) == 20 && a < b)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool minMaxImpossible(int a, int b)
        {
            if (Math.Min(a, b) == -10 && Math.Max(a, b) == 10
                    && Math.Max(a, b) == 20)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        public static bool sqrt(double x)
        {
            double s = Math.Sqrt(x) - 2;

            if (-L1_Arithmetics.EPSILON < s && s < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool sqrtImpossible(double x)
        {
            if (Math.Sqrt(x) == -1)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        public static bool cbrt(double x)
        {
            // no cbrt in Math
            double c = Math.Pow(x, 1 / 3) - 2;

            if (-L1_Arithmetics.EPSILON < c && c < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool powGuessBase(double x)
        {
            double p = Math.Pow(x, 10) - 1024;

            if (-L1_Arithmetics.EPSILON < p && p < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool powGuessExponent(double x)
        {
            double p = Math.Pow(2, x) - 1024;

            if (-L1_Arithmetics.EPSILON < p && p < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool powGuessBaseAndExponent(double x, double y)
        {
            double p = Math.Pow(x, y) - 1024;

            if (-L1_Arithmetics.EPSILON < p && p < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool log10GuessArgument(double x)
        {
            double l = Math.Log10(x) - 2;

            if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool logGuessBase(double x)
        {
            double l = Math.Log(100) / Math.Log(x) - 2;

            if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool logGuessArgument(double x)
        {
            double l = Math.Log(x) / Math.Log(10) - 2;

            if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool logGuessBaseAndArgument(double x, double y)
        {
            double l = Math.Log(x) / Math.Log(y) - 2;

            if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool sin(double x)
        {
            double s = Math.Sin(x) - 0.5;

            if (-L1_Arithmetics.EPSILON < s && s < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool sinImpossible(double x)
        {
            if (Math.Sin(x) == 2)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        public static bool cos(double x)
        {
            double c = Math.Cos(x) - 0.5;

            if (-L1_Arithmetics.EPSILON < c && c < L1_Arithmetics.EPSILON)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //@SetteRequiredStatementCoverage(value = 50)
        public static bool cosImpossible(double x)
        {
            if (Math.Cos(x) == 2)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return false;
            }
        }

        public static bool tan(double x)
        {
            double t = Math.Tan(x) - 1;

            if (-L1_Arithmetics.EPSILON < t && t < L1_Arithmetics.EPSILON)
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