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

package hu.bme.mit.sette.snippets._5_library;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._5_library.L2_Strings_Inputs;

@SetteSnippetContainer(category = "L2", goal = "Check support for strings",
        inputFactoryContainer = L2_Strings_Inputs.class)
public final class L2_Strings {
    private L2_Strings() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 80)
    public static int equality(String s) {
        if (s == null) {
            return -1;
        } else if (s.equals("test")) {
            return 1;
        } else if (s.equals("TeStInG")) {
            return 2;
        } else if (s.equals("test") && s.equals("TeStInG")) {
            // impossible
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 80)
    public static int equalityIgnoreCase(String s) {
        if (s == null) {
            return -1;
        } else if (s.equalsIgnoreCase("test")) {
            return 1;
        } else if (s.equalsIgnoreCase("TeStInG")) {
            return 2;
        } else if (s.equalsIgnoreCase("test") && s.equalsIgnoreCase("TeStInG")) {
            // impossible
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static String add(String a, String b) {
        if (a == null && b == null) {
            return "both null";
        } else if (a == null) {
            return "a null";
        } else if (b == null) {
            return "b null";
        } else {
            return a + b;
        }
    }

    @SetteRequiredStatementCoverage(value = 92)
    public static int addWithCondition(String a, String b) {
        if (a == null && b == null) {
            return 0;
        } else if (a == null) {
            return -1;
        } else if (b == null) {
            return -2;
        } else if ((a + b).equals("ab") && a.equals("a")) {
            return 2;
        } else if ((a + b).equals("ab")) {
            return 1;
        } else if ((a + b).equals("ab") && a.equals("c")) {
            // impossible
            throw new RuntimeException();
        } else {
            return -3;
        }
    }

    @SetteRequiredStatementCoverage(value = 75)
    public static int length(String s) {
        if (s == null) {
            return -1;
        } else if (s.length() == 10) {
            return 1;
        } else if (s.length() == 5 && s.length() == 10) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 75)
    public static int charAt(String s) {
        if (s == null) {
            return -1;
        } else if (s.charAt(10) == 'X') {
            return 1;
        } else if (s.charAt(10) == 'X' && s.charAt(10) == 'Y') {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 75)
    public static int regionEquality(String s) {
        if (s == null) {
            return -1;
        } else if (s.regionMatches(false, 10, "part", 0, 4)) {
            return 1;
        } else if (s.regionMatches(false, 10, "part", 0, 4)
                && s.regionMatches(false, 10, "test", 0, 4)) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 80)
    public static int compareTo(String s) {
        if (s == null) {
            return -1;
        } else if (s.compareTo("abcdd") > 0 && s.compareTo("abcdf") < 0) {
            return 1;
        } else if (s.compareTo("efghh") > 0 && s.compareTo("efghj") < 0) {
            return 2;
        } else if (s.compareTo("bbb") > 0 && s.compareTo("aaa") < 0) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 80)
    public static int compareToIgnoreCase(String s) {
        if (s == null) {
            return -1;
        } else if (s.compareToIgnoreCase("abcdd") > 0 && s.compareToIgnoreCase("abcdf") < 0) {
            return 1;
        } else if (s.compareToIgnoreCase("EfGhH") > 0 && s.compareToIgnoreCase("eFgHj") < 0) {
            return 2;
        } else if (s.compareToIgnoreCase("bbb") > 0 && s.compareToIgnoreCase("aaa") < 0) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int startsEnds(String s) {
        if (s == null) {
            return -1;
        } else if (s.startsWith("test")) {
            if (s.endsWith("error")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 75)
    public static int indexOf(String s) {
        if (s == null) {
            return -1;
        } else if (s.indexOf("test") == 0 && s.indexOf("test", 1) == 10
                && s.lastIndexOf("test") == 20) {
            return 1;
        } else if (s.indexOf("test") == 0 && s.indexOf("test", 1) == 1) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 75)
    public static int substring(String s) {
        if (s == null) {
            return -1;
        } else if (s.substring(0, 2).equals("ab") && (s.substring(6, 8).equals("xy"))) {
            return 1;
        } else if (s.substring(0, 2).equals("ab") && s.substring(1, 3).equals("xy")) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return 0;
        }
    }
}
