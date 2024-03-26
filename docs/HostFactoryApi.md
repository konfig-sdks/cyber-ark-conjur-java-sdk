# HostFactoryApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createHost**](HostFactoryApi.md#createHost) | **POST** /host_factories/hosts | Creates a Host using the Host Factory. |
| [**createHostIdentityTokens**](HostFactoryApi.md#createHostIdentityTokens) | **POST** /host_factory_tokens | Creates one or more host identity tokens. |
| [**revokeToken**](HostFactoryApi.md#revokeToken) | **DELETE** /host_factory_tokens/{token} | Revokes a token, immediately disabling it. |


<a name="createHost"></a>
# **createHost**
> HostFactoryCreateHostResponse createHost(id, hostFactoryCreateHostRequest).xRequestId(xRequestId).annotations(annotations).execute();

Creates a Host using the Host Factory.

Creates a Host using the Host Factory and returns a JSON description of it.  Requires a host factory token, which can be created using the create tokens API. In practice, this token is usually provided automatically as part of Conjur integration with your host provisioning infrastructure.  Note: If the token was created with a CIDR restriction, you must make this API request from a whitelisted address. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.HostFactoryApi;
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
    String id = "id_example"; // Identifier of the host to be created. It will be created within the account of the host factory.
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    Object annotations = null; // Annotations to apply to the new host
    try {
      HostFactoryCreateHostResponse result = client
              .hostFactory
              .createHost(id)
              .xRequestId(xRequestId)
              .annotations(annotations)
              .execute();
      System.out.println(result);
      System.out.println(result.getCreatedAt());
      System.out.println(result.getId());
      System.out.println(result.getOwner());
      System.out.println(result.getPermissions());
      System.out.println(result.getAnnotations());
      System.out.println(result.getApiKey());
    } catch (ApiException e) {
      System.err.println("Exception when calling HostFactoryApi#createHost");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<HostFactoryCreateHostResponse> response = client
              .hostFactory
              .createHost(id)
              .xRequestId(xRequestId)
              .annotations(annotations)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling HostFactoryApi#createHost");
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
| **id** | **String**| Identifier of the host to be created. It will be created within the account of the host factory. | |
| **hostFactoryCreateHostRequest** | [**HostFactoryCreateHostRequest**](HostFactoryCreateHostRequest.md)| Parameters | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **annotations** | [**Object**](Object.md)| Annotations to apply to the new host | [optional] |

### Return type

[**HostFactoryCreateHostResponse**](HostFactoryCreateHostResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The response body contains the newly-created host |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="createHostIdentityTokens"></a>
# **createHostIdentityTokens**
> List&lt;HostFactoryCreateHostIdentityTokensResponseInner&gt; createHostIdentityTokens(expiration, hostFactory, hostFactoryCreateHostIdentityTokensRequest).xRequestId(xRequestId).count(count).cidr(cidr).execute();

Creates one or more host identity tokens.

Creates one or more tokens which can be used to bootstrap host identity. Responds with a JSON document containing the tokens and their restrictions.  If the tokens are created with a CIDR restriction, Conjur will only accept them from the whitelisted IP ranges.  ##### Permissions required # &#x60;execute&#x60; privilege on the Host Factory.\&quot; 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.HostFactoryApi;
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
    String expiration = "expiration_example"; // `ISO 8601 datetime` denoting a requested expiration time.
    String hostFactory = "hostFactory_example"; // Fully qualified host factory ID
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    Integer count = 56; // Number of host tokens to create
    List<String> cidr = Arrays.asList(); // Number of host tokens to create
    try {
      List<HostFactoryCreateHostIdentityTokensResponseInner> result = client
              .hostFactory
              .createHostIdentityTokens(expiration, hostFactory)
              .xRequestId(xRequestId)
              .count(count)
              .cidr(cidr)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HostFactoryApi#createHostIdentityTokens");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<HostFactoryCreateHostIdentityTokensResponseInner>> response = client
              .hostFactory
              .createHostIdentityTokens(expiration, hostFactory)
              .xRequestId(xRequestId)
              .count(count)
              .cidr(cidr)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling HostFactoryApi#createHostIdentityTokens");
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
| **expiration** | **String**| &#x60;ISO 8601 datetime&#x60; denoting a requested expiration time. | |
| **hostFactory** | **String**| Fully qualified host factory ID | |
| **hostFactoryCreateHostIdentityTokensRequest** | [**HostFactoryCreateHostIdentityTokensRequest**](HostFactoryCreateHostIdentityTokensRequest.md)| Parameters | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **count** | **Integer**| Number of host tokens to create | [optional] |
| **cidr** | [**List&lt;String&gt;**](String.md)| Number of host tokens to create | [optional] |

### Return type

[**List&lt;HostFactoryCreateHostIdentityTokensResponseInner&gt;**](HostFactoryCreateHostIdentityTokensResponseInner.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Zero or more tokens were created and delivered in the response body |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |

<a name="revokeToken"></a>
# **revokeToken**
> revokeToken(token).xRequestId(xRequestId).execute();

Revokes a token, immediately disabling it.

Revokes a token, immediately disabling it.  ##### Permissions required  &#x60;update&#x60; privilege on the host factory.\&quot; 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.HostFactoryApi;
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
    String token = "2c0vfj61pmah3efbgpcz2x9vzcy1ycskfkyqy0kgk1fv014880f4"; // The host factory token to revoke
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .hostFactory
              .revokeToken(token)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling HostFactoryApi#revokeToken");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .hostFactory
              .revokeToken(token)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling HostFactoryApi#revokeToken");
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
| **token** | **String**| The host factory token to revoke | |
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
| **204** | Token was successfully revoked |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |

