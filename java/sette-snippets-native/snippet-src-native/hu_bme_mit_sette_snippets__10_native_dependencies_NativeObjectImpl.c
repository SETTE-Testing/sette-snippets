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
#include "hu_bme_mit_sette_snippets__10_native_dependencies_NativeObject.h"

JNIEXPORT void JNICALL Java_hu_bme_mit_sette_snippets__110_1native_dependencies_NativeObject_calculate
		(JNIEnv * env, jobject this, jint a) {
	jfieldID field = (*env)->GetFieldID(env, (*env)->GetObjectClass(env, this), "x", "I");

	jint newValue;
	if (a == 4064256) { // 2016*2016
		newValue = 2016;
	} else {
		newValue = 0;
	}

	(*env)->SetIntField(env, this, field, newValue);
}
