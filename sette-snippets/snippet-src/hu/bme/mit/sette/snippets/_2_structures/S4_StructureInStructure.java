/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 *
 * SETTE is a tool to help the evaluation and comparison of symbolic execution based test input 
 * generator tools.
 *
 * Budapest University of Technology and Economics (BME)
 *
 * Authors: Lajos Cseppentő <lajos.cseppento@inf.mit.bme.hu>, Zoltán Micskei <micskeiz@mit.bme.hu>
 *
 * Copyright 2014-2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except 
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package hu.bme.mit.sette.snippets._2_structures;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._2_structures.dependencies.CoordinateStructure;
import hu.bme.mit.sette.snippets._2_structures.dependencies.SegmentStructure;
import hu.bme.mit.sette.snippets.inputs._2_structures.S4_StructureInStructure_Inputs;

@SetteSnippetContainer(category = "S4",
        goal = "Check support for structures containing other structures",
        inputFactoryContainer = S4_StructureInStructure_Inputs.class)
public final class S4_StructureInStructure {
    private S4_StructureInStructure() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessParams(int x1, int y1, int x2, int y2) {
        SegmentStructure s = new SegmentStructure();
        s.p1.x = x1;
        s.p1.y = y1;
        s.p2.x = x2;
        s.p2.y = y2;

        if (s.p1.x == 1 && s.p1.y == 2) {
            if (s.p2.x == 3 && s.p2.y == 4) {
                return 3; // 1+2
            } else {
                return -1; // 1-2
            }
        } else {
            if (s.p2.x == 3 && s.p2.y == 4) {
                return 1; // -1+2
            } else {
                return -3; // -1-2
            }
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessCoordinates(CoordinateStructure p1, CoordinateStructure p2) {
        if (p1 == null || p2 == null) {
            return 0;
        }

        SegmentStructure s = new SegmentStructure();
        s.p1 = p1;
        s.p2 = p2;

        if (s.p1.x == 1 && s.p1.y == 2) {
            if (s.p2.x == 3 && s.p2.y == 4) {
                return 3; // 1+2
            } else {
                return -1; // 1-2
            }
        } else {
            if (s.p2.x == 3 && s.p2.y == 4) {
                return 1; // -1+2
            } else {
                return -3; // -1-2
            }
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guess(SegmentStructure s) {
        if (s == null || s.p1 == null || s.p2 == null) {
            // it cannot be provided that the p1 & p2 fields will be never null
            // without using getter/setter methods
            return 0;
        }

        if (s.p1.x == 1 && s.p1.y == 2) {
            if (s.p2.x == 3 && s.p2.y == 4) {
                return 3; // 1+2
            } else {
                return -1; // 1-2
            }
        } else {
            if (s.p2.x == 3 && s.p2.y == 4) {
                return 1; // -1+2
            } else {
                return -3; // -1-2
            }
        }
    }
}
