# StatusApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**authenticatorDetails**](StatusApi.md#authenticatorDetails) | **GET** /authenticators | Details about which authenticators are on the Conjur Server |
| [**checkAuthenticatorConfiguration**](StatusApi.md#checkAuthenticatorConfiguration) | **GET** /{authenticator}/{service_id}/{account}/status | Details whether an authentication service has been configured properly |
| [**checkAuthenticatorStatus**](StatusApi.md#checkAuthenticatorStatus) | **GET** /authn-gcp/{account}/status | Details whether an authentication service has been configured properly |
| [**checkConjurHealth**](StatusApi.md#checkConjurHealth) | **GET** /health | Health info about conjur |
| [**checkRemoteHealth**](StatusApi.md#checkRemoteHealth) | **GET** /remote_health/{remote} | Health info about a given Conjur Enterprise server |
| [**conjurServerInfo**](StatusApi.md#conjurServerInfo) | **GET** /info | Basic information about the Conjur Enterprise server |
| [**getClientInfo**](StatusApi.md#getClientInfo) | **GET** /whoami | Provides information about the client making an API request. |


<a name="authenticatorDetails"></a>
# **authenticatorDetails**
> StatusAuthenticatorDetailsResponse authenticatorDetails().xRequestId(xRequestId).execute();

Details about which authenticators are on the Conjur Server

Response contains three members: installed, configured, and enabled.  installed: The authenticator is implemented in Conjur and is available for configuration configured: The authenticator has a webservice in the DB that was loaded by policy enabled: The authenticator is enabled (in the DB or in the ENV) and is ready for authentication 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    try {
      StatusAuthenticatorDetailsResponse result = client
              .status
              .authenticatorDetails()
              .xRequestId(xRequestId)
              .execute();
      System.out.println(result);
      System.out.println(result.getInstalled());
      System.out.println(result.getConfigured());
      System.out.println(result.getEnabled());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#authenticatorDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<StatusAuthenticatorDetailsResponse> response = client
              .status
              .authenticatorDetails()
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#authenticatorDetails");
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

### Return type

[**StatusAuthenticatorDetailsResponse**](StatusAuthenticatorDetailsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Details about authenticators for this Conjur server |  -  |

<a name="checkAuthenticatorConfiguration"></a>
# **checkAuthenticatorConfiguration**
> checkAuthenticatorConfiguration(authenticator, serviceId, account).xRequestId(xRequestId).execute();

Details whether an authentication service has been configured properly

Once the status webservice has been properly configured and the relevant user groups have been given permissions to access the status webservice, the users in those groups can check the status of the authenticator.  Supported Authenticators:   - Azure   - OIDC  Not Supported:   - AWS IAM   - Kubernetes   - LDAP  See [Conjur Documentation](https://docs.conjur.org/Latest/en/Content/Integrations/Authn-status.htm) for details on setting up the authenticator status webservice. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    String authenticator = "authn-oidc"; // The type of authenticator
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "dev"; // The organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .status
              .checkAuthenticatorConfiguration(authenticator, serviceId, account)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkAuthenticatorConfiguration");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .status
              .checkAuthenticatorConfiguration(authenticator, serviceId, account)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkAuthenticatorConfiguration");
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
| **authenticator** | **String**| The type of authenticator | |
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| The organization account name | |
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
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The service was not found |  -  |
| **500** |  |  -  |
| **501** |  |  -  |

<a name="checkAuthenticatorStatus"></a>
# **checkAuthenticatorStatus**
> StatusCheckAuthenticatorConfigurationResponse checkAuthenticatorStatus(account).xRequestId(xRequestId).execute();

Details whether an authentication service has been configured properly

Once the status webservice has been properly configured and the relevant user groups have been given permissions to access the status webservice, the users in those groups can check the status of the authenticator.  This operation only supports the GCP authenticator  See [Conjur Documentation](https://docs.conjur.org/Latest/en/Content/Integrations/Authn-status.htm) for details on setting up the authenticator status webservice. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    String account = "dev"; // The organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      StatusCheckAuthenticatorConfigurationResponse result = client
              .status
              .checkAuthenticatorStatus(account)
              .xRequestId(xRequestId)
              .execute();
      System.out.println(result);
      System.out.println(result.getStatus());
      System.out.println(result.getError());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkAuthenticatorStatus");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<StatusCheckAuthenticatorConfigurationResponse> response = client
              .status
              .checkAuthenticatorStatus(account)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkAuthenticatorStatus");
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
| **account** | **String**| The organization account name | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

[**StatusCheckAuthenticatorConfigurationResponse**](StatusCheckAuthenticatorConfigurationResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **403** | The authenticated user lacks the necessary privileges |  -  |
| **404** | The service was not found |  -  |
| **500** |  |  -  |
| **501** |  |  -  |

<a name="checkConjurHealth"></a>
# **checkConjurHealth**
> Object checkConjurHealth().execute();

Health info about conjur

You can request health checks against any cluster node using the Conjur API. These routes do not require authentication.  The health check attempts an internal HTTP or TCP connection to each Conjur Enterprise service. It also attempts a simple transaction against all internal databases. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    try {
      Object result = client
              .status
              .checkConjurHealth()
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkConjurHealth");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Object> response = client
              .status
              .checkConjurHealth()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkConjurHealth");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters
This endpoint does not need any parameter.

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
| **200** | The tests were successful |  -  |
| **502** | The tests failed |  -  |

<a name="checkRemoteHealth"></a>
# **checkRemoteHealth**
> Object checkRemoteHealth(remote).execute();

Health info about a given Conjur Enterprise server

Use the remote_health route to check the health of any Conjur Enterprise Server from any other Conjur Enterprise Server. With this route, you can check master health relative to a follower, or follower health relative to a standby, and so on. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    String remote = "conjur.myorg.com"; // The hostname of the remote to check
    try {
      Object result = client
              .status
              .checkRemoteHealth(remote)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkRemoteHealth");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Object> response = client
              .status
              .checkRemoteHealth(remote)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#checkRemoteHealth");
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
| **remote** | **String**| The hostname of the remote to check | |

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
| **200** | The tests were successful |  -  |
| **502** | The tests failed |  -  |

<a name="conjurServerInfo"></a>
# **conjurServerInfo**
> StatusConjurServerInfoResponse conjurServerInfo().execute();

Basic information about the Conjur Enterprise server

Information about the Conjur Enterprise node which was queried against.  Includes authenticator info, release/version info, configuration details, internal services, and role information. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    try {
      StatusConjurServerInfoResponse result = client
              .status
              .conjurServerInfo()
              .execute();
      System.out.println(result);
      System.out.println(result.getVersion());
      System.out.println(result.getAuthenticators());
      System.out.println(result.getConfiguration());
      System.out.println(result.getRole());
      System.out.println(result.getContainer());
      System.out.println(result.getRelease());
      System.out.println(result.getServices());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#conjurServerInfo");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<StatusConjurServerInfoResponse> response = client
              .status
              .conjurServerInfo()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#conjurServerInfo");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StatusConjurServerInfoResponse**](StatusConjurServerInfoResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | info |  -  |

<a name="getClientInfo"></a>
# **getClientInfo**
> StatusGetClientInfoResponse getClientInfo().xRequestId(xRequestId).execute();

Provides information about the client making an API request.

WhoAmI provides information about the client making an API request. It can be used to help troubleshoot configuration by verifying authentication and the client IP address for audit and network access restrictions. For more information, see Host Attributes. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.StatusApi;
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
    try {
      StatusGetClientInfoResponse result = client
              .status
              .getClientInfo()
              .xRequestId(xRequestId)
              .execute();
      System.out.println(result);
      System.out.println(result.getClientIp());
      System.out.println(result.getUserAgent());
      System.out.println(result.getAccount());
      System.out.println(result.getUsername());
      System.out.println(result.getTokenIssuedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#getClientInfo");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<StatusGetClientInfoResponse> response = client
              .status
              .getClientInfo()
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling StatusApi#getClientInfo");
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

### Return type

[**StatusGetClientInfoResponse**](StatusGetClientInfoResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Details about the client making the request |  -  |
| **401** | Authentication information is missing or invalid |  -  |

