# PoliciesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addDataToExistingPolicy**](PoliciesApi.md#addDataToExistingPolicy) | **POST** /policies/{account}/policy/{identifier} | Adds data to the existing Conjur policy. |
| [**modifyPolicy**](PoliciesApi.md#modifyPolicy) | **PATCH** /policies/{account}/policy/{identifier} | Modifies an existing Conjur policy. |
| [**putPolicyDocument**](PoliciesApi.md#putPolicyDocument) | **PUT** /policies/{account}/policy/{identifier} | Loads or replaces a Conjur policy document. |


<a name="addDataToExistingPolicy"></a>
# **addDataToExistingPolicy**
> addDataToExistingPolicy(account, identifier, body).xRequestId(xRequestId).execute();

Adds data to the existing Conjur policy.

Adds data to the existing Conjur policy. Deletions are not allowed. Any policy objects that exist on the server but are omitted from the policy file will not be deleted and any explicit deletions in the policy file will result in an error.  ##### Permissions required  &#x60;create&#x60; privilege on the policy.\&quot; 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PoliciesApi;
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
    String identifier = "root"; // ID of the policy to update
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .policies
              .addDataToExistingPolicy(account, identifier)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling PoliciesApi#addDataToExistingPolicy");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .policies
              .addDataToExistingPolicy(account, identifier)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling PoliciesApi#addDataToExistingPolicy");
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
| **identifier** | **String**| ID of the policy to update | |
| **body** | **Object**| Policy | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: text/yaml, text/x-yaml, application/x-yaml, text/plain
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **409** | Similar operation already in progress, retry after a delay |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="modifyPolicy"></a>
# **modifyPolicy**
> modifyPolicy(account, identifier, body).xRequestId(xRequestId).execute();

Modifies an existing Conjur policy.

Modifies an existing Conjur policy. Data may be explicitly deleted using the &#x60;!delete&#x60;, &#x60;!revoke&#x60;, and &#x60;!deny&#x60; statements. Unlike &#x60;replace&#x60; mode, no data is ever implicitly deleted.  ##### Permissions required 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PoliciesApi;
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
    String identifier = "root"; // ID of the policy to update
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .policies
              .modifyPolicy(account, identifier)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling PoliciesApi#modifyPolicy");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .policies
              .modifyPolicy(account, identifier)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling PoliciesApi#modifyPolicy");
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
| **identifier** | **String**| ID of the policy to update | |
| **body** | **Object**| Policy | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: text/yaml, text/x-yaml, application/x-yaml, text/plain
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **409** | Similar operation already in progress, retry after a delay |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="putPolicyDocument"></a>
# **putPolicyDocument**
> PoliciesModifyPolicyResponse putPolicyDocument(account, identifier, body).xRequestId(xRequestId).execute();

Loads or replaces a Conjur policy document.

Loads or replaces a Conjur policy document.  **Any policy data which already exists on the server but is not explicitly specified in the new policy file will be deleted!**. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PoliciesApi;
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
    String identifier = "root"; // ID of the policy to load (root if no root policy has been loaded yet)
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      PoliciesModifyPolicyResponse result = client
              .policies
              .putPolicyDocument(account, identifier)
              .xRequestId(xRequestId)
              .execute();
      System.out.println(result);
      System.out.println(result.getVersion());
      System.out.println(result.getCreatedRoles());
    } catch (ApiException e) {
      System.err.println("Exception when calling PoliciesApi#putPolicyDocument");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PoliciesModifyPolicyResponse> response = client
              .policies
              .putPolicyDocument(account, identifier)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PoliciesApi#putPolicyDocument");
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
| **identifier** | **String**| ID of the policy to load (root if no root policy has been loaded yet) | |
| **body** | **String**| Policy | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

[**PoliciesModifyPolicyResponse**](PoliciesModifyPolicyResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: text/yaml, text/x-yaml, application/x-yaml, text/plain
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Decsribes new data created by a successful policy load |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **409** | Similar operation already in progress, retry after a delay |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

