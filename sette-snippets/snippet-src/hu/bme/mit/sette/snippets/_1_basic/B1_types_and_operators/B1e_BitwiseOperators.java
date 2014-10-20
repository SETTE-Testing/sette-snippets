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
import hu.bme.mit.sette.snippets.inputs._1_basic.B1_types_and_operators.B1e_BitwiseOperators_Inputs;

@SetteSnippetContainer(category = "B1",
        goal = "Check support for bitwise operators",
        inputFactoryContainer = B1e_BitwiseOperators_Inputs.class)
public final class B1e_BitwiseOperators {
    private B1e_BitwiseOperators() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int shiftLeft(int x, int y) {
        return x << y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int shiftLeftAssignment(int x, int y) {
        x <<= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int shiftRight(int x, int y) {
        return x >> y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int shiftRightAssignment(int x, int y) {
        x >>= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int shiftRightUnsigned(int x, int y) {
        return x >>> y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int shiftRightUnsignedAssignment(int x, int y) {
        x >>>= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int and(int x, int y) {
        return x & y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int andAssignment(int x, int y) {
        x &= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int or(int x, int y) {
        return x | y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int orAssignment(int x, int y) {
        x |= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int xor(int x, int y) {
        return x ^ y;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int xorAssignment(int x, int y) {
        x ^= y;
        return x;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int negate(int x) {
        return ~x;
    }
}
