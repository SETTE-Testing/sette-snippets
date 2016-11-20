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

namespace BME.MIT.SETTE.Library
{
    public static class L2_Strings
    {
        //@SetteRequiredStatementCoverage(value = 80)
        public static int equality(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s.Equals("test"))
            {
                return 1;
            }
            else if (s.Equals("TeStInG"))
            {
                return 2;
            }
            else if (s.Equals("test") && s.Equals("TeStInG"))
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 80)
        public static int equalityIgnoreCase(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (String.Compare(s, "test", true) == 0)
            {
                return 1;
            }
            else if (String.Compare(s, "TeStInG", true) == 0)
            {
                return 2;
            }
            else if (String.Compare(s, "test", true) == 0
                  && String.Compare(s, "TeStInG", true) == 0)
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        public static String add(String a, String b)
        {
            if (a == null && b == null)
            {
                return "both null";
            }
            else if (a == null)
            {
                return "a null";
            }
            else if (b == null)
            {
                return "b null";
            }
            else
            {
                return a + b;
            }
        }

        //@SetteRequiredStatementCoverage(value = 83)
        public static int addWithCondition(String a, String b)
        {
            if (a == null && b == null)
            {
                return 0;
            }
            else if (a == null)
            {
                return -1;
            }
            else if (b == null)
            {
                return -2;
            }
            else if ((a + b).Equals("ab") && a.Equals("a"))
            {
                return 2;
            }
            else if ((a + b).Equals("ab"))
            {
                return 1;
            }
            else if ((a + b).Equals("ab") && a.Equals("c"))
            {
                // impossible
                throw new Exception();
            }
            else
            {
                return -3;
            }
        }

        //@SetteRequiredStatementCoverage(value = 75)
        public static int length(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s.Length == 10)
            {
                return 1;
            }
            else if (s.Length == 5 && s.Length == 10)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 75)
        public static int charAt(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s[10] == 'X')
            {
                return 1;
            }
            else if (s[10] == 'X' && s[10] == 'Y')
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 75)
        public static int regionEquality(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (String.Compare(s, 10, "part", 0, 4, false) == 0)
            {
                return 1;
            }
            else if (String.Compare(s, 10, "part", 0, 4, false) == 0
                  && String.Compare(s, 10, "test", 0, 4, false) == 0)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 80)
        public static int compareTo(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s.CompareTo("abcdd") > 0 && s.CompareTo("abcdf") < 0)
            {
                return 1;
            }
            else if (s.CompareTo("efghh") > 0 && s.CompareTo("efghj") < 0)
            {
                return 2;
            }
            else if (s.CompareTo("bbb") > 0 && s.CompareTo("aaa") < 0)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 80)
        public static int compareToIgnoreCase(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (String.Compare(s, "abcdd", true) > 0
                  && String.Compare(s, "abcdf", true) < 0)
            {
                return 1;
            }
            else if (String.Compare(s, "EfGhH", true) > 0
                  && String.Compare(s, "eFgHj", true) < 0)
            {
                return 2;
            }
            else if (String.Compare(s, "bbb", true) > 0
                  && String.Compare(s, "aaa", true) < 0)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        public static int startsEnds(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s.StartsWith("test"))
            {
                if (s.EndsWith("error"))
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

        //@SetteRequiredStatementCoverage(value = 75)
        public static int indexOf(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s.IndexOf("test") == 0 && s.IndexOf("test", 1) == 10
                  && s.LastIndexOf("test") == 20)
            {
                return 1;
            }
            else if (s.IndexOf("test") == 0 && s.IndexOf("test", 1) == 1)
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }

        //@SetteRequiredStatementCoverage(value = 75)
        public static int substring(String s)
        {
            if (s == null)
            {
                return -1;
            }
            else if (s.Substring(0, 2).Equals("ab")
                  && (s.Substring(6, 8).Equals("xy")))
            {
                return 1;
            }
            else if (s.Substring(0, 2).Equals("ab")
                  && s.Substring(1, 3).Equals("xy"))
            {
                // impossible branch
                throw new Exception();
            }
            else
            {
                return 0;
            }
        }
    }
}