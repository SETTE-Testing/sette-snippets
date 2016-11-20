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

namespace BME.MIT.SETTE.Library.Dependencies
{
    /**
     * Class realising a date parser based on regular expressions.
     */
    //@SetteDependency
    public sealed class DateParser
    {
        public DateParser()
        {
        }

        public DateTime parse(String s)
        {
            if (s == null)
            {
                throw new ArgumentException();
            }

            string pattern = "(\\d{4})-(\\d{2})-(\\d{2})";

            Regex r = new Regex(pattern);
            MatchCollection matches = r.Matches(s);

            if (matches.Count == 1)
            {
                GroupCollection g = matches[0].Groups;

                DateTime d = new DateTime(int.Parse(g[0].Value), int.Parse(g[1].Value), int.Parse(g[2].Value));

                return d;
            }
            else
            {
                return DateTime.MinValue;
            }
        }
    }
}