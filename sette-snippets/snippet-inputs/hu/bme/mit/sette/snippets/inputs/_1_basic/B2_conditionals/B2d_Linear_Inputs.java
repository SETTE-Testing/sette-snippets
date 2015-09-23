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

public final class B2d_Linear_Inputs {
    private B2d_Linear_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer oneParamInt() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(2);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer oneParamIntNoSolution() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer twoParamsInt() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(5, -1);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer twoParamsIntNoSolution() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer threeParamsInt() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(5, -1, 2);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer threeParamsIntNoSolution() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer oneParamFloat() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0.75f);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer twoParamsFloat() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(4f, -0.5f);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer threeParamsFloat() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(198f / 41f, -30f / 41f, 77f / 41f);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer oneParamDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0.75);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer twoParamsDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(4, -0.5);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer threeParamsDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(198.0 / 41.0, -30.0 / 41.0, 77.0 / 41.0);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }
}
