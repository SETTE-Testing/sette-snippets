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
    public static class Env1_StdIO
    {
        // @SetteRequiredStatementCoverage(value = 100)
        public static int writesOneLineToStdin()
        {
            TextReader input = Console.In;
            String line = input.ReadLine();

            if (line == null)
            {
                // wrote EOF
                return 0;
            }
            else if (line.Equals("Test"))
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }

        public static int writesEofToStdin()
        {
            TextReader input = Console.In;

            while (true)
            {
                if (input.ReadLine() == null)
                {
                    return 0;
                }
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int writesOutputBack()
        {
            String data = DateTime.Now.ToString();
            Console.Out.WriteLine(data);

            TextReader input = Console.In;
            String line = input.ReadLine();

            if (line == null)
            {
                return 0;
            }
            else if (line.Equals(data))
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int writesErrorOutputBack()
        {
            String data = DateTime.Now.ToString();
            Console.Error.WriteLine(data);

            TextReader input = Console.In;
            String line = input.ReadLine();

            if (line == null)
            {
                return 0;
            }
            else if (line.Equals(data))
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
    }
}