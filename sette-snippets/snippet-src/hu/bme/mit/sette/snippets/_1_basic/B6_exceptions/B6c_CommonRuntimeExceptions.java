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
package hu.bme.mit.sette.snippets._1_basic.B6_exceptions;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B6_exceptions.B6c_CommonRuntimeExceptions_Inputs;

@SetteSnippetContainer(category = "B6", goal = "Check support for common runtime exceptions", inputFactoryContainer = B6c_CommonRuntimeExceptions_Inputs.class)
public final class B6c_CommonRuntimeExceptions {
    private B6c_CommonRuntimeExceptions() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int arithmeticException(boolean b) {
        if (b) {
            throw new ArithmeticException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int arrayIndexOutOfBoundsException(boolean b) {
        if (b) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int classCastException(boolean b) {
        if (b) {
            throw new ClassCastException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int illegalArgumentException(boolean b) {
        if (b) {
            throw new IllegalArgumentException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int illegalStateException(boolean b) {
        if (b) {
            throw new IllegalStateException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int indexOutOfBoundsException(boolean b) {
        if (b) {
            throw new IndexOutOfBoundsException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int nullPointerException(boolean b) {
        if (b) {
            throw new NullPointerException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int securityException(boolean b) {
        if (b) {
            throw new SecurityException();
        }
        return 1;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int unsupportedOperationException(boolean b) {
        if (b) {
            throw new UnsupportedOperationException();
        }
        return 1;
    }
}
