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
    public static class S4_StructureInStructure
    {
        public static int guessParams(int x1, int y1, int x2, int y2)
        {
            SegmentStructure s = new SegmentStructure();
            s.p1.x = x1;
            s.p1.y = y1;
            s.p2.x = x2;
            s.p2.y = y2;

            if (s.p1.x == 1 && s.p1.y == 2)
            {
                if (s.p2.x == 3 && s.p2.y == 4)
                {
                    return 3; // 1+2
                }
                else
                {
                    return -1; // 1-2
                }
            }
            else
            {
                if (s.p2.x == 3 && s.p2.y == 4)
                {
                    return 1; // -1+2
                }
                else
                {
                    return -3; // -1-2
                }
            }
        }

        public static int guessCoordinates(CoordinateStructure p1,
                CoordinateStructure p2)
        {
            SegmentStructure s = new SegmentStructure();
            s.p1 = p1;
            s.p2 = p2;

            if (s.p1.x == 1 && s.p1.y == 2)
            {
                if (s.p2.x == 3 && s.p2.y == 4)
                {
                    return 3; // 1+2
                }
                else
                {
                    return -1; // 1-2
                }
            }
            else
            {
                if (s.p2.x == 3 && s.p2.y == 4)
                {
                    return 1; // -1+2
                }
                else
                {
                    return -3; // -1-2
                }
            }
        }

        public static int guess(SegmentStructure s)
        {
            if (s.p1.x == 1 && s.p1.y == 2)
            {
                if (s.p2.x == 3 && s.p2.y == 4)
                {
                    return 3; // 1+2
                }
                else
                {
                    return -1; // 1-2
                }
            }
            else
            {
                if (s.p2.x == 3 && s.p2.y == 4)
                {
                    return 1; // -1+2
                }
                else
                {
                    return -3; // -1-2
                }
            }
        }
    }
}