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
package hu.bme.mit.sette.snippets._8_multithreading;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._8_multithreading.dependencies.ThreadUtils;

// fork is needed because threads are used
@SetteSnippetContainer(category = "T1", goal = "Check support for threads",
        forkDuringEvaluation = true)
public final class T1_Threads {
    private T1_Threads() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(100)
    public static int canNameThread() {
        String tn = Thread.currentThread().getName();
        if ("custom thread name".equals(tn)) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(30)
    public static int canInterruptSleep() {
        try {
            Thread.sleep(Long.MAX_VALUE);
            return 0; // never reaches
        } catch (InterruptedException ex) {
            return 1;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int canStartEnoughThreads(final int maxDepth) {
        Thread t = new Thread() {
            @Override
            public void run() {
                forkBomb(0, maxDepth);
            }
        };

        t.start();

        while (t.isAlive()) {
            // for maxDepth 15-30 it usually works
            int tc = Thread.activeCount();
            if (20 <= tc && tc <= 50) {
                return 1;
            }
        }

        return 0;
    }

    private static void forkBomb(final int depth, final int maxDepth) {
        if (depth > maxDepth) {
            return;
        }

        new Thread() {
            @Override
            public void run() {
                forkBomb(depth + 1, maxDepth);
                forkBomb(depth + 1, maxDepth);
            }
        }.start();

        ThreadUtils.sleep(100);
    }
}
