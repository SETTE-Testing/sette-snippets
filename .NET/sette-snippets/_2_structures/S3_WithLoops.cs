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

using BME.MIT.SETTE.Structures.Dependencies;

namespace BME.MIT.SETTE.Structures
{
    public static class S3_WithLoops
    {
        public static int withLimitParams(int x, int y, int max)
        {
            CoordinateStructure c = new CoordinateStructure();
            c.x = x;
            c.y = y;

            int ret = 0;

            for (int i = 0; i < max && i < 10; i++)
            {
                if ((c.x + c.y) % 2 == 0)
                {
                    ret++;
                }
                else
                {
                    ret--;
                }
            }

            return ret;
        }

        public static int withLimit(CoordinateStructure c, int max)
        {
            int ret = 0;

            for (int i = 0; i < max && i < 10; i++)
            {
                if ((c.x + c.y) % 2 == 0)
                {
                    ret++;
                }
                else
                {
                    ret--;
                }
            }

            return ret;
        }

        public static int noLimitParams(int x, int y, int max)
        {
            CoordinateStructure c = new CoordinateStructure();
            c.x = x;
            c.y = y;

            int ret = 0;

            for (int i = 0; i < max; i++)
            {
                if ((c.x + c.y) % 2 == 0)
                {
                    ret++;
                }
                else
                {
                    ret--;
                }
            }

            return ret;
        }

        public static int noLimit(CoordinateStructure c, int max)
        {
            int ret = 0;

            for (int i = 0; i < max; i++)
            {
                if ((c.x + c.y) % 2 == 0)
                {
                    ret++;
                }
                else
                {
                    ret--;
                }
            }

            return ret;
        }

        public static int arrayOfStructuresParams(int[] xs, int[] ys)
        {
            if (xs == null || ys == null || xs.Length != ys.Length)
            {
                return 0;
            }

            CoordinateStructure[] cs = new CoordinateStructure[xs.Length];

            for (int i = 0; i < cs.Length; i++)
            {
                cs[i] = new CoordinateStructure();
                cs[i].x = xs[i];
                cs[i].y = ys[i];
            }

            int ret = 0;

            foreach (CoordinateStructure c in cs)
            {
                if ((c.x + c.y) % 2 == 0)
                {
                    ret++;
                }
                else
                {
                    ret--;
                }
            }

            return ret;
        }

        public static int arrayOfStructures(CoordinateStructure[] cs)
        {
            if (cs == null)
            {
                return 0;
            }

            int ret = 0;

            foreach (CoordinateStructure c in cs)
            {
                if ((c.x + c.y) % 2 == 0)
                {
                    ret++;
                }
                else
                {
                    ret--;
                }
            }

            return ret;
        }
    }
}