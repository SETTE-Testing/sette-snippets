/*
 * SETTE - Symbolic Execution based Test Tool Evaluator
 * 
 * SETTE is a tool to help the evaluation and comparison of symbolic execution
 * based test input generator tools.
 * 
 * Budapest University of Technology and Economics (BME)
 * 
 * Authors: Lajos Cseppentő <lajos.cseppento@inf.mit.bme.hu>, Zoltán Micskei
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
package hu.bme.mit.sette.snippets._4_generics.dependencies;

import hu.bme.mit.sette.annotations.SetteDependency;

/**
 * 
 * A generic collection used by the code snippets, whose methods always checks
 * the specified indices. This collection holds exactly 3 elements of the
 * specified type.
 * 
 * @param <T>the type of elements in this collection
 */
@SetteDependency
public class SafeGenericTriplet<T> extends GenericTriplet<T> {
    public SafeGenericTriplet(T item1, T item2, T item3) {
        super(item1, item2, item3);
    }

    @Override
    public T get(int index) {
        if (0 <= index && index < 3) {
            return super.get(index);
        } else {
            return null;
        }
    }

    @Override
    public T set(int index, T newItem) {
        if (0 <= index && index < 3) {
            return super.set(index, newItem);
        } else {
            return null;
        }
    }

}
