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
package hu.bme.mit.sette.snippets.inputs._1_basic.B1_types_and_operators;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class B1c_ArithmeticalOperators_Inputs {
    private B1c_ArithmeticalOperators_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer add() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer addAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer substract() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer substractAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer multiply() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer multiplyAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer divide() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer divideAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer modulo() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer moduloAssignment() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer unaryPlus() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer unaryPlusPlus() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer postfixPlusplus() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer unaryMinus() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer unaryMinusMinus() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer postfixMinusMinus() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

}
