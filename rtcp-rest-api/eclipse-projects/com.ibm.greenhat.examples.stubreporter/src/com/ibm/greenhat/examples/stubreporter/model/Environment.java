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

/**
 * Represents an environment in RTCP, contained with a domain, with child stubs.
 */
public class Environment {

    private final String name;
    private final List<Component> components;

    public Environment(final String name) {
        this.name = name;
        components = new ArrayList<Component>();
    }

    public Component addComponent(final Component component) {
        final int indexOf = components.indexOf(component);
        if (indexOf != -1) {
            return components.get(indexOf);
        }
        components.add(component);
        return component;
    }

    public String getName() {
        return name;
    }

    public List<Component> getComponents() {
        return components;
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
        final Environment other = (Environment) obj;
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
