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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import hu.bme.mit.sette.common.annotations.SetteIncludeCoverage;
import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassChild;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassParent;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyInterface2;
import hu.bme.mit.sette.snippets.inputs._9_reflection.R3_ObjectsAndReflection_Inputs;

@SetteSnippetContainer(category = "R3", goal = "Check support for objects and reflection",
        inputFactoryContainer = R3_ObjectsAndReflection_Inputs.class)
public final class R3_ObjectsAndReflection {
    private R3_ObjectsAndReflection() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessObjectWithClass(Object o) {
        if (o == null) {
            return -1;
        } else if (o.getClass() == MyClassChild.class) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessObjectWithInstanceOfClass(Object o) {
        if (o == null) {
            return -1;
        } else if (o instanceof MyClassChild) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessObjectWithInstanceOfInterface(Object o) {
        if (o == null) {
            return -1;
        } else if (o instanceof MyInterface2) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    @SetteIncludeCoverage(classes = { MyClassParent.class }, methods = "value(int)")
    public static int useObjectWithDirectCall(Object o, int v) {
        if (o == null) {
            return -1;
        } else if (o instanceof MyClassChild) {
            MyClassChild obj = (MyClassChild) o;
            obj.value(v);
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    @SetteIncludeCoverage(classes = { MyClassParent.class }, methods = "value(int)")
    public static int useObjectWithInvoke(Object o, String methodName, int v) {
        if (o == null) {
            return -1;
        } else if (o instanceof MyClassChild) {
            Method m;
            try {
                m = o.getClass().getMethod(methodName, int.class);
                m.invoke(o, v);
                return 1;
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException
                    | NullPointerException | IllegalArgumentException ex) {
                return 2;
            }
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int instantiateObject(Class<?> cls) {
        if (cls == null) {
            return -1;
        }

        try {
            Object o = cls.newInstance();

            if (o instanceof MyClassChild) {
                return 1;
            } else {
                return 0;
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            return -2;
        }
    }
}
