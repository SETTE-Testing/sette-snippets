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

package hu.bme.mit.sette.snippets._1_basic.B1_types_and_operators;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B1_types_and_operators.B1b_Constants_Inputs;

@SetteSnippetContainer(category = "B1", goal = "Check support for constant usage",
        inputFactoryContainer = B1b_Constants_Inputs.class)
public final class B1b_Constants {
    private B1b_Constants() {
        throw new UnsupportedOperationException("Static class");
    }

    public static final boolean CONST_BOOLEAN = true;
    public static final byte CONST_BYTE = 123;
    public static final short CONST_SHORT = 12345;
    public static final int CONST_INT = 1234567890;
    public static final long CONST_LONG = 1234567890123456789L;
    public static final float CONST_FLOAT = 12345.67890f;
    public static final double CONST_DOUBLE = 1.2345678e90;
    public static final char CONST_CHAR = 'C';

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean constBoolean() {
        return B1b_Constants.CONST_BOOLEAN;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static byte constByte() {
        return B1b_Constants.CONST_BYTE;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static short constShort() {
        return B1b_Constants.CONST_SHORT;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int constInt() {
        return B1b_Constants.CONST_INT;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static long constLong() {
        return B1b_Constants.CONST_LONG;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static float constFloat() {
        return B1b_Constants.CONST_FLOAT;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static double constDouble() {
        return B1b_Constants.CONST_DOUBLE;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static char constChar() {
        return B1b_Constants.CONST_CHAR;
    }
}
