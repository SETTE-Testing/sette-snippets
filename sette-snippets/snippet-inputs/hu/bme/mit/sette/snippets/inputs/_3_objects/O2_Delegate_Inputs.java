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
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleObject;
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleObjectDelegate;

public final class O2_Delegate_Inputs {
    private O2_Delegate_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessResultParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(8, 1, -1);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessResult() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(null, 0, 0, 0);
        inputs.addByParametersAndExpected(NullPointerException.class,
                new SimpleObjectDelegate(null), 0, 0, 0);
        inputs.addByParameters(new SimpleObjectDelegate(
                new SimpleObject()), 8, 1, -1);
        inputs.addByParameters(new SimpleObjectDelegate(
                new SimpleObject()), 0, 0, 0);

        return inputs;
    }
}
