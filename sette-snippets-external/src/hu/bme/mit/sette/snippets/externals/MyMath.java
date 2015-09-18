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
package hu.bme.mit.sette.snippets.externals;

/**
 * Simple class used for checking support for 3rd party libraries.
 */
public final class MyMath {
    /**
     * Static class.
     */
    private MyMath() {
        throw new UnsupportedOperationException("Static class");
    }

    /**
     * Returns the smaller of the two numbers.
     *
     * @param a
     *            First number
     * @param b
     *            Second number
     * @return The smaller
     */
    public static int min(int a, int b) {
        if (b < a) {
            return b;
        } else {
            return a;
        }
    }

    /**
     * Returns the greater of the two numbers.
     *
     * @param a
     *            First number
     * @param b
     *            Second number
     * @return The greater
     */
    public static int max(int a, int b) {
        if (b > a) {
            return b;
        } else {
            return a;
        }
    }
}
