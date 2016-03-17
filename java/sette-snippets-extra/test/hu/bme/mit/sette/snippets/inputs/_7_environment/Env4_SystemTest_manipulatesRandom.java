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
package hu.bme.mit.sette.snippets.inputs._7_environment;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import hu.bme.mit.sette.snippets._7_environment.Env4_System;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Random.class, Env4_System.class })
public class Env4_SystemTest_manipulatesRandom {
    private Random mockedRandom;

    @Before
    public void setUp() throws Exception {
        mockedRandom = PowerMockito.mock(Random.class);
        PowerMockito.whenNew(Random.class).withNoArguments().thenReturn(mockedRandom);
    }

    @Test
    public void test0() {
        PowerMockito.doReturn(0).when(mockedRandom).nextInt();
        assertEquals(0, Env4_System.manipulatesRandom());
    }

    @Test
    public void test1() {
        PowerMockito.doReturn(12345).when(mockedRandom).nextInt();
        assertEquals(1, Env4_System.manipulatesRandom());
    }
}
