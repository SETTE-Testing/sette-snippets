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
package hu.bme.mit.sette.snippets._1_basic.B2_conditionals;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B2_conditionals.B2a_IfElse_Inputs;

@SetteSnippetContainer(category = "B2",
        goal = "Check support for the if-else conditional statement",
        inputFactoryContainer = B2a_IfElse_Inputs.class)
public final class B2a_IfElse {
    private B2a_IfElse() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int oneParamBoolean(boolean x) {
        if (x) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 8.0 / 12.0 * 100)
    public static int twoParamsBoolean(boolean x, boolean y) {
        if (x && y) {
            return 1;
        } else if (!x && y) {
            return 2;
        } else if (!x && !y) {
            return 3;
        } else if (x && !y) {
            return 4;
        } else if (x && !y) {
            // impossible branch (the previous is the same)
            return -1;
        } else {
            // impossible branch
            return -2;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int oneParamInt(int x) {
        if (x == 12345) {
            return 2;
        }

        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 8.0 / 12.0 * 100)
    public static int twoParamsInt(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else if (x > 0 && y < 0) {
            // impossible branch (the previous is the same)
            return -1;
        } else if (x == 0 || y == 0) {
            return 0;
        } else {
            // impossible branch
            return -2;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int oneParamDouble(double x) {
        if (x == 12345.0) {
            return 2;
        } else if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 8.0 / 12.0 * 100)
    public static int twoParamsDouble(double x, double y) {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else if (x > 0 && y < 0) {
            // impossible branch (the previous is the same)
            return -1;
        } else if (x == 0 || y == 0) {
            return 0;
        } else {
            // impossible branch
            return -2;
        }
    }
}
