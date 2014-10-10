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
package hu.bme.mit.sette.snippets.inputs._1_basic.B1_types_and_operators;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

public final class B1a_PrimitiveTypes_Inputs {
    private B1a_PrimitiveTypes_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer oneParamBoolean() {
        return new SnippetInputContainer(1).addByParameters(false);
    }

    public static SnippetInputContainer twoParamBoolean() {
        return new SnippetInputContainer(2).addByParameters(false,
                false);
    }

    public static SnippetInputContainer oneParamByte() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer twoParamByte() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer oneParamShort() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer twoParamShort() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer oneParamInt() {
        return new SnippetInputContainer(1).addByParameters(1);
    }

    public static SnippetInputContainer twoParamInt() {
        return new SnippetInputContainer(2).addByParameters(1, 1);
    }

    public static SnippetInputContainer oneParamLong() {
        return new SnippetInputContainer(1).addByParameters(1L);
    }

    public static SnippetInputContainer twoParamLong() {
        return new SnippetInputContainer(2).addByParameters(1L, 1L);
    }

    public static SnippetInputContainer oneParamFloat() {
        return new SnippetInputContainer(1).addByParameters(1.0f);
    }

    public static SnippetInputContainer twoParamFloat() {
        return new SnippetInputContainer(2).addByParameters(1.0f, 1.0f);
    }

    public static SnippetInputContainer oneParamDouble() {
        return new SnippetInputContainer(1).addByParameters(1.0);
    }

    public static SnippetInputContainer twoParamDouble() {
        return new SnippetInputContainer(2).addByParameters(1.0, 1.0);
    }

    public static SnippetInputContainer oneParamChar() {
        return new SnippetInputContainer(1).addByParameters(' ');
    }

    public static SnippetInputContainer twoParamChar() {
        return new SnippetInputContainer(2).addByParameters(' ', ' ');
    }
}
