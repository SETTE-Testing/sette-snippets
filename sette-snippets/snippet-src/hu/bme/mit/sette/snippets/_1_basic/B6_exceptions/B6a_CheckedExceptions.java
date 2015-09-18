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

package hu.bme.mit.sette.snippets._1_basic.B6_exceptions;

import hu.bme.mit.sette.annotations.SetteIncludeCoverage;
import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._1_basic.B6_exceptions.dependencies.MyException;
import hu.bme.mit.sette.snippets.inputs._1_basic.B6_exceptions.B6a_CheckedExceptions_Inputs;

@SetteSnippetContainer(category = "B6", goal = "Check support for checked exceptions",
        inputFactoryContainer = B6a_CheckedExceptions_Inputs.class)
public final class B6a_CheckedExceptions {
    private B6a_CheckedExceptions() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static void always() throws Exception {
        throw new Exception();
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int conditionalAndLoop(int x) throws Exception {
        if (x < 0) {
            throw new Exception();
        }

        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;

            if (i >= 10) {
                throw new Exception();
            }
        }

        return sum;
    }

    private static int calledFunction(int x, int y) throws Exception {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            throw new Exception();
        }
    }

    @SetteIncludeCoverage(classes = { B6a_CheckedExceptions.class },
            methods = { "calledFunction(int, int)" })
    @SetteRequiredStatementCoverage(value = 100)
    public static int call(int x, int y) throws Exception {
        return calledFunction(x, y);
    }

    @SetteIncludeCoverage(classes = { B6a_CheckedExceptions.class },
            methods = { "recursive_(int, int)" })
    @SetteRequiredStatementCoverage(value = 100)
    public static int recursive(int x) throws Exception {
        return recursive_(x, 1);
    }

    private static int recursive_(int x, int depth) throws Exception {
        if (depth >= 10) {
            throw new Exception();
        }

        if (x % 100 == 0) {
            return x;
        } else {
            return B6a_CheckedExceptions.recursive_(x - 1, depth + 1);
        }
    }

    @SetteIncludeCoverage(classes = { B6a_CheckedExceptions.class },
            methods = { "calledFunction(int, int)" })
    @SetteRequiredStatementCoverage(value = 100)
    public static int tryCatch(int x, int y) throws MyException {
        try {
            return B6a_CheckedExceptions.calledFunction(x, y);
        } catch (Exception ex) {
            throw new MyException();
        }
    }

    @SetteIncludeCoverage(classes = { B6a_CheckedExceptions.class },
            methods = { "calledFunction(int, int)" })
    @SetteRequiredStatementCoverage(value = 100)
    public static int tryCatchFinally(int x, int y, int z) throws MyException {
        try {
            return B6a_CheckedExceptions.calledFunction(x, y);
        } catch (Exception ex) {
            throw new MyException();
        } finally {
            // note: return statements in the finally block is not advised
            // - it overwrites the original return value
            // - it absorbs the thrown exception
            if (z > 0) {
                return -1;
            } else if (z < 0) {
                return -2;
            }
        }
    }
}
