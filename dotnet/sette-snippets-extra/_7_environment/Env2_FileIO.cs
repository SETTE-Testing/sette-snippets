/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 *
 * SETTE is a tool to help the evaluation and comparison of symbolic execution
 * based test input generator tools.
 *
 * Budapest University of Technology and Economics (BME)
 *
 * Authors: Lajos Cseppento <lajos.cseppento@inf.mit.bme.hu>, Zoltan Micskei
 * <micskeiz@mit.bme.hu>
 *
 * Copyright 2014-2016
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

using System;
using System.IO;

namespace BME.MIT.SETTE.Environment
{
    public static class Env2_FileIO
    {
        private static DirectoryInfo tmpDirRoot;

        static Env2_FileIO()
        {
            tmpDirRoot = new DirectoryInfo("tmp-snippet");
            deleteIfExists(tmpDirRoot);
            tmpDirRoot.Create();
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessFilename(string filename)
        {
            if (filename == null)
            {
                return -1;
            }

            DirectoryInfo tmpDir = getTmpDir("guessFileName");
            String fn = "test";
            fn += ".txt";
            FileInfo file = new FileInfo(Path.Combine(tmpDir.FullName, fn));
            writeFile(file, "text");

            FileInfo file2 = new FileInfo(Path.Combine(tmpDir.FullName, filename));
            if (file2.Exists)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessFilenameAndContent(string filename, string content)
        {
            if (filename == null || content == null)
            {
                return -1;
            }

            DirectoryInfo tmpDir = getTmpDir("guessFileNameAndContent");
            String fn = "test";
            fn += ".txt";
            FileInfo file = new FileInfo(Path.Combine(tmpDir.FullName, fn));
            writeFile(file, "text");

            FileInfo file2 = new FileInfo(Path.Combine(tmpDir.FullName, filename));
            if (file2.Exists)
            {
                if (readFile(file2).Equals(content))
                {
                    return 1;
                }
                else
                {
                    return 2;
                }
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int guessDirname(string dirname)
        {
            if (dirname == null)
            {
                return -1;
            }

            DirectoryInfo tmpDir = getTmpDir("guessDirName");
            String dn = "te";
            dn += "st";
            DirectoryInfo dir = new DirectoryInfo(Path.Combine(tmpDir.FullName, dn));
            dir.Create();

            DirectoryInfo dir2 = new DirectoryInfo(Path.Combine(tmpDir.FullName, dirname));
            if (dir2.Exists)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int createFile()
        {
            DirectoryInfo tmpDir = getTmpDir("createFile");
            String fn = "test";
            fn += ".txt";
            FileInfo file = new FileInfo(Path.Combine(tmpDir.FullName, fn));

            if (file.Exists) // false if existing directory
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int createFileWithContent()
        {
            DirectoryInfo tmpDir = getTmpDir("createFileWithContent");
            String fn = "test";
            fn += ".txt";
            FileInfo file = new FileInfo(Path.Combine(tmpDir.FullName, fn));

            if (file.Exists) // false if existing directory
            {
                if (readFile(file).Equals("text"))
                {
                    return 1;
                }
                else
                {
                    return 2;
                }
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int createDir()
        {
            DirectoryInfo tmpDir = getTmpDir("createDir");
            String dn = "te";
            dn += "st";
            DirectoryInfo dir = new DirectoryInfo(Path.Combine(tmpDir.FullName, dn));

            if (dir.Exists) // false if existing regular file
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int createDirWithContent()
        {
            DirectoryInfo tmpDir = getTmpDir("createDirWithContent");
            String dn = "te";
            dn += "st";
            DirectoryInfo dir = new DirectoryInfo(Path.Combine(tmpDir.FullName, dn));

            if (dir.Exists)
            {
                String dn2 = "ab";
                dn2 += "cd";
                if (new FileInfo(Path.Combine(dir.FullName, dn2)).Exists)
                {
                    return 1;
                }
                else
                {
                    return 2;
                }
            }
            else
            {
                return 0;
            }
        }

        /// <summary>
        /// Helper method to return create a new temporary directory. Coverage for method is not measured.
        /// </summary>
        /// <returns>a existing tmp directory</returns>
        private static DirectoryInfo getTmpDir(string name)
        {
            return Directory.CreateDirectory("tmp-snippet/" + name);
        }

        private static void deleteIfExists(DirectoryInfo dir)
        {
            if (dir.Exists)
            {
                dir.Delete(true);
            }
        }

        private static void deleteIfExists(FileInfo file)
        {
            if (file.Exists)
            {
                file.Delete();
            }
        }

        private static String readFile(FileInfo file)
        {
            return File.ReadAllText(file.FullName);
        }

        private static void writeFile(FileInfo file, string text)
        {
            File.WriteAllText(file.FullName, text);
        }
    }
}