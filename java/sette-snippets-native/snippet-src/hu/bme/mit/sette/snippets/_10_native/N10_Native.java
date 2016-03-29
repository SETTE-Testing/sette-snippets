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
package hu.bme.mit.sette.snippets._10_native;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.Date;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;
import hu.bme.mit.sette.snippets._10_native.dependencies.NativeFunction;
import hu.bme.mit.sette.snippets._10_native.dependencies.NativeObject;
import hu.bme.mit.sette.snippets.inputs._10_native.N10_Native_Inputs;

@SetteSnippetContainer(category = "N10", goal = "Check support for native library",
        inputFactoryContainer = N10_Native_Inputs.class)
public final class N10_Native {
    static {
        loadNativeLibrary();
    }

    private N10_Native() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(100)
    public static int guessNumber(int x) {
        if (NativeFunction.fun(x) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(100)
    public static int reachState(int a, int b, int c) {
        NativeObject obj = new NativeObject();

        obj.calculate(a);
        obj.calculate(b);
        obj.calculate(c);

        if (obj.getX() == 2016) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void loadNativeLibrary() {
        // System.loadLibrary("N10") requires setting -Djava.library.path everywhere
        // in addition, it does not allow copying the library to temporary places
        // (latter required for SETTE since library/classloader unload is undeterministic)
        String pathToLib;
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            pathToLib = "snippet-lib/N10.dll";
        } else {
            pathToLib = "snippet-lib/libN10.so";
        }

        File lib = new File(pathToLib);
        if (lib.exists()) {
            // for tools
            loadNativeLibraryTmpCopy(lib);
        } else {
            pathToLib = pathToLib.replaceAll(".*/", "");

            // for SETTE
            String[] dirs = System.getProperty("java.library.path").split(File.pathSeparator);
            for (String dir : dirs) {
                lib = new File(dir, pathToLib);
                if (lib.exists()) {
                    loadNativeLibraryTmpCopy(lib);
                    return;
                }
            }

            throw new RuntimeException("Cannot load " + pathToLib);
        }
    }

    private static void loadNativeLibraryTmpCopy(File lib) {
        String prefix = "tmp_" + new Date().getTime();
        File tmp = new File(lib.getParentFile(), prefix + "_" + lib.getName());
        tmp.deleteOnExit();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                tmp.delete(); // maybe cannot delete if still loaded
            }
        });

        try {
            Files.copy(lib.toPath(), tmp.toPath());
            System.load(tmp.getAbsolutePath());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
