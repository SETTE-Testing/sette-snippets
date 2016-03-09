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

package hu.bme.mit.sette.snippets.inputs._1_basic.B1_types_and_operators;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class B1e_BitwiseOperators_Inputs {
    private B1e_BitwiseOperators_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer shiftLeft() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer shiftLeftAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer shiftRight() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer shiftRightAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer shiftRightUnsigned() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer shiftRightUnsignedAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer and() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer andAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer or() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer orAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer xor() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer xorAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer negate() {
        return new SnippetInputContainer(1).addByParameters(1);
    }
}
