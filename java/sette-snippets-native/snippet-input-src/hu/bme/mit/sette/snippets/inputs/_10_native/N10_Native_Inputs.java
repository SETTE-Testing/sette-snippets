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
 * Copyright 2014-2016
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
package hu.bme.mit.sette.snippets.inputs._10_native;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class N10_Native_Inputs {
    private N10_Native_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessNumber() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0);
        inputs.addByParameters(20160101);

        return inputs;
    }

    public static SnippetInputContainer reachState() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(0, 0, 0);
        inputs.addByParameters(0, 0, 4064256);

        return inputs;
    }
}
