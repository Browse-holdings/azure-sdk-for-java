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

package com.microsoft.azure.management.sql;

import com.microsoft.azure.management.sql.models.ServiceObjective;
import com.microsoft.azure.management.sql.models.ServiceObjectiveGetResponse;
import com.microsoft.azure.management.sql.models.ServiceObjectiveListResponse;
import com.microsoft.azure.management.sql.models.ServiceObjectiveProperties;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.CollectionStringBuilder;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.NullNode;

/**
* Represents all the operations for operating on Azure SQL Database Service
* Objectives.   Contains operations to: Retrieve service objectives.
*/
public class ServiceObjectiveOperationsImpl implements ServiceOperations<SqlManagementClientImpl>, ServiceObjectiveOperations {
    /**
    * Initializes a new instance of the ServiceObjectiveOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    ServiceObjectiveOperationsImpl(SqlManagementClientImpl client) {
        this.client = client;
    }
    
    private SqlManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.azure.management.sql.SqlManagementClientImpl.
    * @return The Client value.
    */
    public SqlManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Returns information about an Azure SQL Database Server Service Objectives.
    *
    * @param resourceGroupName Required. The name of the Resource Group to
    * which the server belongs.
    * @param serverName Required. The name of the Server.
    * @param serviceObjectiveName Required. The name of the service objective
    * to retrieve.
    * @return Represents the response to a Get Azure Sql Database Service
    * Objective request.
    */
    @Override
    public Future<ServiceObjectiveGetResponse> getAsync(final String resourceGroupName, final String serverName, final String serviceObjectiveName) {
        return this.getClient().getExecutorService().submit(new Callable<ServiceObjectiveGetResponse>() { 
            @Override
            public ServiceObjectiveGetResponse call() throws Exception {
                return get(resourceGroupName, serverName, serviceObjectiveName);
            }
         });
    }
    
    /**
    * Returns information about an Azure SQL Database Server Service Objectives.
    *
    * @param resourceGroupName Required. The name of the Resource Group to
    * which the server belongs.
    * @param serverName Required. The name of the Server.
    * @param serviceObjectiveName Required. The name of the service objective
    * to retrieve.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return Represents the response to a Get Azure Sql Database Service
    * Objective request.
    */
    @Override
    public ServiceObjectiveGetResponse get(String resourceGroupName, String serverName, String serviceObjectiveName) throws IOException, ServiceException {
        // Validate
        if (resourceGroupName == null) {
            throw new NullPointerException("resourceGroupName");
        }
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (serviceObjectiveName == null) {
            throw new NullPointerException("serviceObjectiveName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("resourceGroupName", resourceGroupName);
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("serviceObjectiveName", serviceObjectiveName);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        url = url + "/subscriptions/";
        if (this.getClient().getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getClient().getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/resourceGroups/";
        url = url + URLEncoder.encode(resourceGroupName, "UTF-8");
        url = url + "/providers/";
        url = url + "Microsoft.Sql";
        url = url + "/servers/";
        url = url + URLEncoder.encode(serverName, "UTF-8");
        url = url + "/serviceObjectives/";
        url = url + URLEncoder.encode(serviceObjectiveName, "UTF-8");
        ArrayList<String> queryParameters = new ArrayList<String>();
        queryParameters.add("api-version=" + "2014-04-01");
        if (queryParameters.size() > 0) {
            url = url + "?" + CollectionStringBuilder.join(queryParameters, "&");
        }
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServiceObjectiveGetResponse result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new ServiceObjectiveGetResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseDoc = null;
                if (responseContent == null == false) {
                    responseDoc = objectMapper.readTree(responseContent);
                }
                
                if (responseDoc != null && responseDoc instanceof NullNode == false) {
                    ServiceObjective serviceObjectiveInstance = new ServiceObjective();
                    result.setServiceObjective(serviceObjectiveInstance);
                    
                    JsonNode nameValue = responseDoc.get("name");
                    if (nameValue != null && nameValue instanceof NullNode == false) {
                        String nameInstance;
                        nameInstance = nameValue.getTextValue();
                        serviceObjectiveInstance.setName(nameInstance);
                    }
                    
                    JsonNode propertiesValue = responseDoc.get("properties");
                    if (propertiesValue != null && propertiesValue instanceof NullNode == false) {
                        ServiceObjectiveProperties propertiesInstance = new ServiceObjectiveProperties();
                        serviceObjectiveInstance.setProperties(propertiesInstance);
                        
                        JsonNode serviceObjectiveNameValue = propertiesValue.get("serviceObjectiveName");
                        if (serviceObjectiveNameValue != null && serviceObjectiveNameValue instanceof NullNode == false) {
                            String serviceObjectiveNameInstance;
                            serviceObjectiveNameInstance = serviceObjectiveNameValue.getTextValue();
                            propertiesInstance.setServiceObjectiveName(serviceObjectiveNameInstance);
                        }
                        
                        JsonNode isDefaultValue = propertiesValue.get("isDefault");
                        if (isDefaultValue != null && isDefaultValue instanceof NullNode == false) {
                            boolean isDefaultInstance;
                            isDefaultInstance = isDefaultValue.getBooleanValue();
                            propertiesInstance.setIsDefault(isDefaultInstance);
                        }
                        
                        JsonNode isSystemValue = propertiesValue.get("isSystem");
                        if (isSystemValue != null && isSystemValue instanceof NullNode == false) {
                            boolean isSystemInstance;
                            isSystemInstance = isSystemValue.getBooleanValue();
                            propertiesInstance.setIsSystem(isSystemInstance);
                        }
                        
                        JsonNode descriptionValue = propertiesValue.get("description");
                        if (descriptionValue != null && descriptionValue instanceof NullNode == false) {
                            String descriptionInstance;
                            descriptionInstance = descriptionValue.getTextValue();
                            propertiesInstance.setDescription(descriptionInstance);
                        }
                        
                        JsonNode enabledValue = propertiesValue.get("enabled");
                        if (enabledValue != null && enabledValue instanceof NullNode == false) {
                            boolean enabledInstance;
                            enabledInstance = enabledValue.getBooleanValue();
                            propertiesInstance.setEnabled(enabledInstance);
                        }
                    }
                    
                    JsonNode idValue = responseDoc.get("id");
                    if (idValue != null && idValue instanceof NullNode == false) {
                        String idInstance;
                        idInstance = idValue.getTextValue();
                        serviceObjectiveInstance.setId(idInstance);
                    }
                    
                    JsonNode typeValue = responseDoc.get("type");
                    if (typeValue != null && typeValue instanceof NullNode == false) {
                        String typeInstance;
                        typeInstance = typeValue.getTextValue();
                        serviceObjectiveInstance.setType(typeInstance);
                    }
                    
                    JsonNode locationValue = responseDoc.get("location");
                    if (locationValue != null && locationValue instanceof NullNode == false) {
                        String locationInstance;
                        locationInstance = locationValue.getTextValue();
                        serviceObjectiveInstance.setLocation(locationInstance);
                    }
                    
                    JsonNode tagsSequenceElement = ((JsonNode) responseDoc.get("tags"));
                    if (tagsSequenceElement != null && tagsSequenceElement instanceof NullNode == false) {
                        Iterator<Map.Entry<String, JsonNode>> itr = tagsSequenceElement.getFields();
                        while (itr.hasNext()) {
                            Map.Entry<String, JsonNode> property = itr.next();
                            String tagsKey = property.getKey();
                            String tagsValue = property.getValue().getTextValue();
                            serviceObjectiveInstance.getTags().put(tagsKey, tagsValue);
                        }
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Returns information about an Azure SQL Database Server Service Objectives.
    *
    * @param resourceGroupName Required. The name of the Resource Group to
    * which the server belongs.
    * @param serverName Required. The name of the Server.
    * @return Represents the response to a Get Azure Sql Database Service
    * Objectives request.
    */
    @Override
    public Future<ServiceObjectiveListResponse> listAsync(final String resourceGroupName, final String serverName) {
        return this.getClient().getExecutorService().submit(new Callable<ServiceObjectiveListResponse>() { 
            @Override
            public ServiceObjectiveListResponse call() throws Exception {
                return list(resourceGroupName, serverName);
            }
         });
    }
    
    /**
    * Returns information about an Azure SQL Database Server Service Objectives.
    *
    * @param resourceGroupName Required. The name of the Resource Group to
    * which the server belongs.
    * @param serverName Required. The name of the Server.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return Represents the response to a Get Azure Sql Database Service
    * Objectives request.
    */
    @Override
    public ServiceObjectiveListResponse list(String resourceGroupName, String serverName) throws IOException, ServiceException {
        // Validate
        if (resourceGroupName == null) {
            throw new NullPointerException("resourceGroupName");
        }
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("resourceGroupName", resourceGroupName);
            tracingParameters.put("serverName", serverName);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        url = url + "/subscriptions/";
        if (this.getClient().getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getClient().getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/resourceGroups/";
        url = url + URLEncoder.encode(resourceGroupName, "UTF-8");
        url = url + "/providers/";
        url = url + "Microsoft.Sql";
        url = url + "/servers/";
        url = url + URLEncoder.encode(serverName, "UTF-8");
        url = url + "/serviceObjectives";
        ArrayList<String> queryParameters = new ArrayList<String>();
        queryParameters.add("api-version=" + "2014-04-01");
        if (queryParameters.size() > 0) {
            url = url + "?" + CollectionStringBuilder.join(queryParameters, "&");
        }
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServiceObjectiveListResponse result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new ServiceObjectiveListResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseDoc = null;
                if (responseContent == null == false) {
                    responseDoc = objectMapper.readTree(responseContent);
                }
                
                if (responseDoc != null && responseDoc instanceof NullNode == false) {
                    JsonNode valueArray = responseDoc.get("value");
                    if (valueArray != null && valueArray instanceof NullNode == false) {
                        for (JsonNode valueValue : ((ArrayNode) valueArray)) {
                            ServiceObjective serviceObjectiveInstance = new ServiceObjective();
                            result.getServiceObjectives().add(serviceObjectiveInstance);
                            
                            JsonNode nameValue = valueValue.get("name");
                            if (nameValue != null && nameValue instanceof NullNode == false) {
                                String nameInstance;
                                nameInstance = nameValue.getTextValue();
                                serviceObjectiveInstance.setName(nameInstance);
                            }
                            
                            JsonNode propertiesValue = valueValue.get("properties");
                            if (propertiesValue != null && propertiesValue instanceof NullNode == false) {
                                ServiceObjectiveProperties propertiesInstance = new ServiceObjectiveProperties();
                                serviceObjectiveInstance.setProperties(propertiesInstance);
                                
                                JsonNode serviceObjectiveNameValue = propertiesValue.get("serviceObjectiveName");
                                if (serviceObjectiveNameValue != null && serviceObjectiveNameValue instanceof NullNode == false) {
                                    String serviceObjectiveNameInstance;
                                    serviceObjectiveNameInstance = serviceObjectiveNameValue.getTextValue();
                                    propertiesInstance.setServiceObjectiveName(serviceObjectiveNameInstance);
                                }
                                
                                JsonNode isDefaultValue = propertiesValue.get("isDefault");
                                if (isDefaultValue != null && isDefaultValue instanceof NullNode == false) {
                                    boolean isDefaultInstance;
                                    isDefaultInstance = isDefaultValue.getBooleanValue();
                                    propertiesInstance.setIsDefault(isDefaultInstance);
                                }
                                
                                JsonNode isSystemValue = propertiesValue.get("isSystem");
                                if (isSystemValue != null && isSystemValue instanceof NullNode == false) {
                                    boolean isSystemInstance;
                                    isSystemInstance = isSystemValue.getBooleanValue();
                                    propertiesInstance.setIsSystem(isSystemInstance);
                                }
                                
                                JsonNode descriptionValue = propertiesValue.get("description");
                                if (descriptionValue != null && descriptionValue instanceof NullNode == false) {
                                    String descriptionInstance;
                                    descriptionInstance = descriptionValue.getTextValue();
                                    propertiesInstance.setDescription(descriptionInstance);
                                }
                                
                                JsonNode enabledValue = propertiesValue.get("enabled");
                                if (enabledValue != null && enabledValue instanceof NullNode == false) {
                                    boolean enabledInstance;
                                    enabledInstance = enabledValue.getBooleanValue();
                                    propertiesInstance.setEnabled(enabledInstance);
                                }
                            }
                            
                            JsonNode idValue = valueValue.get("id");
                            if (idValue != null && idValue instanceof NullNode == false) {
                                String idInstance;
                                idInstance = idValue.getTextValue();
                                serviceObjectiveInstance.setId(idInstance);
                            }
                            
                            JsonNode typeValue = valueValue.get("type");
                            if (typeValue != null && typeValue instanceof NullNode == false) {
                                String typeInstance;
                                typeInstance = typeValue.getTextValue();
                                serviceObjectiveInstance.setType(typeInstance);
                            }
                            
                            JsonNode locationValue = valueValue.get("location");
                            if (locationValue != null && locationValue instanceof NullNode == false) {
                                String locationInstance;
                                locationInstance = locationValue.getTextValue();
                                serviceObjectiveInstance.setLocation(locationInstance);
                            }
                            
                            JsonNode tagsSequenceElement = ((JsonNode) valueValue.get("tags"));
                            if (tagsSequenceElement != null && tagsSequenceElement instanceof NullNode == false) {
                                Iterator<Map.Entry<String, JsonNode>> itr = tagsSequenceElement.getFields();
                                while (itr.hasNext()) {
                                    Map.Entry<String, JsonNode> property = itr.next();
                                    String tagsKey = property.getKey();
                                    String tagsValue = property.getValue().getTextValue();
                                    serviceObjectiveInstance.getTags().put(tagsKey, tagsValue);
                                }
                            }
                        }
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
