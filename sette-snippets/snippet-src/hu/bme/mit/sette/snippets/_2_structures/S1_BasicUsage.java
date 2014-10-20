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
import hu.bme.mit.sette.snippets.inputs._2_structures.S1_BasicUsage_Inputs;

@SetteSnippetContainer(category = "S1",
        goal = "Check support for basic structure usage",
        inputFactoryContainer = S1_BasicUsage_Inputs.class)
public final class S1_BasicUsage {
    private S1_BasicUsage() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int useStructureParams(int x, int y) {
        CoordinateStructure c = new CoordinateStructure();

        c.x = x;
        c.y = y;

        return c.x + c.y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int useStructure(CoordinateStructure c) {
        if (c == null) {
            return 0;
        }

        return c.x + c.y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static CoordinateStructure returnStructureParams(int x, int y) {
        CoordinateStructure c = new CoordinateStructure();
        c.x = x;
        c.y = y;

        c.x = -c.x;
        c.y = -c.y;

        return c;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static CoordinateStructure returnStructure(
            CoordinateStructure c) {
        if (c == null) {
            return null;
        }

        c.x = -c.x;
        c.y = -c.y;

        return c;
    }
}
