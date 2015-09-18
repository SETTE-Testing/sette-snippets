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

package hu.bme.mit.sette.snippets._5_library;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._5_library.L3_Wrappers_Inputs;

@SetteSnippetContainer(category = "L3", goal = "Check support for wrapper classes",
        inputFactoryContainer = L3_Wrappers_Inputs.class)
public final class L3_Wrappers {
    private L3_Wrappers() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static Integer guessInteger(Integer a) {
        if (a == 1) {
            return 1;
        } else if (a.equals(new Integer(2))) {
            return 2;
        } else {
            return -1;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static Integer integerOverflow(Integer a, Integer b) {
        Integer sum = a + b;

        if (sum < a || sum < b) {
            return Integer.MAX_VALUE;
        } else {
            return sum;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static Double guessDouble(Double a) {
        if (a == 1) {
            return 1.0;
        } else if (a.equals(new Double(2))) {
            return 2.0;
        } else {
            return -1.0;
        }
    }
}
