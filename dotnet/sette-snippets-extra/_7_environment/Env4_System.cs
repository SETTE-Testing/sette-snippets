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

using System;

namespace BME.MIT.SETTE.Environment
{
    public static class Env4_System
    {
        // @SetteRequiredStatementCoverage(value = 100)
        public static int setsProperty()
        {
            // system properties are Java-specific concepts
            // no eqvivalent in .NET
            // see: http://stackoverflow.com/questions/7180450/how-to-set-system-properties-in-c-sharp
            throw new NotImplementedException();
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int setsEnv()
        {
            if ("test".Equals(System.Environment.GetEnvironmentVariable("myEnv")))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int manipulatesClock()
        {
            DateTime d = DateTime.Now;

            // NOTE: DateTime.Ticks not the same as Date.getTime()
            // Ticks:  number of 100-nanosecond intervals that have elapsed since 12:00:00 midnight, January 1, 0001
            // Date.getTime(): the number of milliseconds since January 1, 1970, 00:00:00 GMT
            if (d.Ticks / TimeSpan.TicksPerMillisecond == 946684800000L)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // @SetteRequiredStatementCoverage(value = 100)
        public static int manipulatesRandom()
        {
            Random r = new Random();

            if (r.Next() == 12345)
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