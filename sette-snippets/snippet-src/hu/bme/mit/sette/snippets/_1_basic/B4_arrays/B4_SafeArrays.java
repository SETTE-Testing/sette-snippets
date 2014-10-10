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
package hu.bme.mit.sette.snippets._1_basic.B4_arrays;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B4_arrays.B4_SafeArrays_Inputs;

/**
 * Safe arrays: using safe operations, i.e. IndexOutOfBoundsException and
 * NullPointerException cannot occur.<br/>
 * Unsafe arrays: not ensuring safe operations, i.e. IndexOutOfBoundsException
 * and NullPointerException may occur.
 */
@SetteSnippetContainer(category = "B4", goal = "Check support for arrays using safe operations", inputFactoryContainer = B4_SafeArrays_Inputs.class)
public final class B4_SafeArrays {
    private B4_SafeArrays() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int fromParams(int x, int y, int z) {
        int[] numbers = new int[] { x, y, z };

        if (numbers[0] == 1 && numbers[1] == 2 && numbers[2] == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int indexParam(int index) {
        if (index < 0 || 10 <= index) {
            // make safe
            return -1;
        }

        int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        if (numbers[index] == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessLength(int length) {
        int[] numbers = new int[10];

        if (numbers.length == length) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int fromParamsWithIndex(int x, int y, int z, int index) {
        if (index < 0 || 3 <= index) {
            // make safe
            return -1;
        }

        int[] numbers = new int[] { x, y, z };

        if (numbers[0] == 1 && numbers[1] == 2 && numbers[index] == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessOneArray(int[] numbers) {
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
    public static int guessOneArrayWithLength(int[] numbers) {
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
    public static int twoArrays(int[] numbers1, int[] numbers2) {
        if (numbers1 == null || numbers2 == null || numbers1.length < 1
                || numbers2.length < 2) {
            // make safe
            return -1;
        }

        if (numbers1[0] + numbers2[0] == 1) {
            if (numbers2[1] == 2) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int[] iterateWithFor(int[] numbers) {
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
    public static int[] iterateWithForeach(int[] numbers) {
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
