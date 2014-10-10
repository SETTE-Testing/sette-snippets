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
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleObject;
import hu.bme.mit.sette.snippets.inputs._3_objects.O1_Simple_Inputs;

@SetteSnippetContainer(category = "O1", goal = "Check support for basic object usage", inputFactoryContainer = O1_Simple_Inputs.class)
public final class O1_Simple {
    private O1_Simple() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int oneOperationParams(int x) {
        SimpleObject obj = new SimpleObject();
        obj.addAbs(x);
        return obj.getResult();
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int oneOperationWithCheck(SimpleObject obj, int x) {
        if (obj == null) {
            return -1;
        }

        obj.addAbs(x);
        return obj.getResult();
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int oneOperationNoCheck(SimpleObject obj, int x) {
        obj.addAbs(x);
        return obj.getResult();
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class, SimpleObject.class }, methods = {
            "addAbs(int)", "chainedAddAbs(int)", "getResult()" })
    public static int twoOperationsParams(int x1, int x2) {
        SimpleObject obj = new SimpleObject();
        obj.addAbs(x1);
        return obj.chainedAddAbs(x2).getResult();
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class, SimpleObject.class }, methods = {
            "addAbs(int)", "chainedAddAbs(int)", "getResult()" })
    public static int twoOperationsWithCheck(SimpleObject obj, int x1,
            int x2) {
        if (obj == null) {
            return -1;
        }

        obj.addAbs(x1);
        return obj.chainedAddAbs(x2).getResult();
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class, SimpleObject.class }, methods = {
            "addAbs(int)", "chainedAddAbs(int)", "getResult()" })
    public static int twoOperationsWithNocheck(SimpleObject obj,
            int x1, int x2) {
        obj.addAbs(x1);
        return obj.chainedAddAbs(x2).getResult();
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int guessResultParams(int x1, int x2, int x3) {
        SimpleObject obj = new SimpleObject();

        obj.addAbs(x1);
        obj.addAbs(x2);
        obj.addAbs(x3);

        if (obj.getResult() == 10) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int guessResult(SimpleObject obj, int x1, int x2,
            int x3) {
        if (obj == null) {
            return -1;
        }

        obj.addAbs(x1);
        obj.addAbs(x2);
        obj.addAbs(x3);

        if (obj.getResult() == 10) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 90)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int guessImpossibleResultParams(int x1, int x2, int x3) {
        SimpleObject obj = new SimpleObject();

        obj.addAbs(x1);
        obj.addAbs(x2);
        obj.addAbs(x3);

        if (obj.getResult() < 0) {
            // impossible
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 90)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "addAbs(int)",
            "getResult()" })
    public static int guessImpossibleResult(SimpleObject obj, int x1,
            int x2, int x3) {
        if (obj == null) {
            return -1;
        }

        obj.addAbs(x1);
        obj.addAbs(x2);
        obj.addAbs(x3);

        if (obj.getResult() < 0) {
            // impossible
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class }, methods = { "getOperationCount()" })
    public static int guessOperationCountParams(int oc) {
        SimpleObject obj = new SimpleObject();

        for (int i = 0; i < oc; i++) {
            obj.addAbs(1);
        }

        if (obj.getOperationCount() == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class }, methods = { "getOperationCount()" })
    public static int guessOperationCount(SimpleObject obj, int oc) {
        if (obj == null) {
            return -1;
        }

        for (int i = 0; i < oc; i++) {
            obj.addAbs(1);
        }

        if (obj.getOperationCount() == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class }, methods = { "getOperationCount()" })
    public static int guessImpossibleOperationCountParams(int oc) {
        SimpleObject obj = new SimpleObject();

        for (int i = 0; i < oc; i++) {
            obj.addAbs(1);
        }

        if (obj.getOperationCount() < 0) {
            // impossible
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class }, methods = { "getOperationCount()" })
    public static int guessImpossibleOperationCount(SimpleObject obj,
            int oc) {
        if (obj == null) {
            return -1;
        }

        for (int i = 0; i < oc; i++) {
            obj.addAbs(1);
        }

        if (obj.getOperationCount() < 0) {
            // impossible
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "getResult()",
            "getOperationCount()" })
    public static int guessResultAndOperationCountParams(int x, int oc) {
        SimpleObject obj = new SimpleObject();

        for (int i = 0; i < oc; i++) {
            obj.addAbs(x);
        }

        if (obj.getResult() == 10 && obj.getOperationCount() == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "getResult()",
            "getOperationCount()" })
    public static int guessResultAndOperationCount(SimpleObject obj,
            int x, int oc) {
        if (obj == null) {
            return -1;
        }

        for (int i = 0; i < oc; i++) {
            obj.addAbs(x);
        }

        if (obj.getResult() == 10 && obj.getOperationCount() == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 75)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "getResult()",
            "getOperationCount()" })
    public static int guessImpossibleResultAndOperationCountParams(
            int x, int oc) {
        SimpleObject obj = new SimpleObject();

        for (int i = 0; i < oc; i++) {
            obj.addAbs(x);
        }

        if (obj.getResult() == 10 && obj.getOperationCount() == 4) {
            // impossible
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 80)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "getResult()",
            "getOperationCount()" })
    public static int guessImpossibleResultAndOperationCount(
            SimpleObject obj, int x, int oc) {
        if (obj == null) {
            return -1;
        }

        for (int i = 0; i < oc; i++) {
            obj.addAbs(x);
        }

        if (obj.getResult() == 10 && obj.getOperationCount() == 4) {
            // impossible
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "getResult()",
            "getOperationCount()" })
    public static int guessObject(SimpleObject obj) {
        if (obj == null) {
            return -1;
        }

        if (obj.getOperationCount() == 2 && obj.getResult() == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 66)
    @SetteIncludeCoverage(classes = { SimpleObject.class,
            SimpleObject.class }, methods = { "getResult()",
            "getOperationCount()" })
    public static int guessImpossibleObject(SimpleObject obj) {
        if (obj == null) {
            return -1;
        }

        if (obj.getOperationCount() < 0 || obj.getResult() < 0) {
            // invalid object, cannot be created with method calls
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    @SetteIncludeCoverage(classes = { SimpleObject.class }, methods = { "*" })
    public static int fullCoverage(SimpleObject obj, int x1, int x2,
            int oc) {
        if (obj == null) {
            return -1;
        }

        obj.chainedAddAbs(x1).addAbs(x2);

        if (obj.getResult() == 10 && oc == obj.getOperationCount()) {
            return 1;
        } else {
            return 0;
        }
    }
}
