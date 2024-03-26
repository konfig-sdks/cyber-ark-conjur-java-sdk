

# StatusGetClientInfoResponse

Information about the client making a request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**clientIp** | **String** | The request client IP address as determined by Conjur. This same IP address appears in application logs and audit logs. |  [optional] |
|**userAgent** | **String** | The incoming request HTTP user agent header. |  [optional] |
|**account** | **String** | The account attribute of the client provided access token. |  [optional] |
|**username** | **String** | The username attribute of the provided access token. |  [optional] |
|**tokenIssuedAt** | **String** | The issued timestamp, that is, when the provided access token was created (iat field in the JWT) |  [optional] |



