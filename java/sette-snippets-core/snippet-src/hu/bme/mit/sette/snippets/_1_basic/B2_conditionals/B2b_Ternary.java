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
package hu.bme.mit.sette.snippets._1_basic.B2_conditionals;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B2_conditionals.B2b_Ternary_Inputs;

@SetteSnippetContainer(category = "B2", goal = "Check support for the ternary operator",
        inputFactoryContainer = B2b_Ternary_Inputs.class)
public final class B2b_Ternary {
    private B2b_Ternary() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean oneParamBoolean(boolean x) {
        return x ? true : false;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean twoParamsBoolean(boolean x, boolean y) {
        return x && y ? true : false;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int oneParamInt(int x) {
        return x == 5 ? 1 : 0;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int twoParamsInt(int x, int y) {
        return x == 5 && y == 10 ? 1 : 0;
    }
}
