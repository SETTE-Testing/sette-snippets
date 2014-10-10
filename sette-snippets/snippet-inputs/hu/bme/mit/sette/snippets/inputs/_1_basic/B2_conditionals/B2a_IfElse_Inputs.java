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
package hu.bme.mit.sette.snippets.inputs._1_basic.B2_conditionals;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class B2a_IfElse_Inputs {
    private B2a_IfElse_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer oneParamBoolean() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer twoParamsBoolean() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(true, true);
        inputs.addByParameters(false, true);
        inputs.addByParameters(true, false);
        inputs.addByParameters(false, false);

        return inputs;
    }

    public static SnippetInputContainer oneParamInt() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(12345);
        inputs.addByParameters(1);
        inputs.addByParameters(-1);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer twoParamsInt() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(1, 1);
        inputs.addByParameters(-1, 1);
        inputs.addByParameters(1, -1);
        inputs.addByParameters(-1, -1);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer oneParamDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(12345.0);
        inputs.addByParameters(1.0);
        inputs.addByParameters(-1.0);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer twoParamsDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(1, 1);
        inputs.addByParameters(-1, 1);
        inputs.addByParameters(1, -1);
        inputs.addByParameters(-1, -1);
        inputs.addByParameters(0, 0);

        return inputs;
    }
}
