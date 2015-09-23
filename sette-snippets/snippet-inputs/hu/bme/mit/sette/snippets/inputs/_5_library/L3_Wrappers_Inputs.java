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

package hu.bme.mit.sette.snippets.inputs._5_library;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class L3_Wrappers_Inputs {
    private L3_Wrappers_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessInteger() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(new Integer(1));
        inputs.addByParameters(new Integer(2));
        inputs.addByParameters(new Integer(0));

        return inputs;
    }

    public static SnippetInputContainer integerOverflow() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(Integer.MAX_VALUE, new Integer(1));
        inputs.addByParameters(new Integer(0), new Integer(0));

        return inputs;
    }

    public static SnippetInputContainer guessDouble() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(new Double(1));
        inputs.addByParameters(new Double(2));
        inputs.addByParameters(new Double(0));

        return inputs;
    }
}
