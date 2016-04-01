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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._8_multithreading.dependencies.ThreadUtils;

@SetteSnippetContainer(category = "T2", goal = "Check support for locks")
public final class T2_Locks {
    private T2_Locks() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(100)
    public static int createsLock(Lock lock) {
        if (lock == null) {
            return -1;
        } else if (lock.tryLock()) {
            lock.unlock();
            return 1;
        } else {
            return 0;
        }
    }

    private static volatile boolean success;

    @SetteRequiredStatementCoverage(100)
    public static int signalAwait(final int x) {
        success = false;
        final Lock lock = new ReentrantLock();
        final Condition canProceed = lock.newCondition();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                ThreadUtils.sleep(50);
                lock.lock();
                try {
                    if (x == 12345) {
                        canProceed.signal();
                    }
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                try {
                    success = ThreadUtils.await(canProceed, 100, TimeUnit.MILLISECONDS);
                } finally {
                    lock.unlock();
                }
            }
        };

        ThreadUtils.startAll(t1, t2);
        ThreadUtils.joinAll(t1, t2);

        if (success) {
            return 1;
        } else {
            return 0;
        }
    }
}
