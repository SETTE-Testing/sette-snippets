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
using System.Collections;
using System.Collections.Generic;

namespace BME.MIT.SETTE.Library
{
    public static class L4_Collections
    {
        public static bool guessSize(int s)
        {
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);

            if (list.Count == s)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessElements(int a, int b)
        {
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);

            if (list[0] == a && list[1] == b)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessSizeAndElements(int s, int a, int b)
        {
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);

            if (list.Count == s && list[0] == a && list[1] == b)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessIndices(int a, int b)
        {
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);
            list.Add(30);
            list.Add(40);
            list.Add(50);

            if (list[a] == 20 && list[b] == 30)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessElementAndIndex(int a, int i)
        {
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);
            list.Add(30);
            list.Add(40);
            list.Add(50);

            if (list[i] == a)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessVectorWithSize(ArrayList v)
        {
            // no Vector in .NET, use ArrayList
            if (v.Count == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessGenericVectorWithSize(ArrayList v)
        {
            // no Vector in .NET, use ArrayList
            if (v.Count == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessGenericVectorWithElement(ArrayList v)
        {
            // no Vector in .NET, use ArrayList
            int i = 5;
            if (v.Count == 3 && v[0].Equals(i))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessListWithSize(ArrayList l)
        {
            if (l.Count == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessGenericListWithSize(List<int> l)
        {
            if (l.Count == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool guessGenericListWithElement(List<int> l)
        {
            int i = 5;
            if (l.Count == 3 && l[0].Equals(i))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}