/**
 * Copyright 2014 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.greenhat.examples.stubreporter.model;

import java.util.ArrayList;
import java.util.List;

public class Component {

    private final String name;
    private final List<StubDefinition> stubs;
    private final List<Operation> operations;

    public Component(final String name) {
        this.name = name;
        stubs = new ArrayList<StubDefinition>();
        operations = new ArrayList<Operation>();
    }

    public Operation addOperation(final Operation operation) {
        final int indexOf = operations.indexOf(operation);
        if (indexOf != -1) {
            return operations.get(indexOf);
        }
        operations.add(operation);
        return operation;
    }

    public void addStub(final StubDefinition stubDef) {
        stubs.add(stubDef);
    }

    public String getName() {
        return name;
    }

    public List<StubDefinition> getStubs() {
        return stubs;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Component other = (Component) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
