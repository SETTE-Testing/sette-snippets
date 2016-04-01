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

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassAnnot;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassParent;
import hu.bme.mit.sette.snippets._9_reflection.dependencies.MyInterface1;
import hu.bme.mit.sette.snippets.inputs._9_reflection.R1b_ClassWithLoading_Inputs;

@SetteSnippetContainer(category = "R1", goal = "Check support for java.lang.Class usage",
        inputFactoryContainer = R1b_ClassWithLoading_Inputs.class)
public final class R1b_ClassWithLoading {
    private R1b_ClassWithLoading() {
        throw new UnsupportedOperationException("Static class");
    }

    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassByName(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        } else if ("java.lang.String".equals(cls.getName())) {
            return 1;
        } else if ("[I".equals(cls.getName())) {
            return 2;
        } else if ("hu.bme.mit.sette.snippets._9_reflection.dependencies.MyClassParent"
                .equals(cls.getName())) {
            return 3;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassBySimpleName(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        } else if ("String".equals(cls.getSimpleName())) {
            return 1;
        } else if ("int[]".equals(cls.getSimpleName())) {
            return 2;
        } else if ("MyClassParent".equals(cls.getSimpleName())) {
            return 3;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassByMethodWithoutParams(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        }

        try {
            cls.getMethod("value");
            return 1;
        } catch (NoSuchMethodException ex) {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassByMethodWithParams(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        }

        try {
            cls.getMethod("value", int.class);
            return 1;
        } catch (NoSuchMethodException ex) {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassByField(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        }

        try {
            cls.getDeclaredField("value");
            return 1;
        } catch (NoSuchFieldException ex) {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassByInterface(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        }

        Class<?>[] ifaces = cls.getInterfaces();

        if (ifaces.length == 1 && ifaces[0] == MyInterface1.class) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassBySuperclass(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        } else if (cls.getSuperclass() == MyClassParent.class) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessClassByAnnotation(String className) {
        Class<?> cls = loadClass(className);

        if (cls == null) {
            return -1;
        }

        MyClassAnnot annot = cls.getAnnotation(MyClassAnnot.class);
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
