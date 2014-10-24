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
    public static class S1_BasicUsage
    {
        public static int useStructureParams(int x, int y)
        {
            CoordinateStructure c = new CoordinateStructure();

            c.x = x;
            c.y = y;

            return c.x + c.y;
        }

        public static int useStructure(CoordinateStructure c)
        {
            return c.x + c.y;
        }

        public static CoordinateStructure returnStructureParams(int x, int y)
        {
            CoordinateStructure c = new CoordinateStructure();
            c.x = x;
            c.y = y;

            c.x = -c.x;
            c.y = -c.y;

            return c;
        }

        public static CoordinateStructure returnStructure(
                CoordinateStructure c)
        {
            c.x = -c.x;
            c.y = -c.y;

            return c;
        }
    }
}