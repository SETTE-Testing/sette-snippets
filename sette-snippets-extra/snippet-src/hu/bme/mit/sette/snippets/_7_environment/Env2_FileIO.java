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

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import hu.bme.mit.sette.common.annotations.SetteRequiredStatementCoverage;
import hu.bme.mit.sette.common.annotations.SetteSnippetContainer;

@SetteSnippetContainer(category = "Env2", goal = "Check support for file I/O support")
public final class Env2_FileIO {
    private Env2_FileIO() {
        throw new UnsupportedOperationException("Static class");
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessFilename(String filename) throws IOException {
        if (filename == null) {
            return -1;
        }

        File tmpDir = newTmpDir();
        String fn = "test";
        fn += ".txt";
        File file = new File(tmpDir, fn);
        writeFile(file, "text");

        File file2 = new File(tmpDir, filename);
        if (file2.isFile()) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessFilenameAndContent(String filename, String content) throws IOException {
        if (filename == null || content == null) {
            return -1;
        }

        File tmpDir = newTmpDir();
        String fn = "test";
        fn += ".txt";
        File file = new File(tmpDir, fn);
        writeFile(file, "text");

        File file2 = new File(tmpDir, filename);
        if (file2.isFile()) {
            if (readFile(file2).equals(content)) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int guessDirname(String dirname) {
        if (dirname == null) {
            return -1;
        }

        File tmpDir = newTmpDir();
        String dn = "te";
        dn += "st";
        File dir = new File(tmpDir, dn);
        dir.mkdirs();

        File dir2 = new File(tmpDir, dirname);
        if (dir2.isDirectory()) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int createFile() {
        File tmpDir = newTmpDir();
        String fn = "test";
        fn += ".txt";
        File file = new File(tmpDir, fn);

        if (file.isFile()) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int createFileWithContent() throws IOException {
        File tmpDir = newTmpDir();
        String fn = "test";
        fn += ".txt";
        File file = new File(tmpDir, fn);

        if (file.isFile()) {
            if (readFile(file).equals("text")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int createDir() {
        File tmpDir = newTmpDir();
        String dn = "te";
        dn += "st";
        File dir = new File(tmpDir, dn);

        if (dir.isDirectory()) {
            return 1;
        } else {
            return 0;
        }
    }

    @SetteRequiredStatementCoverage(value = 100)
    public static int createDirWithContent() {
        File tmpDir = newTmpDir();
        String dn = "te";
        dn += "st";
        File dir = new File(tmpDir, dn);

        if (dir.isDirectory()) {
            String dn2 = "ab";
            dn2 += "cd";
            if (new File(dir, dn2).exists()) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    /**
     * Helper method to return create a new temporary directory. This method will also try to remove
     * the directory during shutdown. Coverage for method is not measured.
     * 
     * @return a new empty directory
     */
    private static File newTmpDir() {
        try {
            Path tmpDir = Files.createTempDirectory("sette_tmp_");
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    if (!Files.exists(tmpDir)) {
                        return;
                    }

                    try {
                        Files.walkFileTree(tmpDir, new SimpleFileVisitor<Path>() {
                            @Override
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                                    throws IOException {
                                Files.delete(file);
                                return FileVisitResult.CONTINUE;
                            }

                            @Override
                            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                                    throws IOException {
                                Files.delete(dir);
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            return tmpDir.toFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String readFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    private static void writeFile(File file, String text) throws IOException {
        Files.write(file.toPath(), text.getBytes());
    }
}
