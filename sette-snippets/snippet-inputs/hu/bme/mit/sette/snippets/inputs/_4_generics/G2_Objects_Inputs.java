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
package hu.bme.mit.sette.snippets.inputs._4_generics;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._4_generics.dependencies.GenericTriplet;
import hu.bme.mit.sette.snippets._4_generics.dependencies.IntegerTriplet;
import hu.bme.mit.sette.snippets._4_generics.dependencies.SafeGenericTriplet;

public final class G2_Objects_Inputs {
    private G2_Objects_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessInteger() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                (Object) null);
        inputs.addByParameters(new GenericTriplet<Integer>(1, 0, 0));
        inputs.addByParameters(new GenericTriplet<Integer>(0, 0, 0));

        return inputs;
    }

    public static SnippetInputContainer guessIntegerNoHelp() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                (Object) null);
        inputs.addByParameters(new GenericTriplet<Integer>(1, 0, 0));
        inputs.addByParameters(new GenericTriplet<Integer>(0, 0, 0));

        return inputs;
    }

    public static SnippetInputContainer guessImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                (Object) null);
        inputs.addByParameters(new GenericTriplet<Double>(0.0, 0.0, 0.0));

        return inputs;
    }

    public static SnippetInputContainer guessDescendant() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                (Object) null);
        inputs.addByParameters(new IntegerTriplet(1, 0, 0));
        inputs.addByParameters(new IntegerTriplet(0, 0, 0));

        return inputs;
    }

    public static SnippetInputContainer guessSafe() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                (Object) null);
        inputs.addByParameters(new SafeGenericTriplet<Integer>(0, 0, 0));

        return inputs;
    }

    public static SnippetInputContainer guessSafeNoHelp() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParametersAndExpected(NullPointerException.class,
                (Object) null);
        inputs.addByParametersAndExpected(
                ArrayIndexOutOfBoundsException.class,
                new GenericTriplet<Integer>(0, 0, 0));
        inputs.addByParameters(new SafeGenericTriplet<Integer>(0, 0, 0));

        return inputs;
    }
}
