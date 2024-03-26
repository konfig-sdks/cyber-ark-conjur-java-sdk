# ResourcesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**list**](ResourcesApi.md#list) | **GET** /resources | Lists resources within an organization account. |
| [**listResources**](ResourcesApi.md#listResources) | **GET** /resources/{account} | Lists resources within an organization account. |
| [**listResourcesForKind**](ResourcesApi.md#listResourcesForKind) | **GET** /resources/{account}/{kind} | Lists resources of the same kind within an organization account. |
| [**showResourceDetails**](ResourcesApi.md#showResourceDetails) | **GET** /resources/{account}/{kind}/{identifier} | Shows a description of a single resource. |


<a name="list"></a>
# **list**
> List&lt;Object&gt; list().xRequestId(xRequestId).account(account).kind(kind).search(search).offset(offset).limit(limit).count(count).role(role).actingAs(actingAs).execute();

Lists resources within an organization account.

Lists resources within an organization account.  In the absence of an &#x60;account&#x60; query parameter, shows results for the account of the authorization token user.  If an &#x60;account&#x60; query parameter is given, shows results for the specified account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;.\&quot; 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ResourcesApi;
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
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String account = "myorg"; // Organization account name
    String kind = "user"; // Type of resource
    String search = "password"; // Filter resources based on this value by name
    Integer offset = 56; // When listing resources, start at this item number.
    Integer limit = 56; // When listing resources, return up to this many results.
    Boolean count = true; // When listing resources, if `true`, return only the count of the results.
    String role = "myorg:host:host1"; // Retrieves the resources list for a different role if the authenticated role has access
    String actingAs = "myorg:host:host1"; // Retrieves the resources list for a different role if the authenticated role has access
    try {
      List<Object> result = client
              .resources
              .list()
              .xRequestId(xRequestId)
              .account(account)
              .kind(kind)
              .search(search)
              .offset(offset)
              .limit(limit)
              .count(count)
              .role(role)
              .actingAs(actingAs)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#list");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Object>> response = client
              .resources
              .list()
              .xRequestId(xRequestId)
              .account(account)
              .kind(kind)
              .search(search)
              .offset(offset)
              .limit(limit)
              .count(count)
              .role(role)
              .actingAs(actingAs)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#list");
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
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **account** | **String**| Organization account name | [optional] |
| **kind** | **String**| Type of resource | [optional] |
| **search** | **String**| Filter resources based on this value by name | [optional] |
| **offset** | **Integer**| When listing resources, start at this item number. | [optional] |
| **limit** | **Integer**| When listing resources, return up to this many results. | [optional] |
| **count** | **Boolean**| When listing resources, if &#x60;true&#x60;, return only the count of the results. | [optional] |
| **role** | **String**| Retrieves the resources list for a different role if the authenticated role has access | [optional] |
| **actingAs** | **String**| Retrieves the resources list for a different role if the authenticated role has access | [optional] |

### Return type

**List&lt;Object&gt;**

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response body contains a list of resources |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="listResources"></a>
# **listResources**
> listResources(account).xRequestId(xRequestId).kind(kind).search(search).offset(offset).limit(limit).count(count).role(role).actingAs(actingAs).execute();

Lists resources within an organization account.

Lists resources within an organization account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ResourcesApi;
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
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String kind = "user"; // Type of resource
    ERRORUNKNOWN search = new ERRORUNKNOWN(); // Filter resources based on this value by name
    Integer offset = 56; // When listing resources, start at this item number.
    Integer limit = 56; // When listing resources, return up to this many results.
    Boolean count = true; // When listing resources, if `true`, return only the count of the results.
    String role = "myorg:host:host1"; // Retrieves the resources list for a different role if the authenticated role has access
    String actingAs = "myorg:host:host1"; // Retrieves the resources list for a different role if the authenticated role has access
    try {
      client
              .resources
              .listResources(account)
              .xRequestId(xRequestId)
              .kind(kind)
              .search(search)
              .offset(offset)
              .limit(limit)
              .count(count)
              .role(role)
              .actingAs(actingAs)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#listResources");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .resources
              .listResources(account)
              .xRequestId(xRequestId)
              .kind(kind)
              .search(search)
              .offset(offset)
              .limit(limit)
              .count(count)
              .role(role)
              .actingAs(actingAs)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#listResources");
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
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **kind** | **String**| Type of resource | [optional] |
| **search** | [**ERRORUNKNOWN**](.md)| Filter resources based on this value by name | [optional] |
| **offset** | **Integer**| When listing resources, start at this item number. | [optional] |
| **limit** | **Integer**| When listing resources, return up to this many results. | [optional] |
| **count** | **Boolean**| When listing resources, if &#x60;true&#x60;, return only the count of the results. | [optional] |
| **role** | **String**| Retrieves the resources list for a different role if the authenticated role has access | [optional] |
| **actingAs** | **String**| Retrieves the resources list for a different role if the authenticated role has access | [optional] |

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
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="listResourcesForKind"></a>
# **listResourcesForKind**
> listResourcesForKind(account, kind).xRequestId(xRequestId).search(search).offset(offset).limit(limit).count(count).role(role).actingAs(actingAs).execute();

Lists resources of the same kind within an organization account.

Lists resources of the same kind within an organization account.  Kinds of resources include: policy, user, host, group, layer, or variable  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ResourcesApi;
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
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    ERRORUNKNOWN search = new ERRORUNKNOWN(); // Filter resources based on this value by name
    Integer offset = 56; // When listing resources, start at this item number.
    Integer limit = 56; // When listing resources, return up to this many results.
    Boolean count = true; // When listing resources, if `true`, return only the count of the results.
    String role = "myorg:host:host1"; // Retrieves the resources list for a different role if the authenticated role has access
    String actingAs = "myorg:host:host1"; // Retrieves the resources list for a different role if the authenticated role has access
    try {
      client
              .resources
              .listResourcesForKind(account, kind)
              .xRequestId(xRequestId)
              .search(search)
              .offset(offset)
              .limit(limit)
              .count(count)
              .role(role)
              .actingAs(actingAs)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#listResourcesForKind");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .resources
              .listResourcesForKind(account, kind)
              .xRequestId(xRequestId)
              .search(search)
              .offset(offset)
              .limit(limit)
              .count(count)
              .role(role)
              .actingAs(actingAs)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#listResourcesForKind");
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
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **search** | [**ERRORUNKNOWN**](.md)| Filter resources based on this value by name | [optional] |
| **offset** | **Integer**| When listing resources, start at this item number. | [optional] |
| **limit** | **Integer**| When listing resources, return up to this many results. | [optional] |
| **count** | **Boolean**| When listing resources, if &#x60;true&#x60;, return only the count of the results. | [optional] |
| **role** | **String**| Retrieves the resources list for a different role if the authenticated role has access | [optional] |
| **actingAs** | **String**| Retrieves the resources list for a different role if the authenticated role has access | [optional] |

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
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="showResourceDetails"></a>
# **showResourceDetails**
> ResourcesShowResourceDetailsResponse showResourceDetails(account, kind, identifier).xRequestId(xRequestId).permittedRoles(permittedRoles).privilege(privilege).check(check).role(role).execute();

Shows a description of a single resource.

Details about a single resource.  If &#x60;permitted_roles&#x60; and &#x60;privilege&#x60; are given, Conjur lists the roles with the specified privilege on the resource.  If &#x60;check&#x60;, &#x60;privilege&#x60; and &#x60;role&#x60; are given, Conjur checks if the specified role has the privilege on the resource.  If &#x60;permitted_roles&#x60; and &#x60;check&#x60; are both given, Conjur responds to the &#x60;check&#x60; call ONLY.  ##### Permissions Required 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ResourcesApi;
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
    String identifier = "conjur/authn-iam/test"; // ID of the resource for which to get the information about
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    Boolean permittedRoles = true; // Lists the roles which have the named privilege on a resource.
    String privilege = "execute"; // Level of privilege to filter on. Can only be used in combination with `permitted_roles` or `check` parameter.
    Boolean check = true; // Check whether a role has a privilege on a resource.
    String role = "myorg:host:host1"; // Role to check privilege on. Can only be used in combination with `check` parameter.
    try {
      ResourcesShowResourceDetailsResponse result = client
              .resources
              .showResourceDetails(account, kind, identifier)
              .xRequestId(xRequestId)
              .permittedRoles(permittedRoles)
              .privilege(privilege)
              .check(check)
              .role(role)
              .execute();
      System.out.println(result);
      System.out.println(result.getCreatedAt());
      System.out.println(result.getId());
      System.out.println(result.getOwner());
      System.out.println(result.getPermissions());
      System.out.println(result.getPolicy());
      System.out.println(result.getAnnotations());
      System.out.println(result.getSecrets());
      System.out.println(result.getRestrictedTo());
      System.out.println(result.getPolicyVersions());
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#showResourceDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ResourcesShowResourceDetailsResponse> response = client
              .resources
              .showResourceDetails(account, kind, identifier)
              .xRequestId(xRequestId)
              .permittedRoles(permittedRoles)
              .privilege(privilege)
              .check(check)
              .role(role)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#showResourceDetails");
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
| **identifier** | **String**| ID of the resource for which to get the information about | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **permittedRoles** | **Boolean**| Lists the roles which have the named privilege on a resource. | [optional] |
| **privilege** | **String**| Level of privilege to filter on. Can only be used in combination with &#x60;permitted_roles&#x60; or &#x60;check&#x60; parameter. | [optional] |
| **check** | **Boolean**| Check whether a role has a privilege on a resource. | [optional] |
| **role** | **String**| Role to check privilege on. Can only be used in combination with &#x60;check&#x60; parameter. | [optional] |

### Return type

[**ResourcesShowResourceDetailsResponse**](ResourcesShowResourceDetailsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response body contains the list of role memberships or permitted roles |  -  |
| **204** | Permissions check was successful |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

