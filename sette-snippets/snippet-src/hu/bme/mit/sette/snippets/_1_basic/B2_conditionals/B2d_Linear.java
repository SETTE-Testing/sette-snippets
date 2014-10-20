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
package hu.bme.mit.sette.snippets._1_basic.B2_conditionals;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets.inputs._1_basic.B2_conditionals.B2d_Linear_Inputs;

@SetteSnippetContainer(category = "B2",
        goal = "Check constraint solving for linear expressions",
        inputFactoryContainer = B2d_Linear_Inputs.class)
public final class B2d_Linear {
    private B2d_Linear() {
        throw new UnsupportedOperationException("Static class");
    }

    /**
     * Equation: 20x+2 = 42<br/>
     * Solution: x = 2
     *
     * @param x
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean oneParamInt(int x) {
        if (20 * x + 2 == 42) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation: 20x+2 = 41<br/>
     * Solution: x = 1.95 (not integer)
     *
     * @param x
     * @return
     */
    @SetteRequiredStatementCoverage(value = 50)
    public static boolean oneParamIntNoSolution(int x) {
        if (20 * x + 2 == 41) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y = 3<br/>
     * 3x+4y = 11<br/>
     * <br/>
     * Solution: {x, y} = {5, -1}
     *
     * @param x
     * @param y
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean twoParamsInt(int x, int y) {
        int e1 = x + 2 * y;
        int e2 = 3 * x + 4 * y;

        if (e1 == 3 && e2 == 11) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y = 3<br/>
     * 3x+4y = 10<br/>
     * <br/>
     * Solution: {x, y} = {4, -0.5} (not integer)
     *
     * @param x
     * @param y
     * @return
     */
    @SetteRequiredStatementCoverage(value = 66)
    public static boolean twoParamsIntNoSolution(int x, int y) {
        int e1 = x + 2 * y;
        int e2 = 3 * x + 4 * y;

        if (e1 == 3 && e2 == 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y+3z = 9<br/>
     * 3x+y-2z = 10<br/>
     * 5x-y-z = 24<br/>
     * <br/>
     * Solution: {x, y, z} = {5, -1, 2}
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean threeParamsInt(int x, int y, int z) {
        int e1 = x + 2 * y + 3 * z;
        int e2 = 3 * x + y - 2 * z;
        int e3 = 5 * x - y - z;

        if (e1 == 9 && e2 == 10 && e3 == 24) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y+3z = 9<br/>
     * 3x+y-2z = 10<br/>
     * 5x-y-z = 23<br/>
     * <br/>
     * Solution: {x, y, z} = {198/41, -30/41, 77/41}<br/>
     * Solution with overflow (32bit integer): {x, y, z} = {-1257063594,
     * 1361818898, 942797701}
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    @SetteRequiredStatementCoverage(value = 71)
    public static boolean threeParamsIntNoSolution(int x, int y, int z) {
        int e1 = x + 2 * y + 3 * z;
        int e2 = 3 * x + y - 2 * z;
        int e3 = 5 * x - y - z;

        if (e1 == 9 && e2 == 10 && e3 == 23) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation: 20x+2 = 41<br/>
     * Solution: x = 1.95
     *
     * @param x
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean oneParamFloat(float x) {
        if (20 * x + 2 == 41) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y = 3<br/>
     * 3x+4y = 10<br/>
     * <br/>
     * Solution: {x, y} = {4, -0.5}
     *
     * @param x
     * @param y
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean twoParamsFloat(float x, float y) {
        float e1 = x + 2 * y;
        float e2 = 3 * x + 4 * y;

        if (e1 == 3 && e2 == 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y+3z = 9<br/>
     * 3x+y-2z = 10<br/>
     * 5x-y-z = 23<br/>
     * <br/>
     * Solution: {x, y, z} = {198/41, -30/41, 77/41}<br/>
     * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
     * they may not be supported)
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean threeParamsFloat(float x, float y, float z) {
        float e1 = x + 2 * y + 3 * z;
        float e2 = 3 * x + y - 2 * z;
        float e3 = 5 * x - y - z;

        if (8.999f < e1 && e1 < 9.001f && 9.999f < e2 && e2 < 10.001f
                && 22.999f < e3 && e3 < 23.001f) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation: 20x+2 = 41<br/>
     * Solution: x = 1.95
     *
     * @param x
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean oneParamDouble(double x) {
        if (20 * x + 2 == 41) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y = 3<br/>
     * 3x+4y = 10<br/>
     * <br/>
     * Solution: {x, y} = {4, -0.5}
     *
     * @param x
     * @param y
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean twoParamsDouble(double x, double y) {
        double e1 = x + 2 * y;
        double e2 = 3 * x + 4 * y;

        if (e1 == 3 && e2 == 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Equation system:<br/>
     * <br/>
     * x+2y+3z = 9<br/>
     * 3x+y-2z = 10<br/>
     * 5x-y-z = 23<br/>
     * <br/>
     * Solution: {x, y, z} = {198/41, -30/41, 77/41} <br/>
     * Threshold: 1e-3 (Note: constants and Math.abs() cannot be used because
     * they may not be supported)
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    @SetteRequiredStatementCoverage(value = 100)
    public static boolean threeParamsDouble(double x, double y, double z) {
        double e1 = x + 2 * y + 3 * z;
        double e2 = 3 * x + y - 2 * z;
        double e3 = 5 * x - y - z;

        if (8.999 < e1 && e1 < 9.001 && 9.999 < e2 && e2 < 10.001
                && 22.999 < e3 && e3 < 23.001) {
            return true;
        } else {
            return false;
        }
    }
}
