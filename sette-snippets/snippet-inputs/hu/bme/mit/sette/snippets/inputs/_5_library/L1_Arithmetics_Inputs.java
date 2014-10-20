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

public final class L1_Arithmetics_Inputs {
    private L1_Arithmetics_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer abs() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(5, 10);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer absImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer minMax() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(-10, 20);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer minMaxWithOrder() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(-10, 20);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer minMaxImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer sqrt() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(4);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer sqrtImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer cbrt() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(8);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer powGuessBase() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(2);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer powGuessExponent() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(10);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer powGuessBaseAndExponent() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(2, 10);
        inputs.addByParameters(0, 1);

        return inputs;
    }

    public static SnippetInputContainer log10GuessArgument() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(100);
        inputs.addByParameters(1);

        return inputs;
    }

    public static SnippetInputContainer logGuessBase() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(10);
        inputs.addByParameters(2);

        return inputs;
    }

    public static SnippetInputContainer logGuessArgument() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(100);
        inputs.addByParameters(1);

        return inputs;
    }

    public static SnippetInputContainer logGuessBaseAndArgument() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(100, 10);
        inputs.addByParameters(2, 2);

        return inputs;
    }

    public static SnippetInputContainer sin() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(Math.PI / 6.0);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer sinImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer cos() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(Math.PI / 3.0);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer cosImpossible() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer tan() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(Math.PI / 4.0);
        inputs.addByParameters(0);

        return inputs;
    }
}
