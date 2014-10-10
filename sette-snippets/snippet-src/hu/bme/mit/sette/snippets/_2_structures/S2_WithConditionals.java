/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 * 
 * SETTE is a tool to help the evaluation and comparison of symbolic execution
 * based test input generator tools.
 * 
 * Budapest University of Technology and Economics (BME)
 * 
 * Authors: Lajos Cseppentő <lajos.cseppento@inf.mit.bme.hu>, Zoltán Micskei
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
package hu.bme.mit.sette.snippets._2_structures;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._2_structures.dependencies.CoordinateStructure;
import hu.bme.mit.sette.snippets.inputs._2_structures.S2_WithConditionals_Inputs;

@SetteSnippetContainer(category = "S2", goal = "Check support for structure usage with conditionals", inputFactoryContainer = S2_WithConditionals_Inputs.class)
public final class S2_WithConditionals {
    private S2_WithConditionals() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int oneStructureParams(int x, int y) {
        CoordinateStructure c = new CoordinateStructure();

        c.x = x;
        c.y = y;

        if (c.x > 0 && c.y > 0) {
            return 1;
        } else if (c.x < 0 && c.y > 0) {
            return 2;
        } else if (c.x < 0 && c.y < 0) {
            return 3;
        } else if (c.x > 0 && c.y < 0) {
            return 4;
        } else {
            return -1;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int oneStructure(CoordinateStructure c) {
        if (c == null) {
            return 0;
        }

        if (c.x > 0 && c.y > 0) {
            return 1;
        } else if (c.x < 0 && c.y > 0) {
            return 2;
        } else if (c.x < 0 && c.y < 0) {
            return 3;
        } else if (c.x > 0 && c.y < 0) {
            return 4;
        } else {
            return -1;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int twoStructuresParams(int x1, int y1, int x2, int y2) {
        CoordinateStructure c1 = new CoordinateStructure();
        c1.x = x1;
        c1.y = y1;

        CoordinateStructure c2 = new CoordinateStructure();
        c2.x = x2;
        c2.y = y2;

        CoordinateStructure c = new CoordinateStructure();
        c.x = c1.x + c2.x;
        c.y = c1.y + c2.y;

        if (c.x > 0 && c.y > 0) {
            return 1;
        } else if (c.x < 0 && c.y > 0) {
            return 2;
        } else if (c.x < 0 && c.y < 0) {
            return 3;
        } else if (c.x > 0 && c.y < 0) {
            return 4;
        } else {
            return -1;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int twoStructures(CoordinateStructure c1,
            CoordinateStructure c2) {
        if (c1 == null || c2 == null) {
            return 0;
        }

        CoordinateStructure c = new CoordinateStructure();
        c.x = c1.x + c2.x;
        c.y = c1.y + c2.y;

        if (c.x > 0 && c.y > 0) {
            return 1;
        } else if (c.x < 0 && c.y > 0) {
            return 2;
        } else if (c.x < 0 && c.y < 0) {
            return 3;
        } else if (c.x > 0 && c.y < 0) {
            return 4;
        } else {
            return -1;
        }
    }
}
