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

package hu.bme.mit.sette.snippets._6_others;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._6_others.Others_Varargs_Inputs;

@SetteSnippetContainer(category = "Others", goal = "Check support for variable argument lists",
        inputFactoryContainer = Others_Varargs_Inputs.class)
public final class Others_Varargs {
    private Others_Varargs() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int varargsGuess(int... numbers) {
        if (numbers == null || numbers.length < 2) {
            // make safe
            return -1;
        }

        if (numbers[0] == 1 && numbers[1] == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int varargsGuessWithLength(int... numbers) {
        if (numbers == null) {
            // make safe
            return -1;
        }

        if (numbers.length == 3 && numbers[0] == 1 && numbers[1] == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int[] varargsIterateWithFor(int... numbers) {
        if (numbers == null) {
            // make safe
            return new int[0];
        } else if (numbers.length > 3) {
            // prevent path explosion
            return new int[0];
        }

        int[] ret = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                ret[i] = 1;
            }
        }

        return numbers;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int[] varargsIterateWithForeach(int... numbers) {
        if (numbers == null) {
            // make safe
            return new int[0];
        } else if (numbers.length > 3) {
            // prevent path explosion
            return new int[0];
        }

        int[] ret = new int[numbers.length];

        int i = 0;
        for (int n : numbers) {
            if (n > 0) {
                ret[i] = 1;
            }
            i++;
        }

        return numbers;
    }
}
