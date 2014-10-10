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
package hu.bme.mit.sette.snippets.inputs._2_structures;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._2_structures.dependencies.CoordinateStructure;

public final class S3_WithLoops_Inputs {
    private S3_WithLoops_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer withLimitParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(0, 0, 5);
        inputs.addByParameters(1, 0, 5);

        return inputs;
    }

    public static SnippetInputContainer withLimit() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, 0);
        inputs.addByParameters(new CoordinateStructure(), 5);

        CoordinateStructure c = new CoordinateStructure();
        c.x = 1;
        c.y = 0;
        inputs.addByParameters(c, 5);

        return inputs;
    }

    public static SnippetInputContainer noLimitParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(0, 0, 5);
        inputs.addByParameters(1, 0, 5);

        return inputs;
    }

    public static SnippetInputContainer noLimit() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, 0);
        inputs.addByParameters(new CoordinateStructure(), 5);

        CoordinateStructure c = new CoordinateStructure();
        c.x = 1;
        c.y = 0;
        inputs.addByParameters(c, 5);

        return inputs;
    }

    public static SnippetInputContainer arrayOfStructuresParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, null);
        inputs.addByParameters(new int[] { 0, 1 }, new int[] { 0, 0 });

        return inputs;
    }

    public static SnippetInputContainer arrayOfStructures() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);

        CoordinateStructure[] cs = new CoordinateStructure[2];
        cs[0] = new CoordinateStructure();
        cs[1] = new CoordinateStructure();
        cs[1].x = 1;
        cs[1].y = 0;
        inputs.addByParameters((Object) cs);

        return inputs;
    }
}
