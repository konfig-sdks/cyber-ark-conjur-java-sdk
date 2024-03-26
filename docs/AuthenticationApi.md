# AuthenticationApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**authenticateWithId**](AuthenticationApi.md#authenticateWithId) | **POST** /authn-jwt/{service_id}/{account}/{id}/authenticate | Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. Covers the case of use of optional URL parameter \&quot;ID\&quot;  |
| [**azureAuthenticate**](AuthenticationApi.md#azureAuthenticate) | **POST** /authn-azure/{service_id}/{account}/{login}/authenticate | Gets a short-lived access token for applications running in Azure. |
| [**changeUserPassword**](AuthenticationApi.md#changeUserPassword) | **PUT** /authn/{account}/password | Changes a user’s password. |
| [**exchangeLdapCredentialsForApiKey**](AuthenticationApi.md#exchangeLdapCredentialsForApiKey) | **GET** /authn-ldap/{service_id}/{account}/login | Gets the Conjur API key of a user given the LDAP username and password via HTTP Basic Authentication.  |
| [**gcpAuthnAuthenticate**](AuthenticationApi.md#gcpAuthnAuthenticate) | **POST** /authn-gcp/{account}/authenticate | Gets a short-lived access token for applications running in Google Cloud Platform.  |
| [**getShortLivedToken**](AuthenticationApi.md#getShortLivedToken) | **POST** /authn-iam/{service_id}/{account}/{login}/authenticate | Get a short-lived access token for applications running in AWS. |
| [**getUserApiKey**](AuthenticationApi.md#getUserApiKey) | **GET** /authn/{account}/login | Gets the API key of a user given the username and password via HTTP Basic Authentication.  |
| [**jwtAuthenticate**](AuthenticationApi.md#jwtAuthenticate) | **POST** /authn-jwt/{service_id}/{account}/authenticate | Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API.  |
| [**kubernetesAuthnAuthenticate**](AuthenticationApi.md#kubernetesAuthnAuthenticate) | **POST** /authn-k8s/{service_id}/{account}/{login}/authenticate | Gets a short-lived access token for applications running in Kubernetes. |
| [**ldapAuthenticate**](AuthenticationApi.md#ldapAuthenticate) | **POST** /authn-ldap/{service_id}/{account}/{login}/authenticate | Gets a short-lived access token for users and hosts using their LDAP identity to access the Conjur API.  |
| [**obtainAccessToken**](AuthenticationApi.md#obtainAccessToken) | **POST** /authn/{account}/{login}/authenticate | Gets a short-lived access token, which is required in the header of most subsequent API requests.  |
| [**oidcAuthenticate**](AuthenticationApi.md#oidcAuthenticate) | **POST** /authn-oidc/{service_id}/{account}/authenticate | Gets a short-lived access token for applications using OpenID Connect (OIDC) to access the Conjur API.  |
| [**rotateApiKey**](AuthenticationApi.md#rotateApiKey) | **PUT** /authn/{account}/api_key | Rotates a role&#39;s API key. |
| [**sendCsrForClientCertInjection**](AuthenticationApi.md#sendCsrForClientCertInjection) | **POST** /authn-k8s/{service_id}/inject_client_cert | For applications running in Kubernetes; sends Conjur a certificate signing request (CSR) and requests a client certificate injected into the application&#39;s Kubernetes pod.  |
| [**toggleAuthenticatorInstanceStatus**](AuthenticationApi.md#toggleAuthenticatorInstanceStatus) | **PATCH** /{authenticator}/{service_id}/{account} | Enables or disables authenticator service instances. |
| [**toggleAuthenticatorStatus**](AuthenticationApi.md#toggleAuthenticatorStatus) | **PATCH** /{authenticator}/{account} | Enables or disables authenticator defined without service_id. |


<a name="authenticateWithId"></a>
# **authenticateWithId**
> authenticateWithId(account, id, serviceId, body).xRequestId(xRequestId).execute();

Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. Covers the case of use of optional URL parameter \&quot;ID\&quot; 

Use the JWT Authenticator to leverage the identity layer provided by JWT to authenticate with Conjur. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "account_example"; // Organization account name
    String id = "SomeUserID"; // Organization user id
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .authentication
              .authenticateWithId(account, id, serviceId)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#authenticateWithId");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .authenticateWithId(account, id, serviceId)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#authenticateWithId");
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
| **id** | **String**| Organization user id | |
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **body** | **Object**| ID token | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="azureAuthenticate"></a>
# **azureAuthenticate**
> azureAuthenticate(serviceId, account, login, authenticationAzureAuthenticateRequest).xRequestId(xRequestId).acceptEncoding(acceptEncoding).jwt(jwt).execute();

Gets a short-lived access token for applications running in Azure.

The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  To authenticate to Conjur using this endpoint, reference the detailed documentation: [Azure Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/azure_authn.htm) (&#x60;authn-azure&#x60;). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "account_example"; // Organization account name
    ERRORUNKNOWN login = new ERRORUNKNOWN(); // URL-encoded login name. For users, it’s the user ID. For hosts, the login name is `host/<host-id>`
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "application/json"; // Setting the Accept-Encoding header to base64 will return a pre-encoded access token
    String jwt = "jwt_example";
    try {
      client
              .authentication
              .azureAuthenticate(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .jwt(jwt)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#azureAuthenticate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .azureAuthenticate(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .jwt(jwt)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#azureAuthenticate");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
| **login** | [**ERRORUNKNOWN**](.md)| URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; | |
| **authenticationAzureAuthenticateRequest** | [**AuthenticationAzureAuthenticateRequest**](AuthenticationAzureAuthenticateRequest.md)| Azure identity token | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Setting the Accept-Encoding header to base64 will return a pre-encoded access token | [optional] [default to application/json] [enum: application/json, base64] |
| **jwt** | **String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="changeUserPassword"></a>
# **changeUserPassword**
> changeUserPassword(account, body).xRequestId(xRequestId).execute();

Changes a user’s password.

You must provide the login name and current password or API key of the user whose password is to be updated in an HTTP Basic Authentication header. Also replaces the user’s API key with a new securely generated random value. You can fetch the new API key using the Login method.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  Note that machine roles (Hosts) do not have passwords. They authenticate using their API keys, while passwords are only used by human users. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    try {
      client
              .authentication
              .changeUserPassword(account)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#changeUserPassword");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .changeUserPassword(account)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#changeUserPassword");
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
| **body** | **String**| New password | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The password has been changed |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="exchangeLdapCredentialsForApiKey"></a>
# **exchangeLdapCredentialsForApiKey**
> exchangeLdapCredentialsForApiKey(serviceId, account).xRequestId(xRequestId).execute();

Gets the Conjur API key of a user given the LDAP username and password via HTTP Basic Authentication. 

Exchange your LDAP credentials for a Conjur API key. Once the API key is obtained, it may be used to inexpensively obtain access tokens by calling the Authenticate method. An access token is required to use most other parts of the Conjur API.  The Basic authentication-compliant header is formed by: 1. Concatenating the LDAP username, a literal colon character &#39;:&#39;,    and the password to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "account_example"; // Organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .authentication
              .exchangeLdapCredentialsForApiKey(serviceId, account)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#exchangeLdapCredentialsForApiKey");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .exchangeLdapCredentialsForApiKey(serviceId, account)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#exchangeLdapCredentialsForApiKey");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
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
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="gcpAuthnAuthenticate"></a>
# **gcpAuthnAuthenticate**
> gcpAuthnAuthenticate(account, authenticationGcpAuthnAuthenticateRequest).xRequestId(xRequestId).acceptEncoding(acceptEncoding).jwt(jwt).execute();

Gets a short-lived access token for applications running in Google Cloud Platform. 

Use the GCP Authenticator API to send an authentication request from a Google Cloud service to Conjur.  For more information, see [the documentation](https://docs.conjur.org/Latest/en/Content/Operations/Services/cjr-gcp-authn.htm). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "dev"; // Organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "base64"; // Setting the Accept-Encoding header to base64 will return a pre-encoded access token
    String jwt = "jwt_example";
    try {
      client
              .authentication
              .gcpAuthnAuthenticate(account)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .jwt(jwt)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#gcpAuthnAuthenticate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .gcpAuthnAuthenticate(account)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .jwt(jwt)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#gcpAuthnAuthenticate");
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
| **authenticationGcpAuthnAuthenticateRequest** | [**AuthenticationGcpAuthnAuthenticateRequest**](AuthenticationGcpAuthnAuthenticateRequest.md)| Google JWT identity token for the Google Cloud service | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Setting the Accept-Encoding header to base64 will return a pre-encoded access token | [optional] [enum: base64] |
| **jwt** | **String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="getShortLivedToken"></a>
# **getShortLivedToken**
> getShortLivedToken(serviceId, account, login, body).xRequestId(xRequestId).acceptEncoding(acceptEncoding).execute();

Get a short-lived access token for applications running in AWS.

The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For detailed instructions on authenticating to Conjur using this endpoint, reference the documentation: [AWS IAM Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/AWS_IAM_Authenticator.htm) (&#x60;authn-iam&#x60;). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "account_example"; // Organization account name
    ERRORUNKNOWN login = new ERRORUNKNOWN(); // URL-encoded login name. For hosts, the login name is `host/<host-id>`
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "application/json"; // Setting the Accept-Encoding header to base64 will return a pre-encoded access token
    try {
      client
              .authentication
              .getShortLivedToken(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#getShortLivedToken");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .getShortLivedToken(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#getShortLivedToken");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
| **login** | [**ERRORUNKNOWN**](.md)| URL-encoded login name. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; | |
| **body** | **String**| AWS Signature header | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Setting the Accept-Encoding header to base64 will return a pre-encoded access token | [optional] [default to application/json] [enum: application/json, base64] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="getUserApiKey"></a>
# **getUserApiKey**
> Object getUserApiKey(account).xRequestId(xRequestId).execute();

Gets the API key of a user given the username and password via HTTP Basic Authentication. 

Passwords are stored in the Conjur database using &#x60;bcrypt&#x60; with a work factor of 12. Therefore, login is a fairly expensive operation. However, once the API key is obtained, it may be used to inexpensively obtain access tokens by calling the Authenticate method. An access token is required to use most other parts of the Conjur API.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  Note that machine roles (Hosts) do not have passwords and do not need to use this endpoint. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    try {
      Object result = client
              .authentication
              .getUserApiKey(account)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#getUserApiKey");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Object> response = client
              .authentication
              .getUserApiKey(account)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#getUserApiKey");
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

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response body is the API key |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="jwtAuthenticate"></a>
# **jwtAuthenticate**
> jwtAuthenticate(account, serviceId, authenticationJwtAuthenticateRequest).xRequestId(xRequestId).jwt(jwt).execute();

Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. 

Use the JWT Authenticator to leverage the identity layer provided by JWT to authenticate with Conjur. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "account_example"; // Organization account name
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String jwt = "jwt_example";
    try {
      client
              .authentication
              .jwtAuthenticate(account, serviceId)
              .xRequestId(xRequestId)
              .jwt(jwt)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#jwtAuthenticate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .jwtAuthenticate(account, serviceId)
              .xRequestId(xRequestId)
              .jwt(jwt)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#jwtAuthenticate");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **authenticationJwtAuthenticateRequest** | [**AuthenticationJwtAuthenticateRequest**](AuthenticationJwtAuthenticateRequest.md)| ID token | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **jwt** | **String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="kubernetesAuthnAuthenticate"></a>
# **kubernetesAuthnAuthenticate**
> kubernetesAuthnAuthenticate(serviceId, account, login).xRequestId(xRequestId).acceptEncoding(acceptEncoding).execute();

Gets a short-lived access token for applications running in Kubernetes.

The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  To authenticate to Conjur using this endpoint, reference the detailed documentation: [Kubernetes Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/k8s_auth.htm) (&#x60;authn-k8s&#x60;). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "account_example"; // Organization account name
    ERRORUNKNOWN login = new ERRORUNKNOWN(); // URL-encoded login name. For users, it’s the user ID. For hosts, the login name is `host/<host-id>`
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "application/json"; // Setting the Accept-Encoding header to base64 will return a pre-encoded access token
    try {
      client
              .authentication
              .kubernetesAuthnAuthenticate(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#kubernetesAuthnAuthenticate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .kubernetesAuthnAuthenticate(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#kubernetesAuthnAuthenticate");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
| **login** | [**ERRORUNKNOWN**](.md)| URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Setting the Accept-Encoding header to base64 will return a pre-encoded access token | [optional] [default to application/json] [enum: application/json, base64] |

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
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="ldapAuthenticate"></a>
# **ldapAuthenticate**
> ldapAuthenticate(serviceId, account, login).xRequestId(xRequestId).acceptEncoding(acceptEncoding).body(body).execute();

Gets a short-lived access token for users and hosts using their LDAP identity to access the Conjur API. 

The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded. For example, &#x60;alice@devops&#x60; must be encoded as &#x60;alice%40devops&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For host authentication, the &#x60;login&#x60; is the host ID with the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  To authenticate to Conjur using a LDAP, reference the detailed documentation: [LDAP Authenticator](https://docs.conjur.org/Latest/en/Content/Integrations/ldap/ldap_authenticator.html) (&#x60;authn-ldap&#x60;). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "account_example"; // Organization account name
    ERRORUNKNOWN login = new ERRORUNKNOWN(); // URL-encoded login name. For users, it’s the user ID. For hosts, the login name is `host/<host-id>`
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "application/json"; // Setting the Accept-Encoding header to base64 will return a pre-encoded access token
    try {
      client
              .authentication
              .ldapAuthenticate(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#ldapAuthenticate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .ldapAuthenticate(serviceId, account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#ldapAuthenticate");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
| **login** | [**ERRORUNKNOWN**](.md)| URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Setting the Accept-Encoding header to base64 will return a pre-encoded access token | [optional] [default to application/json] [enum: application/json, base64] |
| **body** | **Object**| API key | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="obtainAccessToken"></a>
# **obtainAccessToken**
> String obtainAccessToken(account, login, body).xRequestId(xRequestId).acceptEncoding(acceptEncoding).execute();

Gets a short-lived access token, which is required in the header of most subsequent API requests. 

A client can obtain an access token by presenting a valid login name and API key.  The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  The &#x60;login&#x60; must be URL encoded. For example, &#x60;alice@devops&#x60; must be encoded as &#x60;alice%40devops&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For host authentication, the &#x60;login&#x60; is the host ID with the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  This is the default authentication endpoint only. See other endpoints for details on authenticating to Conjur using another method, e.g. for applications running in Azure or Kubernetes. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String account = "account_example"; // Organization account name
    String login = "admin"; // URL-encoded login name. For users, it’s the user ID. For hosts, the login name is `host/<host-id>`
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String acceptEncoding = "application/json"; // Setting the Accept-Encoding header to base64 will return a pre-encoded access token
    try {
      String result = client
              .authentication
              .obtainAccessToken(account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#obtainAccessToken");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<String> response = client
              .authentication
              .obtainAccessToken(account, login)
              .xRequestId(xRequestId)
              .acceptEncoding(acceptEncoding)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#obtainAccessToken");
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
| **login** | **String**| URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; | |
| **body** | **String**| API Key | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **acceptEncoding** | **String**| Setting the Accept-Encoding header to base64 will return a pre-encoded access token | [optional] [default to application/json] [enum: application/json, base64] |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response is an access token for conjur |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="oidcAuthenticate"></a>
# **oidcAuthenticate**
> oidcAuthenticate(serviceId, account, authenticationOidcAuthenticateRequest).xRequestId(xRequestId).idToken(idToken).execute();

Gets a short-lived access token for applications using OpenID Connect (OIDC) to access the Conjur API. 

Use the OIDC Authenticator to leverage the identity layer provided by OIDC to authenticate with Conjur.  For more information see [the documentation](https://docs.conjur.org/Latest/en/Content/OIDC/OIDC.htm). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "http://localhost";
    CyberArkConjur client = new CyberArkConjur(configuration);
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "account_example"; // Organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String idToken = "idToken_example";
    try {
      client
              .authentication
              .oidcAuthenticate(serviceId, account)
              .xRequestId(xRequestId)
              .idToken(idToken)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#oidcAuthenticate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .oidcAuthenticate(serviceId, account)
              .xRequestId(xRequestId)
              .idToken(idToken)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#oidcAuthenticate");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
| **authenticationOidcAuthenticateRequest** | [**AuthenticationOidcAuthenticateRequest**](AuthenticationOidcAuthenticateRequest.md)| ID token | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **idToken** | **String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |

<a name="rotateApiKey"></a>
# **rotateApiKey**
> rotateApiKey(account).xRequestId(xRequestId).role(role).execute();

Rotates a role&#39;s API key.

Any role can rotate its own API key. The name and password (for users) or current API key (for hosts and users) of the role must be provided via HTTP Basic Authorization.  To rotate another role&#39;s API key, you may provide your name and password (for users) or current API key (for hosts and users) via HTTP Basic Authorization with the request. Alternatively, you may provide your Conjur access token via the standard Conjur &#x60;Authorization&#x60; header.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  If using the Conjur &#x60;Authorization&#x60; header, its value should be set to &#x60;Token token&#x3D;&lt;base64-encoded access token&gt;&#x60;.  Note that the body of the request must be the empty string. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    String role = "role_example"; // (**Optional**) role specifier in `{kind}:{identifier}` format  ##### Permissions required  `update` privilege on the role whose API key is being rotated. 
    try {
      client
              .authentication
              .rotateApiKey(account)
              .xRequestId(xRequestId)
              .role(role)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#rotateApiKey");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .rotateApiKey(account)
              .xRequestId(xRequestId)
              .role(role)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#rotateApiKey");
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
| **role** | **String**| (**Optional**) role specifier in &#x60;{kind}:{identifier}&#x60; format  ##### Permissions required  &#x60;update&#x60; privilege on the role whose API key is being rotated.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **422** | A request parameter was either missing or invalid. |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="sendCsrForClientCertInjection"></a>
# **sendCsrForClientCertInjection**
> sendCsrForClientCertInjection(serviceId, body).xRequestId(xRequestId).hostIdPrefix(hostIdPrefix).execute();

For applications running in Kubernetes; sends Conjur a certificate signing request (CSR) and requests a client certificate injected into the application&#39;s Kubernetes pod. 

This request sends a Certificate Signing Request to Conjur, which uses the Kubernetes API to inject a client certificate into the application pod.  This endpoint requires a properly configured Conjur Certificate Authority service alongside a properly configured and enabled Kubernetes authenticator. For detailed instructions, see [the documentation](https://docs.conjur.org/Latest/en/Content/Integrations/kubernetes.htm). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    String hostIdPrefix = "host/conjur/authn-k8s/my-authenticator-id/apps"; // Dot-separated policy tree, prefixed by `host.`, where the application identity is defined
    try {
      client
              .authentication
              .sendCsrForClientCertInjection(serviceId)
              .xRequestId(xRequestId)
              .hostIdPrefix(hostIdPrefix)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#sendCsrForClientCertInjection");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .sendCsrForClientCertInjection(serviceId)
              .xRequestId(xRequestId)
              .hostIdPrefix(hostIdPrefix)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#sendCsrForClientCertInjection");
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
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **body** | **String**| Valid certificate signing request that includes the host identity suffix as the CSR common name  | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **hostIdPrefix** | **String**| Dot-separated policy tree, prefixed by &#x60;host.&#x60;, where the application identity is defined | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | The injected certificate was accepted. |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |

<a name="toggleAuthenticatorInstanceStatus"></a>
# **toggleAuthenticatorInstanceStatus**
> toggleAuthenticatorInstanceStatus(authenticator, serviceId, account, body).xRequestId(xRequestId).execute();

Enables or disables authenticator service instances.

Allows you to either enable or disable a given authenticator service instance.  When you enable or disable an authenticator service instance via this endpoint, the status of the authenticator service instance is stored in the Conjur database. The enablement status of the authenticator service instance may be overridden by setting the &#x60;CONJUR_AUTHENTICATORS&#x60; environment variable on the Conjur server; in the case where this environment variable is set, the database record of whether the authenticator service instance is enabled will be ignored.  **This endpoint is part of an early implementation of support for enabling Conjur authenticators via the API, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future.** 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    ERRORUNKNOWN authenticator = new ERRORUNKNOWN(); // The authenticator to update
    String serviceId = "prod%2fgke"; // URL-Encoded authenticator service ID
    String account = "dev"; // Organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      client
              .authentication
              .toggleAuthenticatorInstanceStatus(authenticator, serviceId, account)
              .xRequestId(xRequestId)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#toggleAuthenticatorInstanceStatus");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .toggleAuthenticatorInstanceStatus(authenticator, serviceId, account)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#toggleAuthenticatorInstanceStatus");
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
| **authenticator** | [**ERRORUNKNOWN**](.md)| The authenticator to update | |
| **serviceId** | **String**| URL-Encoded authenticator service ID | |
| **account** | **String**| Organization account name | |
| **body** | **Object**| Contains either &#x60;enabled&#x3D;true&#x60; or &#x60;enabled&#x3D;false&#x60; to enable or disable an authenticator  | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The config was updated properly |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

<a name="toggleAuthenticatorStatus"></a>
# **toggleAuthenticatorStatus**
> toggleAuthenticatorStatus(authenticator, account, authenticationToggleAuthenticatorStatusRequest).xRequestId(xRequestId).enabled(enabled).execute();

Enables or disables authenticator defined without service_id.

Allows you to either enable or disable a given authenticator that does not have service_id (For example: authn-gcp).  When you enable or disable an authenticator via this endpoint, the status of the authenticator is stored in the Conjur database. The enablement status of the authenticator service may be overridden by setting the &#x60;CONJUR_AUTHENTICATORS&#x60; environment variable on the Conjur server; in the case where this environment variable is set, the database record of whether the authenticator service is enabled will be ignored.  **This endpoint is part of an early implementation of support for enabling Conjur authenticators via the API, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future.** 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AuthenticationApi;
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
    String authenticator = "authn-iam"; // The authenticator to update
    String account = "dev"; // Organization account name
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    Boolean enabled = true;
    try {
      client
              .authentication
              .toggleAuthenticatorStatus(authenticator, account)
              .xRequestId(xRequestId)
              .enabled(enabled)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#toggleAuthenticatorStatus");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .authentication
              .toggleAuthenticatorStatus(authenticator, account)
              .xRequestId(xRequestId)
              .enabled(enabled)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#toggleAuthenticatorStatus");
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
| **authenticator** | **String**| The authenticator to update | [enum: authn-iam, authn-oidc, authn-ldap, authn-k8s, authn-gcp, authn-azure, authn-jwt] |
| **account** | **String**| Organization account name | |
| **authenticationToggleAuthenticatorStatusRequest** | [**AuthenticationToggleAuthenticatorStatusRequest**](AuthenticationToggleAuthenticatorStatusRequest.md)| Contains either &#x60;enabled&#x3D;true&#x60; or &#x60;enabled&#x3D;false&#x60; to enable or disable an authenticator  | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |
| **enabled** | **Boolean**|  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The config was updated properly |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **404** | The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set |  -  |
| **500** | Malfromed request, rejected by the server |  -  |

