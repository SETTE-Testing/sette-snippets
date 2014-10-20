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
package hu.bme.mit.sette.snippets.inputs._3_objects;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleObjectOverride;

public final class O4_Override_Inputs {
    private O4_Override_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessResultParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(8, 2, -1);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessResult() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(null, 0, 0, 0);
        inputs.addByParameters(new SimpleObjectOverride(), 8, 2, -1);
        inputs.addByParameters(new SimpleObjectOverride(), 0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(1, -1, 0);

        return inputs;
    }

    public static SnippetInputContainer guessImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(null, 0, 0, 0);
        inputs.addByParameters(new SimpleObjectOverride(), 1, -1, 0);

        return inputs;
    }
}
