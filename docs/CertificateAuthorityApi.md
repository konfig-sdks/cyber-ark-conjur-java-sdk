# CertificateAuthorityApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSignedCertificate**](CertificateAuthorityApi.md#getSignedCertificate) | **POST** /ca/{account}/{service_id}/sign | Gets a signed certificate from the configured Certificate Authority service. |


<a name="getSignedCertificate"></a>
# **getSignedCertificate**
> CertificateAuthorityGetSignedCertificateResponse getSignedCertificate(account, serviceId, csr, ttl, certificateAuthorityGetSignedCertificateRequest).xRequestId(xRequestId).execute();

Gets a signed certificate from the configured Certificate Authority service.

Gets a signed certificate from the configured Certificate Authority service.  The request must include a valid Certificate Signing Request, and a desired TTL in ISO 8601 format.  *** IMPORTANT *** This endpoint is part of an early implementation of support for using Conjur as a certificate authority, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.CyberArkConjur;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CertificateAuthorityApi;
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
    String serviceId = "ca-service"; // Name of the Certificate Authority service
    String csr = "csr_example";
    String ttl = "ttl_example";
    String xRequestId = "test-id"; // Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one. 
    try {
      CertificateAuthorityGetSignedCertificateResponse result = client
              .certificateAuthority
              .getSignedCertificate(account, serviceId, csr, ttl)
              .xRequestId(xRequestId)
              .execute();
      System.out.println(result);
      System.out.println(result.getCertificate());
    } catch (ApiException e) {
      System.err.println("Exception when calling CertificateAuthorityApi#getSignedCertificate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CertificateAuthorityGetSignedCertificateResponse> response = client
              .certificateAuthority
              .getSignedCertificate(account, serviceId, csr, ttl)
              .xRequestId(xRequestId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CertificateAuthorityApi#getSignedCertificate");
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
| **serviceId** | **String**| Name of the Certificate Authority service | |
| **csr** | **String**|  | |
| **ttl** | **String**|  | |
| **certificateAuthorityGetSignedCertificateRequest** | [**CertificateAuthorityGetSignedCertificateRequest**](CertificateAuthorityGetSignedCertificateRequest.md)| Client Certificate Signing Request | |
| **xRequestId** | **String**| Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  | [optional] |

### Return type

[**CertificateAuthorityGetSignedCertificateResponse**](CertificateAuthorityGetSignedCertificateResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [conjurAuth](../README.md#conjurAuth), [conjurKubernetesMutualTls](../README.md#conjurKubernetesMutualTls)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json, application/x-pem-file

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The response body is the newly signed certificate |  -  |
| **400** | The server cannot process the request due to malformed request syntax |  -  |
| **401** | Authentication information is missing or invalid |  -  |
| **403** | Either           - The authenticated role is not a Host role, - The authenticated Host does not have &#x60;sign&#x60; privilege for the CA service, or - The authenticated Host ID does not match the of the CSR Common Name (CN).  |  -  |
| **404** | CA Service with the given ID does not exist |  -  |

