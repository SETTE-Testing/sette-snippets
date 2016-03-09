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

using System;
using System.Text.RegularExpressions;

using BME.MIT.SETTE.Library.Dependencies;

namespace BME.MIT.SETTE.Library
{
    public static class LO_Other
    {
        //@SetteRequiredStatementCoverage(value = 71)
        public static int inheritsAPIGuessOnePrimitive(int x)
        {
            FingerNumber a = new FingerNumber(x);

            if (a.Value == 5)
            {
                return 1;
            }
            else if (a.Value == 11)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 75)
        public static int inheritsAPIGuessOneObject(FingerNumber a)
        {
            if (a == null)
            {
                return -1;
            }
            else if (a.Value == 5)
            {
                return 1;
            }
            else if (a.Value == 11)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 84)    
        public static int inheritsAPIGuessTwoPrimitives(int x, int y)
        {
            FingerNumber a = new FingerNumber(x);
            FingerNumber b = new FingerNumber(y);

            FingerNumber sum = a.add(b);

            if (sum.Value == 5)
            {
                return 1;
            }
            else if (sum.Value == 11)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 84)    
        public static int inheritsAPIGuessTwoObjects(FingerNumber a,
                FingerNumber b)
        {
            if (a == null || b == null)
            {
                return -1;
            }

            FingerNumber sum = a.add(b);

            if (sum.Value == 5)
            {
                return 1;
            }
            else if (sum.Value == 11)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        public static int associatesAPIGuessValidDateFormat(String s)
        {
            DateTime parsed = new DateParser().parse(s);
            if (parsed != null)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public static int associatesAPIGuessDate(String s)
        {
            DateTime parsed = new DateParser().parse(s);
            if (parsed != null)
            {
                if (parsed.Ticks == 628214400000000000)
                {
                    // 1991-09-26
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return 0;
            }
        }

        public static int guessValidUUID(String s)
        {
            if (s == null)
            {
                return -1;
            }

            try
            {
                //new Guid(s); // before .NET 4.0
                Guid.Parse(s); // since .NET 4.0
                return 1;
            }
            catch (Exception)
            {
                return 0;
            }
        }

        public static int guessUUID(String s)
        {
            if (s == null)
            {
                return -1;
            }

            try
            {
                Guid uuid = Guid.Parse(s);
                byte[] bytes = uuid.ToByteArray();
                if (bytes[0] == 0x12 && bytes[1] == 0x34 && bytes[2] == 0xAB && bytes[3]
                     == 0xCD)
                {
                    return 1;
                }
                else
                {
                    return -2;
                }
            }
            catch (Exception)
            {
                return 0;
            }
        }

        public static int regexCaseSensitive(String s)
        {
            if (s == null)
            {
                return -1;
            }

            if (Regex.IsMatch(s, "^[0-9a-zA-Z]{6}$"))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public static int regexCaseInsensitive(String s)
        {
            if (s == null)
            {
                return -1;
            }

            if (Regex.IsMatch(s, "[a-z0-9]{6}", RegexOptions.IgnoreCase))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}