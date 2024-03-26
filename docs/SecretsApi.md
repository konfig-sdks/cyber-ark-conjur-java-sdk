# SecretsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSecretValue**](SecretsApi.md#createSecretValue) | **POST** /secrets/{account}/{kind}/{identifier} | Creates a secret value within the specified variable. |
| [**getMultipleValues**](SecretsApi.md#getMultipleValues) | **GET** /secrets | Fetch multiple secrets |
| [**getSecretValue**](SecretsApi.md#getSecretValue) | **GET** /secrets/{account}/{kind}/{identifier} | Fetches the value of a secret from the specified Secret. |


<a name="createSecretValue"></a>
# **createSecretValue**
> createSecretValue(account, kind, identifier).xRequestId(xRequestId).expirations(expirations).body(body).execute();

Creates a secret value within the specified variable.

Creates a secret value within the specified Secret.   Note: Conjur will allow you to add a secret to any resource, but the best practice is to store and retrieve secret data only using Secret resources. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SecretsApi;
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
    String kind = "kind_example"; // Type of resource - in almost all cases this should be `variable`
    String identifier = "identifier_example"; // URL-encoded variable ID
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String expirations = "expirations_example"; // Tells the server to reset the variables expiration date
    try {
      client
              .secrets
              .createSecretValue(account, kind, identifier)
              .xRequestId(xRequestId)
              .expirations(expirations)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling SecretsApi#createSecretValue");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .secrets
              .createSecretValue(account, kind, identifier)
              .xRequestId(xRequestId)
              .expirations(expirations)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling SecretsApi#createSecretValue");
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
| **kind** | **String**| Type of resource - in almost all cases this should be &#x60;variable&#x60; | |
| **identifier** | **String**| URL-encoded variable ID | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **expirations** | **String**| Tells the server to reset the variables expiration date | [optional] |
| **body** | **String**| Secret data | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The secret value was added successfully |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="getMultipleValues"></a>
# **getMultipleValues**
> Object getMultipleValues(variableIds).xRequestId(xRequestId).acceptEncoding(acceptEncoding).execute();

Fetch multiple secrets

Fetches multiple secret values in one invocation. It’s faster to fetch secrets in batches than to fetch them one at a time.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SecretsApi;
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
    String variableIds = "myorg:variable:secret1,myorg:variable:secret1"; // Comma-delimited, URL-encoded resource IDs of the variables.
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "base64"; // Set the encoding of the response object
    try {
      Object result = client
              .secrets
              .getMultipleValues(variableIds)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling SecretsApi#getMultipleValues");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Object> response = client
              .secrets
              .getMultipleValues(variableIds)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling SecretsApi#getMultipleValues");
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
| **variableIds** | **String**| Comma-delimited, URL-encoded resource IDs of the variables. | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Set the encoding of the response object | [optional] [enum: base64] |

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
| **200** | The batch secret values |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | At least one resource was unable to be found |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="getSecretValue"></a>
# **getSecretValue**
> String getSecretValue(account, kind, identifier).xRequestId(xRequestId).version(version).execute();

Fetches the value of a secret from the specified Secret.

Fetches the value of a secret from the specified Secret. The latest version will be retrieved unless the version parameter is specified. The twenty most recent secret versions are retained.  The secret data is returned in the response body.  Note: Conjur will allow you to add a secret to any resource, but the best practice is to store and retrieve secret data only using Secret resources. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SecretsApi;
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
    String kind = "kind_example"; // Type of resource - in almost all cases this should be `variable`
    String identifier = "identifier_example"; // URL-encoded variable ID
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    Integer version = 56; // (**Optional**) Version you want to retrieve (Conjur keeps the last 20 versions of a secret)
    try {
      String result = client
              .secrets
              .getSecretValue(account, kind, identifier)
              .xRequestId(xRequestId)
              .version(version)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling SecretsApi#getSecretValue");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<String> response = client
              .secrets
              .getSecretValue(account, kind, identifier)
              .xRequestId(xRequestId)
              .version(version)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling SecretsApi#getSecretValue");
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
| **kind** | **String**| Type of resource - in almost all cases this should be &#x60;variable&#x60; | |
| **identifier** | **String**| URL-encoded variable ID | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **version** | **Integer**| (**Optional**) Version you want to retrieve (Conjur keeps the last 20 versions of a secret) | [optional] |

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The secret value was added successfully |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

