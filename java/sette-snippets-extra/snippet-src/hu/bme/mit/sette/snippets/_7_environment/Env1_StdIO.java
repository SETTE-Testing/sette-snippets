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

package hu.bme.mit.sette.snippets._7_environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;

@SetteSnippetContainer(category = "Env1", goal = "Check support for standard I/O support")
public final class Env1_StdIO {
    private Env1_StdIO() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int writesOneLineToStdin() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        if (line == null) {
            return 0;
        } else if (line.equals("Test")) {
            return 1;
        } else {
            return 2;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int writesEofToStdin() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            if (in.readLine() == null) {
                return 0;
            }
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int writesOutputBack() throws IOException {
        String data = new Date().toString();
        System.out.println(data);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        if (line == null) {
            return 0;
        } else if (line.equals(data)) {
            return 1;
        } else {
            return 2;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int writesErrorOutputBack() throws IOException {
        String data = new Date().toString();
        System.err.println(data);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        if (line == null) {
            return 0;
        } else if (line.equals(data)) {
            return 1;
        } else {
            return 2;
        }
    }
}
