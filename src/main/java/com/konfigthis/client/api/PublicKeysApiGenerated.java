/*
 * Conjur
 * This is an API definition for CyberArk Conjur Open Source. You can find out more at [Conjur.org](https://www.conjur.org/).
 *
 * The version of the OpenAPI document: 5.3.1
 * Contact: conj_maintainers@cyberark.com
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiCallback;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.Pair;
import com.konfigthis.client.ProgressRequestBody;
import com.konfigthis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PublicKeysApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PublicKeysApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public PublicKeysApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call showAllForResourceCall(String account, String kind, String identifier, String xRequestId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/public_keys/{account}/{kind}/{identifier}"
            .replace("{" + "account" + "}", localVarApiClient.escapeString(account.toString()))
            .replace("{" + "kind" + "}", localVarApiClient.escapeString(kind.toString()))
            .replace("{" + "identifier" + "}", localVarApiClient.escapeString(identifier.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (xRequestId != null) {
            localVarHeaderParams.put("X-Request-Id", localVarApiClient.parameterToString(xRequestId));
        }

        final String[] localVarAccepts = {
            "text/plain"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "conjurAuth", "conjurKubernetesMutualTls" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call showAllForResourceValidateBeforeCall(String account, String kind, String identifier, String xRequestId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new ApiException("Missing the required parameter 'account' when calling showAllForResource(Async)");
        }

        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new ApiException("Missing the required parameter 'kind' when calling showAllForResource(Async)");
        }

        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new ApiException("Missing the required parameter 'identifier' when calling showAllForResource(Async)");
        }

        return showAllForResourceCall(account, kind, identifier, xRequestId, _callback);

    }


    private ApiResponse<String> showAllForResourceWithHttpInfo(String account, String kind, String identifier, String xRequestId) throws ApiException {
        okhttp3.Call localVarCall = showAllForResourceValidateBeforeCall(account, kind, identifier, xRequestId, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call showAllForResourceAsync(String account, String kind, String identifier, String xRequestId, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = showAllForResourceValidateBeforeCall(account, kind, identifier, xRequestId, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ShowAllForResourceRequestBuilder {
        private final String account;
        private final String kind;
        private final String identifier;
        private String xRequestId;

        private ShowAllForResourceRequestBuilder(String account, String kind, String identifier) {
            this.account = account;
            this.kind = kind;
            this.identifier = identifier;
        }

        /**
         * Set xRequestId
         * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
         * @return ShowAllForResourceRequestBuilder
         */
        public ShowAllForResourceRequestBuilder xRequestId(String xRequestId) {
            this.xRequestId = xRequestId;
            return this;
        }
        
        /**
         * Build call for showAllForResource
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> The server cannot process the request due to malformed request syntax </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> A request parameter was either missing or invalid. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Malfromed request, rejected by the server </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return showAllForResourceCall(account, kind, identifier, xRequestId, _callback);
        }


        /**
         * Execute showAllForResource request
         * @return String
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> The server cannot process the request due to malformed request syntax </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> A request parameter was either missing or invalid. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Malfromed request, rejected by the server </td><td>  -  </td></tr>
         </table>
         */
        public String execute() throws ApiException {
            ApiResponse<String> localVarResp = showAllForResourceWithHttpInfo(account, kind, identifier, xRequestId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute showAllForResource request with HTTP info returned
         * @return ApiResponse&lt;String&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> The server cannot process the request due to malformed request syntax </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> A request parameter was either missing or invalid. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Malfromed request, rejected by the server </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<String> executeWithHttpInfo() throws ApiException {
            return showAllForResourceWithHttpInfo(account, kind, identifier, xRequestId);
        }

        /**
         * Execute showAllForResource request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> The server cannot process the request due to malformed request syntax </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> A request parameter was either missing or invalid. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Malfromed request, rejected by the server </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<String> _callback) throws ApiException {
            return showAllForResourceAsync(account, kind, identifier, xRequestId, _callback);
        }
    }

    /**
     * Shows all public keys for a resource.
     * Shows all public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Returns an empty string if the resource does not exist, to prevent attackers from determining whether a resource exists. 
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the resource for which to get the information about (required)
     * @return ShowAllForResourceRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The server cannot process the request due to malformed request syntax </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> A request parameter was either missing or invalid. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Malfromed request, rejected by the server </td><td>  -  </td></tr>
     </table>
     */
    public ShowAllForResourceRequestBuilder showAllForResource(String account, String kind, String identifier) throws IllegalArgumentException {
        if (account == null) throw new IllegalArgumentException("\"account\" is required but got null");
            if (account != null && account.length() < 1) {
              throw new IllegalArgumentException("Invalid value for account. Length must be greater than or equal to 1.");
            }

        if (kind == null) throw new IllegalArgumentException("\"kind\" is required but got null");
            if (kind != null && kind.length() < 1) {
              throw new IllegalArgumentException("Invalid value for kind. Length must be greater than or equal to 1.");
            }

        if (identifier == null) throw new IllegalArgumentException("\"identifier\" is required but got null");
            if (identifier != null && identifier.length() < 1) {
              throw new IllegalArgumentException("Invalid value for identifier. Length must be greater than or equal to 1.");
            }

        return new ShowAllForResourceRequestBuilder(account, kind, identifier);
    }
}
