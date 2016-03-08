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
import hu.bme.mit.sette.snippets._6_others.dependencies.AnonymousClassInterface;
import hu.bme.mit.sette.snippets.inputs._6_others.Others_AnonymousClass_Inputs;

@SetteSnippetContainer(category = "Others", goal = "Check support for anonymous classes",
        inputFactoryContainer = Others_AnonymousClass_Inputs.class)
public final class Others_AnonymousClass {
    private Others_AnonymousClass() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int anonymousClassTest(int x) {
        AnonymousClassInterface a = new AnonymousClassInterface() {
            @Override
            public int method(int xx) {
                if (xx < 0) {
                    return -xx;
                } else {
                    return xx;
                }
            }
        };

        return a.method(x);
    }
}
