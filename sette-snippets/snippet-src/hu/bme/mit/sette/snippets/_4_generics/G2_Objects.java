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

package hu.bme.mit.sette.snippets._4_generics;

import hu.bme.mit.sette.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._4_generics.dependencies.GenericTriplet;
import hu.bme.mit.sette.snippets._4_generics.dependencies.IntegerTriplet;
import hu.bme.mit.sette.snippets._4_generics.dependencies.SafeGenericTriplet;
import hu.bme.mit.sette.snippets.inputs._4_generics.G2_Objects_Inputs;

@SetteSnippetContainer(category = "G2", goal = "Check support for generic objects",
        inputFactoryContainer = G2_Objects_Inputs.class)
public final class G2_Objects {
    private G2_Objects() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean guessInteger(GenericTriplet<Integer> obj) {
        if (obj.get(0).equals(new Integer(1))) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean guessIntegerNoHelp(GenericTriplet<?> obj) {
        if (obj.get(0).equals(new Integer(1))) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean guessImpossible(GenericTriplet<Double> obj) {
        if (obj.get(0).equals(new Object())) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static boolean guessDescendant(IntegerTriplet obj) {
        if (obj.get(0).equals(new Integer(1))) {
            return true;
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean guessSafe(SafeGenericTriplet<?> obj) {
        if (obj.get(4) != null) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return false;
        }
    }

    @SetteRequiredStatementCoverage(value = 50)
    public static boolean guessSafeNoHelp(GenericTriplet<?> obj) {
        if (obj.get(4) != null) {
            // impossible branch
            throw new RuntimeException();
        } else {
            return false;
        }
    }
}
