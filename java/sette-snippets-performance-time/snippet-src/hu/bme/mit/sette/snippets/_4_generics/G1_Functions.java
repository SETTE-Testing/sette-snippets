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

package hu.bme.mit.sette.snippets._4_generics;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._4_generics.G1_Functions_Inputs;

@SetteSnippetContainer(category = "G1", goal = "Check support for generic functions",
        inputFactoryContainer = G1_Functions_Inputs.class)
public final class G1_Functions {
    private G1_Functions() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 88.89)
    public static <T> int guessType(T o) {
        if (o == null) {
            return 0;
        } else if (o instanceof Integer) {
            return 1;
        } else if (o instanceof Double) {
            return 2;
        } else if (o instanceof Object) {
            return 3;
        } else {
            // impossible branch
            throw new RuntimeException();
        }
    }

    @SetteRequiredStatementCoverage(value = 93.33)
    public static <T> int guessTypeAndUse(T o) {
        if (o == null) {
            return 0;
        } else if (o instanceof Integer) {
            int i = (Integer) o;

            if (i > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (o instanceof Double) {
            double d = (Double) o;

            if (d > 0) {
                return 2;
            } else {
                return -2;
            }
        } else if (o instanceof Object) {
            return 3;
        } else {
            // impossible branch
            throw new RuntimeException();
        }
    }

    @SetteRequiredStatementCoverage(value = 66.67)
    public static <T extends Number> int guessTypeWithExtends(T o) {
        if (o == null) {
            return 0;
        } else if (o instanceof Integer) {
            return 1;
        } else if (o instanceof Double) {
            return 2;
        } else if (o instanceof Object) {
            // impossible branch
            throw new RuntimeException();
        } else {
            // impossible branch
            throw new RuntimeException();
        }
    }

    @SetteRequiredStatementCoverage(value = 80)
    public static <T extends Number> int guessTypeWithExtendsAndUse(T o) {
        if (o == null) {
            return 0;
        } else if (o instanceof Integer) {
            int i = (Integer) o;

            if (i > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (o instanceof Double) {
            double d = (Double) o;

            if (d > 0) {
                return 2;
            } else {
                return -2;
            }
        } else if (o instanceof Object) {
            // impossible branch
            throw new RuntimeException();
        } else {
            // impossible branch
            throw new RuntimeException();
        }
    }
}
