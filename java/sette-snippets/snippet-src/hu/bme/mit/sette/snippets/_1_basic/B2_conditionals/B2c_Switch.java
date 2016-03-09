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
import hu.bme.mit.sette.snippets.inputs._1_basic.B2_conditionals.B2c_Switch_Inputs;

@SetteSnippetContainer(category = "B2", goal = "Check support for the switch statement",
        inputFactoryContainer = B2c_Switch_Inputs.class)
public final class B2c_Switch {
    private B2c_Switch() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int simple(int x) {
        int ret;

        switch (x) {
            case 0:
                ret = 0;
                break;

            case 1:
                ret = 1;
                break;

            case 2:
                ret = 4;
                break;

            default:
                ret = -1;
                break;
        }

        return ret;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int missingBreaks(int x) {
        int ret;

        switch (x) {
            case 0:
                ret = 0;
                // break; // miss break
                //$FALL-THROUGH$
            case 1:
                ret = 1;
                break;

            case 2:
                ret = 4;
                // break; // miss break
                //$FALL-THROUGH$
            default:
                ret = -1;
                break;
        }

        return ret;
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int withReturn(int x) {
        int ret;

        switch (x) {
            case 0:
                return 0;

            case 1:
                return 1;

            case 2:
                ret = 4;
                break;

            default:
                ret = -1;
                break;
        }

        return ret;
    }
}
