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

package hu.bme.mit.sette.snippets.inputs._3_objects;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._3_objects.dependencies.SimpleObject;

public final class O1_Simple_Inputs {
    private O1_Simple_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer oneOperationParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(1);
        inputs.addByParameters(-1);

        return inputs;
    }

    public static SnippetInputContainer oneOperationWithCheck() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, 0);
        inputs.addByParameters(new SimpleObject(), 1);
        inputs.addByParameters(new SimpleObject(), -1);

        return inputs;
    }

    public static SnippetInputContainer oneOperationNoCheck() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByExpectedAndParameters(NullPointerException.class, null, 0);
        inputs.addByParameters(new SimpleObject(), 1);
        inputs.addByParameters(new SimpleObject(), -1);

        return inputs;
    }

    public static SnippetInputContainer twoOperationsParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(1, -1);

        return inputs;
    }

    public static SnippetInputContainer twoOperationsWithCheck() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(null, 0, 0);
        inputs.addByParameters(new SimpleObject(), 1, -1);

        return inputs;
    }

    public static SnippetInputContainer twoOperationsWithNocheck() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByExpectedAndParameters(NullPointerException.class, null, 0, 0);
        inputs.addByParameters(new SimpleObject(), 1, -1);

        return inputs;
    }

    public static SnippetInputContainer guessResultParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(8, 1, -1);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessResult() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(null, 0, 0, 0);
        inputs.addByParameters(new SimpleObject(), 8, 1, -1);
        inputs.addByParameters(new SimpleObject(), 0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleResultParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(1, -1, 0);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleResult() {
        SnippetInputContainer inputs = new SnippetInputContainer(4);

        inputs.addByParameters(null, 0, 0, 0);
        inputs.addByParameters(new SimpleObject(), 1, -1, 0);

        return inputs;
    }

    public static SnippetInputContainer guessOperationCountParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(5);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer guessOperationCount() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, 0);
        inputs.addByParameters(new SimpleObject(), 5);
        inputs.addByParameters(new SimpleObject(), 0);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleOperationCountParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(5);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleOperationCount() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, 0);
        inputs.addByParameters(new SimpleObject(), 5);

        return inputs;
    }

    public static SnippetInputContainer guessResultAndOperationCountParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(2, 5);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessResultAndOperationCount() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(null, 0, 0);
        inputs.addByParameters(new SimpleObject(), 2, 5);
        inputs.addByParameters(new SimpleObject(), 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleResultAndOperationCountParams() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(2, 5);

        return inputs;
    }

    public static SnippetInputContainer guessImpossibleResultAndOperationCount() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(null, 0, 0);
        inputs.addByParameters(new SimpleObject(), 2, 5);

        return inputs;
    }

    public static SnippetInputContainer guessObject() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);

        SimpleObject obj = new SimpleObject();
        obj.addAbs(3);
        obj.addAbs(0);
        obj.addAbs(0);
        inputs.addByParameters(obj);

        inputs.addByParameters(new SimpleObject());

        return inputs;

    }

    public static SnippetInputContainer guessImpossibleObject() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters(new SimpleObject());

        return inputs;
    }

    public static SnippetInputContainer fullCoverage() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null, 0, 0, 0);
        inputs.addByParameters(new SimpleObject(), 5, -5, 2);
        inputs.addByParameters(new SimpleObject(), 0, 0, 0);

        return inputs;
    }
}
