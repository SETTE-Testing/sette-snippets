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
package hu.bme.mit.sette.snippets.inputs._5_library;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._5_library.dependencies.FingerNumber;

public final class LO_Other_Inputs {
    private LO_Other_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer inheritsAPIGuessOnePrimitive() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                IllegalArgumentException.class, 20);
        inputs.addByParameters(5);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer inheritsAPIGuessOneObject() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters(new FingerNumber(5));
        inputs.addByParameters(new FingerNumber(0));

        return inputs;
    }

    public static SnippetInputContainer inheritsAPIGuessTwoPrimitives() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParametersAndExpected(
                IllegalArgumentException.class, 20, 0);
        inputs.addByParametersAndExpected(RuntimeException.class, 9, 9);
        inputs.addByParameters(5, 0);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer inheritsAPIGuessTwoObjects() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, null);
        inputs.addByParametersAndExpected(RuntimeException.class,
                new FingerNumber(9), new FingerNumber(9));
        inputs.addByParameters(new FingerNumber(5), new FingerNumber(0));
        inputs.addByParameters(new FingerNumber(0), new FingerNumber(0));

        return inputs;
    }

    public static SnippetInputContainer associatesAPIGuessValidDateFormat() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                IllegalArgumentException.class, (Object) null);
        inputs.addByParameters("1991-09-26");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer associatesAPIGuessDate() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(
                IllegalArgumentException.class, (Object) null);
        inputs.addByParameters("1991-09-26");
        inputs.addByParameters("2014-01-01");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer guessValidUUID() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("01234567-89AB-CDEF-0123-456789ABCDEF");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer guessUUID() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("00000000-0000-1234-0000-00000000ABCD");
        inputs.addByParameters("01234567-89AB-CDEF-0123-456789ABCDEF");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer regexCaseSensitive() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("ABCDEF");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer regexCaseInsensitive() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("ABCDEF");
        inputs.addByParameters("");

        return inputs;
    }
}
