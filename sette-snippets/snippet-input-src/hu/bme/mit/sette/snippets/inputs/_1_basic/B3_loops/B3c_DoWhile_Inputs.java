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

package hu.bme.mit.sette.snippets.inputs._1_basic.B3_loops;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class B3c_DoWhile_Inputs {
    private B3c_DoWhile_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer withLimit() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(10);

        return inputs;
    }

    public static SnippetInputContainer withConditionAndLimit() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(10);

        return inputs;
    }

    public static SnippetInputContainer withConditionNoLimit() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(10);

        return inputs;
    }

    public static SnippetInputContainer withContinueBreak() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(1000);

        return inputs;
    }

    public static SnippetInputContainer complex() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(100, 10, 5, 0); // limit, skip and return
        inputs.addByParameters(100, 0, 0, 5); // stop
        inputs.addByParameters(Integer.MAX_VALUE, 0, 0, 0); // overflow

        return inputs;
    }

    public static SnippetInputContainer infinite() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer infiniteNotOptimalizable() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(Integer.MAX_VALUE);

        return inputs;
    }

    public static SnippetInputContainer nestedLoop() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(10, 10);

        return inputs;
    }

    public static SnippetInputContainer nestedLoopWithLabel() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(10, 10);
        inputs.addByParameters(6, 6);
        inputs.addByParameters(8, 8);

        return inputs;
    }
}
