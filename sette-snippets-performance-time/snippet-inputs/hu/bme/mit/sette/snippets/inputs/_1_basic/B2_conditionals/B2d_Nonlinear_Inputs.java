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

package hu.bme.mit.sette.snippets.inputs._1_basic.B2_conditionals;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class B2d_Nonlinear_Inputs {
    private B2d_Nonlinear_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer quadraticInt() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(-5, 2);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer quadraticIntNoSolution() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer quadraticFloat() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(-3.108495f, 1.608495f);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer quadraticFloatNoSolution() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer quadraticDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(-3.108495, 1.608495);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer quadraticDoubleNoSolution() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(0, 0);

        return inputs;
    }
}
