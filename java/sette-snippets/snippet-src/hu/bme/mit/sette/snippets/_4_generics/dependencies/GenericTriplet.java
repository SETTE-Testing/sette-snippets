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

package hu.bme.mit.sette.snippets._4_generics.dependencies;

import hu.bme.mit.sette.common.annotations.SetteDependency;

/**
 * A generic collection used by the code snippets. This collection holds exactly 3 elements of the
 * specified type.
 *
 * @param <T>the
 *            type of elements in this collection
 */
@SetteDependency
public class GenericTriplet<T> {
    private final Object[] array = new Object[3];

    public GenericTriplet(T item1, T item2, T item3) {
        this.array[0] = item1;
        this.array[1] = item2;
        this.array[2] = item3;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        // possible bad indexing!
        return (T) this.array[index];
    }

    public T set(int index, T newItem) {
        // possible bad indexing!
        T old = this.get(index);
        this.array[index] = newItem;
        return old;
    }

    public int size() {
        return this.array.length;
    }
}
