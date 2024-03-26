<div align="left">

[![Visit Cyberark](./header.png)](https://cyberark.com)

# [Cyberark](https://cyberark.com)

This is an API definition for CyberArk Conjur Open Source. You can find out more at [Conjur.org](https://www.conjur.org/).

</div>

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

If you are adding this library to an Android Application or Library:

3. Android 8.0+ (API Level 26+)

## Installation<a id="installation"></a>
<div align="center">
  <a href="https://konfigthis.com/sdk-sign-up?company=CyberArk&serviceName=Conjur&language=Java">
    <img src="https://raw.githubusercontent.com/konfig-dev/brand-assets/HEAD/cta-images/java-cta.png" width="70%">
  </a>
</div>

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.konfigthis</groupId>
  <artifactId>cyber-ark-conjur-java-sdk</artifactId>
  <version>5.3.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your `build.gradle`:

```groovy
// build.gradle
repositories {
  mavenCentral()
}

dependencies {
   implementation "com.konfigthis:cyber-ark-conjur-java-sdk:5.3.1"
}
```

### Android users

Make sure your `build.gradle` file as a `minSdk` version of at least 26:
```groovy
// build.gradle
android {
    defaultConfig {
        minSdk 26
    }
}
```

Also make sure your library or application has internet permissions in your `AndroidManifest.xml`:

```xml
<!--AndroidManifest.xml-->
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET"/>
</manifest>
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/cyber-ark-conjur-java-sdk-5.3.1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

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

## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AuthenticationApi* | [**authenticateWithId**](docs/AuthenticationApi.md#authenticateWithId) | **POST** /authn-jwt/{service_id}/{account}/{id}/authenticate | Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. Covers the case of use of optional URL parameter \&quot;ID\&quot; 
*AuthenticationApi* | [**azureAuthenticate**](docs/AuthenticationApi.md#azureAuthenticate) | **POST** /authn-azure/{service_id}/{account}/{login}/authenticate | Gets a short-lived access token for applications running in Azure.
*AuthenticationApi* | [**changeUserPassword**](docs/AuthenticationApi.md#changeUserPassword) | **PUT** /authn/{account}/password | Changes a user’s password.
*AuthenticationApi* | [**exchangeLdapCredentialsForApiKey**](docs/AuthenticationApi.md#exchangeLdapCredentialsForApiKey) | **GET** /authn-ldap/{service_id}/{account}/login | Gets the Conjur API key of a user given the LDAP username and password via HTTP Basic Authentication. 
*AuthenticationApi* | [**gcpAuthnAuthenticate**](docs/AuthenticationApi.md#gcpAuthnAuthenticate) | **POST** /authn-gcp/{account}/authenticate | Gets a short-lived access token for applications running in Google Cloud Platform. 
*AuthenticationApi* | [**getShortLivedToken**](docs/AuthenticationApi.md#getShortLivedToken) | **POST** /authn-iam/{service_id}/{account}/{login}/authenticate | Get a short-lived access token for applications running in AWS.
*AuthenticationApi* | [**getUserApiKey**](docs/AuthenticationApi.md#getUserApiKey) | **GET** /authn/{account}/login | Gets the API key of a user given the username and password via HTTP Basic Authentication. 
*AuthenticationApi* | [**jwtAuthenticate**](docs/AuthenticationApi.md#jwtAuthenticate) | **POST** /authn-jwt/{service_id}/{account}/authenticate | Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. 
*AuthenticationApi* | [**kubernetesAuthnAuthenticate**](docs/AuthenticationApi.md#kubernetesAuthnAuthenticate) | **POST** /authn-k8s/{service_id}/{account}/{login}/authenticate | Gets a short-lived access token for applications running in Kubernetes.
*AuthenticationApi* | [**ldapAuthenticate**](docs/AuthenticationApi.md#ldapAuthenticate) | **POST** /authn-ldap/{service_id}/{account}/{login}/authenticate | Gets a short-lived access token for users and hosts using their LDAP identity to access the Conjur API. 
*AuthenticationApi* | [**obtainAccessToken**](docs/AuthenticationApi.md#obtainAccessToken) | **POST** /authn/{account}/{login}/authenticate | Gets a short-lived access token, which is required in the header of most subsequent API requests. 
*AuthenticationApi* | [**oidcAuthenticate**](docs/AuthenticationApi.md#oidcAuthenticate) | **POST** /authn-oidc/{service_id}/{account}/authenticate | Gets a short-lived access token for applications using OpenID Connect (OIDC) to access the Conjur API. 
*AuthenticationApi* | [**rotateApiKey**](docs/AuthenticationApi.md#rotateApiKey) | **PUT** /authn/{account}/api_key | Rotates a role&#39;s API key.
*AuthenticationApi* | [**sendCsrForClientCertInjection**](docs/AuthenticationApi.md#sendCsrForClientCertInjection) | **POST** /authn-k8s/{service_id}/inject_client_cert | For applications running in Kubernetes; sends Conjur a certificate signing request (CSR) and requests a client certificate injected into the application&#39;s Kubernetes pod. 
*AuthenticationApi* | [**toggleAuthenticatorInstanceStatus**](docs/AuthenticationApi.md#toggleAuthenticatorInstanceStatus) | **PATCH** /{authenticator}/{service_id}/{account} | Enables or disables authenticator service instances.
*AuthenticationApi* | [**toggleAuthenticatorStatus**](docs/AuthenticationApi.md#toggleAuthenticatorStatus) | **PATCH** /{authenticator}/{account} | Enables or disables authenticator defined without service_id.
*CertificateAuthorityApi* | [**getSignedCertificate**](docs/CertificateAuthorityApi.md#getSignedCertificate) | **POST** /ca/{account}/{service_id}/sign | Gets a signed certificate from the configured Certificate Authority service.
*HostFactoryApi* | [**createHost**](docs/HostFactoryApi.md#createHost) | **POST** /host_factories/hosts | Creates a Host using the Host Factory.
*HostFactoryApi* | [**createHostIdentityTokens**](docs/HostFactoryApi.md#createHostIdentityTokens) | **POST** /host_factory_tokens | Creates one or more host identity tokens.
*HostFactoryApi* | [**revokeToken**](docs/HostFactoryApi.md#revokeToken) | **DELETE** /host_factory_tokens/{token} | Revokes a token, immediately disabling it.
*PoliciesApi* | [**addDataToExistingPolicy**](docs/PoliciesApi.md#addDataToExistingPolicy) | **POST** /policies/{account}/policy/{identifier} | Adds data to the existing Conjur policy.
*PoliciesApi* | [**modifyPolicy**](docs/PoliciesApi.md#modifyPolicy) | **PATCH** /policies/{account}/policy/{identifier} | Modifies an existing Conjur policy.
*PoliciesApi* | [**putPolicyDocument**](docs/PoliciesApi.md#putPolicyDocument) | **PUT** /policies/{account}/policy/{identifier} | Loads or replaces a Conjur policy document.
*PublicKeysApi* | [**showAllForResource**](docs/PublicKeysApi.md#showAllForResource) | **GET** /public_keys/{account}/{kind}/{identifier} | Shows all public keys for a resource.
*ResourcesApi* | [**list**](docs/ResourcesApi.md#list) | **GET** /resources | Lists resources within an organization account.
*ResourcesApi* | [**listResources**](docs/ResourcesApi.md#listResources) | **GET** /resources/{account} | Lists resources within an organization account.
*ResourcesApi* | [**listResourcesForKind**](docs/ResourcesApi.md#listResourcesForKind) | **GET** /resources/{account}/{kind} | Lists resources of the same kind within an organization account.
*ResourcesApi* | [**showResourceDetails**](docs/ResourcesApi.md#showResourceDetails) | **GET** /resources/{account}/{kind}/{identifier} | Shows a description of a single resource.
*RolesApi* | [**deleteRoleMembership**](docs/RolesApi.md#deleteRoleMembership) | **DELETE** /roles/{account}/{kind}/{identifier} | Deletes an existing role membership
*RolesApi* | [**getRoleInformation**](docs/RolesApi.md#getRoleInformation) | **GET** /roles/{account}/{kind}/{identifier} | Get role information
*RolesApi* | [**updateRoleMembership**](docs/RolesApi.md#updateRoleMembership) | **POST** /roles/{account}/{kind}/{identifier} | Update or modify an existing role membership
*SecretsApi* | [**createSecretValue**](docs/SecretsApi.md#createSecretValue) | **POST** /secrets/{account}/{kind}/{identifier} | Creates a secret value within the specified variable.
*SecretsApi* | [**getMultipleValues**](docs/SecretsApi.md#getMultipleValues) | **GET** /secrets | Fetch multiple secrets
*SecretsApi* | [**getSecretValue**](docs/SecretsApi.md#getSecretValue) | **GET** /secrets/{account}/{kind}/{identifier} | Fetches the value of a secret from the specified Secret.
*StatusApi* | [**authenticatorDetails**](docs/StatusApi.md#authenticatorDetails) | **GET** /authenticators | Details about which authenticators are on the Conjur Server
*StatusApi* | [**checkAuthenticatorConfiguration**](docs/StatusApi.md#checkAuthenticatorConfiguration) | **GET** /{authenticator}/{service_id}/{account}/status | Details whether an authentication service has been configured properly
*StatusApi* | [**checkAuthenticatorStatus**](docs/StatusApi.md#checkAuthenticatorStatus) | **GET** /authn-gcp/{account}/status | Details whether an authentication service has been configured properly
*StatusApi* | [**checkConjurHealth**](docs/StatusApi.md#checkConjurHealth) | **GET** /health | Health info about conjur
*StatusApi* | [**checkRemoteHealth**](docs/StatusApi.md#checkRemoteHealth) | **GET** /remote_health/{remote} | Health info about a given Conjur Enterprise server
*StatusApi* | [**conjurServerInfo**](docs/StatusApi.md#conjurServerInfo) | **GET** /info | Basic information about the Conjur Enterprise server
*StatusApi* | [**getClientInfo**](docs/StatusApi.md#getClientInfo) | **GET** /whoami | Provides information about the client making an API request.


## Documentation for Models

 - [AuthenticationAzureAuthenticateRequest](docs/AuthenticationAzureAuthenticateRequest.md)
 - [AuthenticationGcpAuthnAuthenticateRequest](docs/AuthenticationGcpAuthnAuthenticateRequest.md)
 - [AuthenticationJwtAuthenticateRequest](docs/AuthenticationJwtAuthenticateRequest.md)
 - [AuthenticationOidcAuthenticateRequest](docs/AuthenticationOidcAuthenticateRequest.md)
 - [AuthenticationToggleAuthenticatorStatusRequest](docs/AuthenticationToggleAuthenticatorStatusRequest.md)
 - [CertificateAuthorityGetSignedCertificateRequest](docs/CertificateAuthorityGetSignedCertificateRequest.md)
 - [CertificateAuthorityGetSignedCertificateResponse](docs/CertificateAuthorityGetSignedCertificateResponse.md)
 - [HostFactoryCreateHostIdentityTokensRequest](docs/HostFactoryCreateHostIdentityTokensRequest.md)
 - [HostFactoryCreateHostIdentityTokensResponseInner](docs/HostFactoryCreateHostIdentityTokensResponseInner.md)
 - [HostFactoryCreateHostRequest](docs/HostFactoryCreateHostRequest.md)
 - [HostFactoryCreateHostResponse](docs/HostFactoryCreateHostResponse.md)
 - [PoliciesModifyPolicyResponse](docs/PoliciesModifyPolicyResponse.md)
 - [ResourcesShowResourceDetailsResponse](docs/ResourcesShowResourceDetailsResponse.md)
 - [ResourcesShowResourceDetailsResponsePermissionsInner](docs/ResourcesShowResourceDetailsResponsePermissionsInner.md)
 - [ResourcesShowResourceDetailsResponsePolicyVersionsInner](docs/ResourcesShowResourceDetailsResponsePolicyVersionsInner.md)
 - [ResourcesShowResourceDetailsResponseSecretsInner](docs/ResourcesShowResourceDetailsResponseSecretsInner.md)
 - [StatusAuthenticatorDetailsResponse](docs/StatusAuthenticatorDetailsResponse.md)
 - [StatusCheckAuthenticatorConfigurationResponse](docs/StatusCheckAuthenticatorConfigurationResponse.md)
 - [StatusConjurServerInfoResponse](docs/StatusConjurServerInfoResponse.md)
 - [StatusConjurServerInfoResponseAuthenticators](docs/StatusConjurServerInfoResponseAuthenticators.md)
 - [StatusGetClientInfoResponse](docs/StatusGetClientInfoResponse.md)


## Author
This Java package is automatically generated by [Konfig](https://konfigthis.com)
