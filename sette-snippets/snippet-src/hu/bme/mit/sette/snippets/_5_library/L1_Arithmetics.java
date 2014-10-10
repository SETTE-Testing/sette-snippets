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
package hu.bme.mit.sette.snippets._5_library;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._5_library.L1_Arithmetics_Inputs;

@SetteSnippetContainer(category = "L1", goal = "Check support for complex arithmetic functions", inputFactoryContainer = L1_Arithmetics_Inputs.class)
public final class L1_Arithmetics {
    private L1_Arithmetics() {
        throw new UnsupportedOperationException("Static class");
    }

    public static final double EPSILON = 10e-3;

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean abs(int x, int y) {
        if (Math.abs(x) == 5 || Math.abs(y) == 10) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean absImpossible(int x, int y) {
        if (Math.abs(x) == -5 || Math.abs(y) == -10) {
            // impossible
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean minMax(int a, int b) {
        if (Math.min(a, b) == -10 && Math.max(a, b) == 20) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean minMaxWithOrder(int a, int b) {
        if (Math.min(a, b) == -10 && Math.max(a, b) == 20 && a < b) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean minMaxImpossible(int a, int b) {
        if (Math.min(a, b) == -10 && Math.max(a, b) == 10
                && Math.max(a, b) == 20) {
            // impossible
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean sqrt(double x) {
        double s = Math.sqrt(x) - 2;

        if (-L1_Arithmetics.EPSILON < s && s < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean sqrtImpossible(double x) {
        if (Math.sqrt(x) == -1) {
            // impossible
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean cbrt(double x) {
        double c = Math.cbrt(x) - 2;

        if (-L1_Arithmetics.EPSILON < c && c < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean powGuessBase(double x) {
        double p = Math.pow(x, 10) - 1024;

        if (-L1_Arithmetics.EPSILON < p && p < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean powGuessExponent(double x) {
        double p = Math.pow(2, x) - 1024;

        if (-L1_Arithmetics.EPSILON < p && p < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean powGuessBaseAndExponent(double x, double y) {
        double p = Math.pow(x, y) - 1024;

        if (-L1_Arithmetics.EPSILON < p && p < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean log10GuessArgument(double x) {
        double l = Math.log10(x) - 2;

        if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean logGuessBase(double x) {
        double l = Math.log(100) / Math.log(x) - 2;

        if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean logGuessArgument(double x) {
        double l = Math.log(x) / Math.log(10) - 2;

        if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean logGuessBaseAndArgument(double x, double y) {
        double l = Math.log(y) / Math.log(x) - 2;

        if (-L1_Arithmetics.EPSILON < l && l < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean sin(double x) {
        double s = Math.sin(x) - 0.5;

        if (-L1_Arithmetics.EPSILON < s && s < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean sinImpossible(double x) {
        if (Math.sin(x) == 2) {
            // impossible
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean cos(double x) {
        double c = Math.cos(x) - 0.5;

        if (-L1_Arithmetics.EPSILON < c && c < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean cosImpossible(double x) {
        if (Math.cos(x) == 2) {
            // impossible
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean tan(double x) {
        double t = Math.tan(x) - 1;

        if (-L1_Arithmetics.EPSILON < t && t < L1_Arithmetics.EPSILON) {
            return true;
        } else {
            return false;
        }
    }
}
