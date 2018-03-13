/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.bval.jsr.descriptor;

import java.lang.reflect.Constructor;

import javax.validation.metadata.ConstructorDescriptor;

public class ConstructorD<T> extends ExecutableD<Constructor<? extends T>, MetadataReader.ForConstructor<T>, ConstructorD<T>>
    implements ConstructorDescriptor {

    ConstructorD(MetadataReader.ForConstructor<T> reader, BeanD<T> parent) {
        super(reader, parent);
    }

    @Override
    public Class<?> getElementClass() {
        return getParent().getElementClass();
    }

    @Override
    protected String nameOf(Constructor<? extends T> e) {
        return e.getDeclaringClass().getSimpleName();
    }
}