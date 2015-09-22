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

package hu.bme.mit.sette.snippets.inputs._5_library;

import hu.bme.mit.sette.common.snippets.SnippetInputContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class L4_Collections_Inputs {
    private L4_Collections_Inputs() {
        throw new UnsupportedOperationException("Static class");
    }

    public static SnippetInputContainer guessSize() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByParameters(2);
        inputs.addByParameters(0);

        return inputs;
    }

    public static SnippetInputContainer guessElements() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByParameters(10, 20);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessSizeAndElements() {
        SnippetInputContainer inputs = new SnippetInputContainer(3);

        inputs.addByParameters(2, 10, 20);
        inputs.addByParameters(0, 0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessIndices() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByExpectedAndParameters(IndexOutOfBoundsException.class, -1, 0);
        inputs.addByParameters(1, 2);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    public static SnippetInputContainer guessElementAndIndex() {
        SnippetInputContainer inputs = new SnippetInputContainer(2);

        inputs.addByExpectedAndParameters(IndexOutOfBoundsException.class, -1, 0);
        inputs.addByParameters(0, 10);
        inputs.addByParameters(0, 0);

        return inputs;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static SnippetInputContainer guessVectorWithSize() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByExpectedAndParameters(NullPointerException.class, (Object) null);

        Vector v = new Vector();
        v.add(new Object());
        v.add(new Object());
        v.add(new Object());
        inputs.addByParameters(v);

        inputs.addByParameters(new Vector());

        return inputs;
    }

    public static SnippetInputContainer guessGenericVectorWithSize() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByExpectedAndParameters(NullPointerException.class, (Object) null);

        Vector<Integer> v = new Vector<Integer>();
        v.add(new Integer(0));
        v.add(new Integer(0));
        v.add(new Integer(0));
        inputs.addByParameters(v);

        inputs.addByParameters(new Vector<Integer>());

        return inputs;
    }

    public static SnippetInputContainer guessGenericVectorWithElement() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByExpectedAndParameters(NullPointerException.class, (Object) null);

        Vector<Integer> v = new Vector<Integer>();
        v.add(new Integer(5));
        v.add(new Integer(0));
        v.add(new Integer(0));
        inputs.addByParameters(v);

        inputs.addByParameters(new Vector<Integer>());

        return inputs;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static SnippetInputContainer guessListWithSize() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByExpectedAndParameters(NullPointerException.class, (Object) null);

        List l = new ArrayList();
        l.add(new Object());
        l.add(new Object());
        l.add(new Object());
        inputs.addByParameters(l);

        inputs.addByParameters(new ArrayList());

        return inputs;

    }

    public static SnippetInputContainer guessGenericListWithSize() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByExpectedAndParameters(NullPointerException.class, (Object) null);

        List<Integer> l = new ArrayList<Integer>();
        l.add(new Integer(0));
        l.add(new Integer(0));
        l.add(new Integer(0));
        inputs.addByParameters(l);

        inputs.addByParameters(new ArrayList<Integer>());

        return inputs;
    }

    public static SnippetInputContainer guessGenericListWithElement() {
        SnippetInputContainer inputs = new SnippetInputContainer(1);

        inputs.addByExpectedAndParameters(NullPointerException.class, (Object) null);

        List<Integer> l = new ArrayList<Integer>();
        l.add(new Integer(5));
        l.add(new Integer(0));
        l.add(new Integer(0));
        inputs.addByParameters(l);

        inputs.addByParameters(new ArrayList<Integer>());

        return inputs;
    }
}
