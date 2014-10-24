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

namespace BME.MIT.SETTE.Generics.Dependencies
{
    /// <summary>
    /// A generic collection used by the code snippets. 
    /// This collection holds exactly 3 elements of the specified type.
    /// </summary>
    /// <typeparam name="T">the type of elements in this collection</typeparam>
    //@SetteDependency
    public class GenericTriplet<T>
    {
        private object[] array = new object[3];

        public GenericTriplet(T item1, T item2, T item3)
        {
            this.array[0] = item1;
            this.array[1] = item2;
            this.array[2] = item3;
        }

        public virtual T get(int index)
        {
            // possible bad indexing!
            return (T)this.array[index];
        }

        public virtual T set(int index, T newItem)
        {
            // possible bad indexing!
            T old = this.get(index);
            this.array[index] = newItem;
            return old;
        }

        public int size()
        {
            return this.array.Length;
        }
    }
}