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

package com.microsoft.azure;

/**
* Resource identity.
*/
public class ResourceIdentity {
    private String parentResourcePath;
    
    /**
    * Optional. Gets or sets parent resource path (optional).
    * @return The ParentResourcePath value.
    */
    public String getParentResourcePath() {
        return this.parentResourcePath;
    }
    
    /**
    * Optional. Gets or sets parent resource path (optional).
    * @param parentResourcePathValue The ParentResourcePath value.
    */
    public void setParentResourcePath(final String parentResourcePathValue) {
        this.parentResourcePath = parentResourcePathValue;
    }
    
    private String resourceName;
    
    /**
    * Required. Gets or sets resource name.
    * @return The ResourceName value.
    */
    public String getResourceName() {
        return this.resourceName;
    }
    
    /**
    * Required. Gets or sets resource name.
    * @param resourceNameValue The ResourceName value.
    */
    public void setResourceName(final String resourceNameValue) {
        this.resourceName = resourceNameValue;
    }
    
    private String resourceProviderApiVersion;
    
    /**
    * Required. Gets or sets API version of the resource provider.
    * @return The ResourceProviderApiVersion value.
    */
    public String getResourceProviderApiVersion() {
        return this.resourceProviderApiVersion;
    }
    
    /**
    * Required. Gets or sets API version of the resource provider.
    * @param resourceProviderApiVersionValue The ResourceProviderApiVersion
    * value.
    */
    public void setResourceProviderApiVersion(final String resourceProviderApiVersionValue) {
        this.resourceProviderApiVersion = resourceProviderApiVersionValue;
    }
    
    private String resourceProviderNamespace;
    
    /**
    * Required. Gets or sets namespace of the resource provider.
    * @return The ResourceProviderNamespace value.
    */
    public String getResourceProviderNamespace() {
        return this.resourceProviderNamespace;
    }
    
    /**
    * Required. Gets or sets namespace of the resource provider.
    * @param resourceProviderNamespaceValue The ResourceProviderNamespace value.
    */
    public void setResourceProviderNamespace(final String resourceProviderNamespaceValue) {
        this.resourceProviderNamespace = resourceProviderNamespaceValue;
    }
    
    private String resourceType;
    
    /**
    * Required. Gets or sets resource type.
    * @return The ResourceType value.
    */
    public String getResourceType() {
        return this.resourceType;
    }
    
    /**
    * Required. Gets or sets resource type.
    * @param resourceTypeValue The ResourceType value.
    */
    public void setResourceType(final String resourceTypeValue) {
        this.resourceType = resourceTypeValue;
    }
}
