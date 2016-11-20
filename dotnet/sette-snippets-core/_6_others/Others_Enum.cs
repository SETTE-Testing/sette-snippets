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

using BME.MIT.SETTE.Others.Dependencies;

namespace BME.MIT.SETTE.Others
{
    public static class Others_Enum
    {
        //@SetteRequiredStatementCoverage(value = 83)
        public static int enumGuess(State s)
        {
            if (s == State.STARTED)
            {
                return 1;
            }
            else if (s == State.PAUSED)
            {
                return 2;
            }
            else if (s == State.STOPPED)
            {
                return 3;
            }
            else if (s == State.IDLE)
            {
                return 4;
            }
            else
            {
                // impossible
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 80)
        public static int enumGuessString(State s)
        {
            if (s.ToString().Equals("STARTED"))
            {
                return 1;
            }
            else if (s.ToString().Equals("PAUSED"))
            {
                return 2;
            }
            else if (s.ToString().Equals("STOPPED"))
            {
                return 3;
            }
            else if (s.ToString().Equals("IDLE"))
            {
                return 4;
            }
            else
            {
                // impossible
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 80)
        public static int enumGuessOrdinal(State s)
        {

            if ((int)s == 0)
            {
                return 1;
            }
            else if ((int)s == 1)
            {
                return 2;
            }
            else if ((int)s == 2)
            {
                return 3;
            }
            else if ((int)s == 3)
            {
                return 4;
            }
            else
            {
                // impossible
                throw new Exception();
            }
        }

        //@SetteRequiredStatementCoverage(value = 84)
        public static int enumSwitch(State s)
        {
            switch (s)
            {
                case State.STARTED:
                    return 1;

                case State.PAUSED:
                    return 2;

                case State.STOPPED:
                    return 3;

                case State.IDLE:
                    return 4;

                default:
                    // impossible
                    throw new Exception();
            }
        }
    }
}