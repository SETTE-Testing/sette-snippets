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
 * Copyright 2014-2016
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
package hu.bme.mit.sette.snippets.inputs._9_reflection;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassChild;

public final class R3_ObjectsAndReflection_Inputs {
    private R3_ObjectsAndReflection_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessObjectWithClass() {
        SnippetInputContainer sic = new SnippetInputContainer(1);
        sic.addByParameters((Object) null);
        sic.addByParameters(new MyClassChild());
        sic.addByParameters(new Object());
        return sic;
    }

    public static SnippetInputContainer guessObjectWithInstanceOfClass() {
        return guessObjectWithClass();
    }

    public static SnippetInputContainer guessObjectWithInstanceOfInterface() {
        return guessObjectWithClass();
    }

    public static SnippetInputContainer useObjectWithDirectCall() {
        SnippetInputContainer sic = new SnippetInputContainer(2);
        sic.addByParameters(null, 0);
        sic.addByParameters(new MyClassChild(), 12345);
        sic.addByParameters(new MyClassChild(), 1);
        sic.addByParameters(new MyClassChild(), -1);
        sic.addByParameters(new Object(), 0);
        return sic;
    }

    public static SnippetInputContainer useObjectWithInvoke() {
        SnippetInputContainer sic = new SnippetInputContainer(3);
        sic.addByParameters(null, null, 0);
        sic.addByParameters(new MyClassChild(), null, 0);
        sic.addByParameters(new MyClassChild(), "value", 12345);
        sic.addByParameters(new MyClassChild(), "value", 1);
        sic.addByParameters(new MyClassChild(), "value", -1);
        sic.addByParameters(new Object(), null, 0);
        return sic;
    }

    public static SnippetInputContainer instantiateObject() {
        SnippetInputContainer sic = new SnippetInputContainer(1);
        sic.addByParameters((Object) null);
        sic.addByParameters(MyClassChild.class);
        sic.addByParameters(Object.class);
        sic.addByParameters(Integer.class);
        return sic;
    }
}
