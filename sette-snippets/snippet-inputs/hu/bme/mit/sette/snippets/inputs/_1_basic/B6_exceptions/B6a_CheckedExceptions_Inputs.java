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
package hu.bme.mit.sette.snippets.inputs._1_basic.B6_exceptions;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._1_basic.B6_exceptions.dependencies.MyException;

public final class B6a_CheckedExceptions_Inputs {
    private B6a_CheckedExceptions_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer always() {
        SnippetInputContainer inputs = new SnippetInputContainer(0);

        inputs.addByParametersAndExpected(Exception.class);

        return inputs;
    }

    public static SnippetInputContainer conditionalAndLoop() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(Exception.class, -1);
        inputs.addByParametersAndExpected(Exception.class, 20);
        inputs.addByParameters(5);

        return inputs;
    }

    public static SnippetInputContainer call() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(1, 1);
        inputs.addByParameters(-1, 1);
        inputs.addByParameters(1, -1);
        inputs.addByParameters(-1, -1);
        inputs.addByParametersAndExpected(Exception.class, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer recursive() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(Exception.class, 20);
        inputs.addByParameters(5);

        return inputs;
    }

    public static SnippetInputContainer tryCatch() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(1, 1);
        inputs.addByParameters(-1, 1);
        inputs.addByParameters(1, -1);
        inputs.addByParameters(-1, -1);
        inputs.addByParametersAndExpected(MyException.class, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer tryCatchFinally() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(1, 1, 0);
        inputs.addByParameters(1, 1, 1); // overwrite return
        inputs.addByParameters(1, 1, -1); // overwrite return
        inputs.addByParameters(-1, 1, 0);
        inputs.addByParameters(1, -1, 0);
        inputs.addByParameters(-1, -1, 0);
        inputs.addByParametersAndExpected(MyException.class, 0, 0, 0);
        inputs.addByParametersAndExpected(MyException.class, 0, 0, 1); // absorb
        // exception

        return inputs;
    }
}
