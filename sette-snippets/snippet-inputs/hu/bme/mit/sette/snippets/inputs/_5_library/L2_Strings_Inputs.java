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
package hu.bme.mit.sette.snippets.inputs._5_library;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class L2_Strings_Inputs {
    private L2_Strings_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer equality() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("test");
        inputs.addByParameters("TeStInG");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer equalityIgnoreCase() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("test");
        inputs.addByParameters("testing");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer add() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, null);
        inputs.addByParameters(null, "");
        inputs.addByParameters("", null);
        inputs.addByParameters("", "");

        return inputs;
    }

    public static SnippetInputContainer addWithCondition() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(null, null);
        inputs.addByParameters(null, "");
        inputs.addByParameters("", null);
        inputs.addByParameters("ab", "");
        inputs.addByParameters("a", "b");
        inputs.addByParameters("", "");

        return inputs;
    }

    public static SnippetInputContainer length() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("1234567890");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer charAt() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParametersAndExpected(
                IndexOutOfBoundsException.class, "");
        inputs.addByParameters("1234567890X");
        inputs.addByParameters("1234567890 ");

        return inputs;
    }

    public static SnippetInputContainer regionEquality() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("1234567890part");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer compareTo() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("abcde");
        inputs.addByParameters("efghi");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer compareToIgnoreCase() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("abcde");
        inputs.addByParameters("efghi");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer startsEnds() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("test error");
        inputs.addByParameters("test");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer indexOf() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("test567890test567890test");
        inputs.addByParameters("");

        return inputs;
    }

    public static SnippetInputContainer substring() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters((Object) null);
        inputs.addByParameters("ab3456xy");
        inputs.addByParameters("");

        return inputs;
    }
}
