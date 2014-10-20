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
import hu.bme.mit.sette.snippets._2_structures.dependencies.SegmentStructure;

public final class S4_StructureInStructure_Inputs {
    private S4_StructureInStructure_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(1, 2, 3, 4);
        inputs.addByParameters(1, 2, 0, 0);
        inputs.addByParameters(0, 0, 3, 4);
        inputs.addByParameters(0, 0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessCoordinates() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, null);

        CoordinateStructure p1, p2;

        p1 = new CoordinateStructure();
        p1.x = 1;
        p1.y = 2;
        p2 = new CoordinateStructure();
        p2.x = 3;
        p2.y = 4;
        inputs.addByParameters(p1, p2);

        p1 = new CoordinateStructure();
        p1.x = 1;
        p1.y = 2;
        p2 = new CoordinateStructure();
        inputs.addByParameters(p1, p2);

        p1 = new CoordinateStructure();
        p2 = new CoordinateStructure();
        p2.x = 3;
        p2.y = 4;
        inputs.addByParameters(p1, p2);

        p1 = new CoordinateStructure();
        p2 = new CoordinateStructure();
        inputs.addByParameters(p1, p2);

        return inputs;
    }

    public static SnippetInputContainer guess() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);

        SegmentStructure s;

        s = new SegmentStructure();
        s.p1.x = 1;
        s.p1.y = 2;
        s.p2.x = 3;
        s.p2.y = 4;
        inputs.addByParameters(s);

        s = new SegmentStructure();
        s.p1.x = 1;
        s.p1.y = 2;
        inputs.addByParameters(s);

        s = new SegmentStructure();
        s.p2.x = 3;
        s.p2.y = 4;
        inputs.addByParameters(s);

        s = new SegmentStructure();
        inputs.addByParameters(s);

        return inputs;
    }
}
