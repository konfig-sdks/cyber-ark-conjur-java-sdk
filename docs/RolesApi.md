# RolesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteRoleMembership**](RolesApi.md#deleteRoleMembership) | **DELETE** /roles/{account}/{kind}/{identifier} | Deletes an existing role membership |
| [**getRoleInformation**](RolesApi.md#getRoleInformation) | **GET** /roles/{account}/{kind}/{identifier} | Get role information |
| [**updateRoleMembership**](RolesApi.md#updateRoleMembership) | **POST** /roles/{account}/{kind}/{identifier} | Update or modify an existing role membership |


<a name="deleteRoleMembership"></a>
# **deleteRoleMembership**
> deleteRoleMembership(account, kind, identifier, members, member).xRequestId(xRequestId).execute();

Deletes an existing role membership

Deletes an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be removed as a member of the role specified in the endpoint URI. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    
    // Configure HTTP basic authorization: basicAuth
    configuration.username = "YOUR USERNAME";
    configuration.password = "YOUR PASSWORD";
    
    configuration.conjurAuth  = "YOUR API KEY";
    
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "account_example"; // Organization account name
    String kind = "user"; // Type of resource
    String identifier = "admin"; // ID of the role for which to get the information about
    String members = "members_example"; // Returns a list of the Role's members.
    String member = "member_example"; // The identifier of the Role to be added as a member.
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .roles
              .deleteRoleMembership(account, kind, identifier, members, member)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#deleteRoleMembership");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .roles
              .deleteRoleMembership(account, kind, identifier, members, member)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#deleteRoleMembership");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **account** | **String**| Organization account name | |
| **kind** | **String**| Type of resource | |
| **identifier** | **String**| ID of the role for which to get the information about | |
| **members** | **String**| Returns a list of the Role&#39;s members. | |
| **member** | **String**| The identifier of the Role to be added as a member. | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Member was deleted from role successfully |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="getRoleInformation"></a>
# **getRoleInformation**
> Object getRoleInformation(account, kind, identifier).xRequestId(xRequestId).all(all).memberships(memberships).members(members).offset(offset).limit(limit).count(count).search(search).graph(graph).execute();

Get role information

Gets detailed information about a specific role, including the role members.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  ##### Listing members  If &#x60;members&#x60; is provided, you will get the members of a role.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give limit a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is true, returns only the number of items in the list.  ##### Text search  If the search parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weights results so that those with matching id or a matching value of an annotation called name appear first, then those with another matching annotation value, and finally those with a matching kind.  ##### Parameter Priority  If Conjur is given any combination of optional parameters, it responds with ONLY results for the parameter of the highest priority.  1. &#x60;graph&#x60; 2. &#x60;all&#x60; 3. &#x60;memberships&#x60; 4. &#x60;members&#x60; 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    
    // Configure HTTP basic authorization: basicAuth
    configuration.username = "YOUR USERNAME";
    configuration.password = "YOUR PASSWORD";
    
    configuration.conjurAuth  = "YOUR API KEY";
    
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "account_example"; // Organization account name
    String kind = "user"; // Type of resource
    String identifier = "admin"; // ID of the role for which to get the information about
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String all = "all_example"; // Returns an array of Role IDs representing all role memberships, expanded recursively.
    String memberships = "memberships_example"; // Returns all direct role memberships (members not expanded recursively).
    String members = "members_example"; // Returns a list of the Role's members.
    Integer offset = 56; // When listing members, start at this item number.
    Integer limit = 56; // When listing members, return up to this many results.
    Boolean count = true; // When listing members, if `true`, return only the count of members.
    String search = "user"; // When listing members, the results will be narrowed to only those matching the provided string
    String graph = ""; // If included in the query returns a graph view of the role
    try {
      Object result = client
              .roles
              .getRoleInformation(account, kind, identifier)
              .xRequestId(xRequestId)
              .all(all)
              .memberships(memberships)
              .members(members)
              .offset(offset)
              .limit(limit)
              .count(count)
              .search(search)
              .graph(graph)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleInformation");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Object> response = client
              .roles
              .getRoleInformation(account, kind, identifier)
              .xRequestId(xRequestId)
              .all(all)
              .memberships(memberships)
              .members(members)
              .offset(offset)
              .limit(limit)
              .count(count)
              .search(search)
              .graph(graph)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleInformation");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **account** | **String**| Organization account name | |
| **kind** | **String**| Type of resource | |
| **identifier** | **String**| ID of the role for which to get the information about | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **all** | **String**| Returns an array of Role IDs representing all role memberships, expanded recursively. | [optional] |
| **memberships** | **String**| Returns all direct role memberships (members not expanded recursively). | [optional] |
| **members** | **String**| Returns a list of the Role&#39;s members. | [optional] |
| **offset** | **Integer**| When listing members, start at this item number. | [optional] |
| **limit** | **Integer**| When listing members, return up to this many results. | [optional] |
| **count** | **Boolean**| When listing members, if &#x60;true&#x60;, return only the count of members. | [optional] |
| **search** | **String**| When listing members, the results will be narrowed to only those matching the provided string | [optional] |
| **graph** | **String**| If included in the query returns a graph view of the role | [optional] |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response body contains the requested role(s)/member(s) |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="updateRoleMembership"></a>
# **updateRoleMembership**
> updateRoleMembership(account, kind, identifier, members, member).xRequestId(xRequestId).execute();

Update or modify an existing role membership

Updates or modifies an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be added as a member of the role specified in the endpoint URI. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    
    // Configure HTTP basic authorization: basicAuth
    configuration.username = "YOUR USERNAME";
    configuration.password = "YOUR PASSWORD";
    
    configuration.conjurAuth  = "YOUR API KEY";
    
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "account_example"; // Organization account name
    String kind = "user"; // Type of resource
    String identifier = "admin"; // ID of the role for which to get the information about
    String members = "members_example"; // Returns a list of the Role's members.
    String member = "member_example"; // The identifier of the Role to be added as a member.
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .roles
              .updateRoleMembership(account, kind, identifier, members, member)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#updateRoleMembership");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .roles
              .updateRoleMembership(account, kind, identifier, members, member)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#updateRoleMembership");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **account** | **String**| Organization account name | |
| **kind** | **String**| Type of resource | |
| **identifier** | **String**| ID of the role for which to get the information about | |
| **members** | **String**| Returns a list of the Role&#39;s members. | |
| **member** | **String**| The identifier of the Role to be added as a member. | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Member was added to role successfully |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

