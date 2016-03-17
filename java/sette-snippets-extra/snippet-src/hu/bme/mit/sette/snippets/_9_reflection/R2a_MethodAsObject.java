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
package hu.bme.mit.sette.snippets._9_reflection;

import java.lang.reflect.Method;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassParent;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyMethodAnnot;
import hu.bme.mit.sette.snippets.inputs._9_reflection.R2a_MethodAsObject_Inputs;

@SetteSnippetContainer(category = "R2", goal = "Check support for java.lang.Method usage",
        inputFactoryContainer = R2a_MethodAsObject_Inputs.class)
public final class R2a_MethodAsObject {
    private R2a_MethodAsObject() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessMethodByNameAndDeclaringClass(Method m) {
        if (m == null) {
            return -1;
        } else if ("value".equals(m.getName()) && m.getDeclaringClass() == MyClassParent.class) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessMethodByNameAndReturnType(Method m) {
        if (m == null) {
            return -1;
        } else if ("value".equals(m.getName()) && m.getReturnType() == int.class) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessMethodByNameAndParameter(Method m) {
        if (m == null) {
            return -1;
        }

        Class<?>[] paramTypes = m.getParameterTypes();

        if ("value".equals(m.getName()) && paramTypes.length == 1 && paramTypes[0] == int.class) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessMethodByAnnotation(Method m) {
        if (m == null) {
            return -1;
        }

        MyMethodAnnot annot = m.getAnnotation(MyMethodAnnot.class);
        if (annot != null) {
            if (annot.value()) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
}
