/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.resources.models;

/**
* Deployment information.
*/
public class DeploymentExtended {
    private String id;
    
    /**
    * Optional. Gets or sets the ID of the deployment.
    * @return The Id value.
    */
    public String getId() {
        return this.id;
    }
    
    /**
    * Optional. Gets or sets the ID of the deployment.
    * @param idValue The Id value.
    */
    public void setId(final String idValue) {
        this.id = idValue;
    }
    
    private String name;
    
    /**
    * Required. Gets or sets the name of the deployment.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Required. Gets or sets the name of the deployment.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private DeploymentPropertiesExtended properties;
    
    /**
    * Optional. Gets or sets deployment properties.
    * @return The Properties value.
    */
    public DeploymentPropertiesExtended getProperties() {
        return this.properties;
    }
    
    /**
    * Optional. Gets or sets deployment properties.
    * @param propertiesValue The Properties value.
    */
    public void setProperties(final DeploymentPropertiesExtended propertiesValue) {
        this.properties = propertiesValue;
    }
    
    /**
    * Initializes a new instance of the DeploymentExtended class.
    *
    */
    public DeploymentExtended() {
    }
    
    /**
    * Initializes a new instance of the DeploymentExtended class with required
    * arguments.
    *
    * @param name Gets or sets the name of the deployment.
    */
    public DeploymentExtended(String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        this.setName(name);
    }
}
