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

public final class B6c_CommonRuntimeExceptions_Inputs {
    private B6c_CommonRuntimeExceptions_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer arithmeticException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(ArithmeticException.class,
                true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer arrayIndexOutOfBoundsException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                ArrayIndexOutOfBoundsException.class, true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer classCastException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(ClassCastException.class,
                true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer illegalArgumentException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                IllegalArgumentException.class, true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer illegalStateException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(IllegalStateException.class,
                true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer indexOutOfBoundsException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                IndexOutOfBoundsException.class, true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer nullPointerException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer securityException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(SecurityException.class, true);
        inputs.addByParameters(false);

        return inputs;
    }

    public static SnippetInputContainer unsupportedOperationException() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                UnsupportedOperationException.class, true);
        inputs.addByParameters(false);

        return inputs;
    }
}
