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
package hu.bme.mit.sette.snippets._1_basic.B1_types_and_operators;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B1_types_and_operators.B1c_ArithmeticalOperators_Inputs;

@SetteSnippetContainer(category = "B1",
        goal = "Check support for arithmetical operators",
        inputFactoryContainer = B1c_ArithmeticalOperators_Inputs.class)
public final class B1c_ArithmeticalOperators {
    private B1c_ArithmeticalOperators() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int add(int x, int y) {
        return x + y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int addAssignment(int x, int y) {
        x += y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int substract(int x, int y) {
        return x - y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int substractAssignment(int x, int y) {
        x -= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int multiply(int x, int y) {
        return x * y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int multiplyAssignment(int x, int y) {
        x *= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int divide(int x, int y) {
        return x / y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int divideAssignment(int x, int y) {
        x /= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int modulo(int x, int y) {
        return x % y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int moduloAssignment(int x, int y) {
        x %= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int unaryPlus(int x) {
        return +x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int unaryPlusPlus(int x) {
        ++x;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int postfixPlusplus(int x) {
        x++;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int unaryMinus(int x) {
        return -x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int unaryMinusMinus(int x) {
        --x;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int postfixMinusMinus(int x) {
        x--;
        return x;
    }
}
