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
import hu.bme.mit.sette.common.snippets.JavaVersion;
import hu.bme.mit.sette.snippets.inputs._5_library.L2_Strings_Java7_Inputs;

@SetteSnippetContainer(category = "L2", goal = "Check support for strings",
        inputFactoryContainer = L2_Strings_Java7_Inputs.class,
        requiredJavaVersion = JavaVersion.JAVA_7)
public final class L2_Strings_Java7 {
    private L2_Strings_Java7() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int switchString(String s) {
        if (s == null) {
            return -1;
        }

        switch (s) {
            case "case1":
                return 1;

            case "case2":
                return 2;

            default:
                return 0;
        }
    }
}
