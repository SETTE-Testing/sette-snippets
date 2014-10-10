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
package hu.bme.mit.sette.snippets._1_basic.B5_functions;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B5_functions.B5b_UnlimitedRecursive_Inputs;

@SetteSnippetContainer(category = "B5", goal = "Check support for recursive function calls (without depth limit)", inputFactoryContainer = B5b_UnlimitedRecursive_Inputs.class)
public final class B5b_UnlimitedRecursive {
    private B5b_UnlimitedRecursive() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int simple(int x) {
        if (x % 100 == 0) {
            return x;
        } else {
            return simple(x - 1);
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int fibonacci(int x) {
        if (x <= 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }
}
