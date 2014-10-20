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
package hu.bme.mit.sette.snippets._3_objects;

import hu.bme.mit.sette.annotations.SetteIncludeCoverage;
import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleExtendedObject;
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleObject;
import hu.bme.mit.sette.snippets.inputs._3_objects.O3a_Inheritance_Inputs;

@SetteSnippetContainer(category = "O3",
        goal = "Check support for class inheritance",
        inputFactoryContainer = O3a_Inheritance_Inputs.class)
public final class O3a_Inheritance {
    private O3a_Inheritance() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class, SimpleExtendedObject.class },
            methods = { "addAbs(int)", "getResult()",
                    "subtractAbs(int)" })
    public static int guessResultParams(int x1, int x2, int x3) {
        SimpleExtendedObject obj = new SimpleExtendedObject();

        obj.addAbs(x1);
        obj.addAbs(x2);
        obj.subtractAbs(x3);

        if (obj.getResult() == 10) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class, SimpleExtendedObject.class },
            methods = { "addAbs(int)", "getResult()",
                    "subtractAbs(int)" })
    public static int guessResult(SimpleExtendedObject obj, int x1,
            int x2, int x3) {
        if (obj == null) {
            return -1;
        }

        obj.addAbs(x1);
        obj.addAbs(x2);
        obj.subtractAbs(x3);

        if (obj.getResult() == 10) {
            return 1;
        } else {
            return 0;
        }
    }

}
