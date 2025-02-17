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


package com.konfigthis.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.konfigthis.client.model.StatusConjurServerInfoResponseAuthenticators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.konfigthis.client.JSON;

/**
 * StatusConjurServerInfoResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class StatusConjurServerInfoResponse {
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private String version;

  public static final String SERIALIZED_NAME_AUTHENTICATORS = "authenticators";
  @SerializedName(SERIALIZED_NAME_AUTHENTICATORS)
  private StatusConjurServerInfoResponseAuthenticators authenticators;

  public static final String SERIALIZED_NAME_CONFIGURATION = "configuration";
  @SerializedName(SERIALIZED_NAME_CONFIGURATION)
  private Object _configuration;

  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private String role;

  public static final String SERIALIZED_NAME_CONTAINER = "container";
  @SerializedName(SERIALIZED_NAME_CONTAINER)
  private String container;

  public static final String SERIALIZED_NAME_RELEASE = "release";
  @SerializedName(SERIALIZED_NAME_RELEASE)
  private String release;

  public static final String SERIALIZED_NAME_SERVICES = "services";
  @SerializedName(SERIALIZED_NAME_SERVICES)
  private Object services;

  public StatusConjurServerInfoResponse() {
  }

  public StatusConjurServerInfoResponse version(String version) {
    
    
    
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    
    
    
    this.version = version;
  }


  public StatusConjurServerInfoResponse authenticators(StatusConjurServerInfoResponseAuthenticators authenticators) {
    
    
    
    
    this.authenticators = authenticators;
    return this;
  }

   /**
   * Get authenticators
   * @return authenticators
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public StatusConjurServerInfoResponseAuthenticators getAuthenticators() {
    return authenticators;
  }


  public void setAuthenticators(StatusConjurServerInfoResponseAuthenticators authenticators) {
    
    
    
    this.authenticators = authenticators;
  }


  public StatusConjurServerInfoResponse _configuration(Object _configuration) {
    
    
    
    
    this._configuration = _configuration;
    return this;
  }

   /**
   * Get _configuration
   * @return _configuration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getConfiguration() {
    return _configuration;
  }


  public void setConfiguration(Object _configuration) {
    
    
    
    this._configuration = _configuration;
  }


  public StatusConjurServerInfoResponse role(String role) {
    
    
    
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    
    
    
    this.role = role;
  }


  public StatusConjurServerInfoResponse container(String container) {
    
    
    
    
    this.container = container;
    return this;
  }

   /**
   * Get container
   * @return container
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getContainer() {
    return container;
  }


  public void setContainer(String container) {
    
    
    
    this.container = container;
  }


  public StatusConjurServerInfoResponse release(String release) {
    
    
    
    
    this.release = release;
    return this;
  }

   /**
   * Get release
   * @return release
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRelease() {
    return release;
  }


  public void setRelease(String release) {
    
    
    
    this.release = release;
  }


  public StatusConjurServerInfoResponse services(Object services) {
    
    
    
    
    this.services = services;
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getServices() {
    return services;
  }


  public void setServices(Object services) {
    
    
    
    this.services = services;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the StatusConjurServerInfoResponse instance itself
   */
  public StatusConjurServerInfoResponse putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusConjurServerInfoResponse statusConjurServerInfoResponse = (StatusConjurServerInfoResponse) o;
    return Objects.equals(this.version, statusConjurServerInfoResponse.version) &&
        Objects.equals(this.authenticators, statusConjurServerInfoResponse.authenticators) &&
        Objects.equals(this._configuration, statusConjurServerInfoResponse._configuration) &&
        Objects.equals(this.role, statusConjurServerInfoResponse.role) &&
        Objects.equals(this.container, statusConjurServerInfoResponse.container) &&
        Objects.equals(this.release, statusConjurServerInfoResponse.release) &&
        Objects.equals(this.services, statusConjurServerInfoResponse.services)&&
        Objects.equals(this.additionalProperties, statusConjurServerInfoResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, authenticators, _configuration, role, container, release, services, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusConjurServerInfoResponse {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    authenticators: ").append(toIndentedString(authenticators)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    container: ").append(toIndentedString(container)).append("\n");
    sb.append("    release: ").append(toIndentedString(release)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("version");
    openapiFields.add("authenticators");
    openapiFields.add("configuration");
    openapiFields.add("role");
    openapiFields.add("container");
    openapiFields.add("release");
    openapiFields.add("services");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to StatusConjurServerInfoResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!StatusConjurServerInfoResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StatusConjurServerInfoResponse is not found in the empty JSON string", StatusConjurServerInfoResponse.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("version") != null && !jsonObj.get("version").isJsonNull()) && !jsonObj.get("version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("version").toString()));
      }
      // validate the optional field `authenticators`
      if (jsonObj.get("authenticators") != null && !jsonObj.get("authenticators").isJsonNull()) {
        StatusConjurServerInfoResponseAuthenticators.validateJsonObject(jsonObj.getAsJsonObject("authenticators"));
      }
      if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull()) && !jsonObj.get("role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role").toString()));
      }
      if ((jsonObj.get("container") != null && !jsonObj.get("container").isJsonNull()) && !jsonObj.get("container").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `container` to be a primitive type in the JSON string but got `%s`", jsonObj.get("container").toString()));
      }
      if ((jsonObj.get("release") != null && !jsonObj.get("release").isJsonNull()) && !jsonObj.get("release").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `release` to be a primitive type in the JSON string but got `%s`", jsonObj.get("release").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StatusConjurServerInfoResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StatusConjurServerInfoResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StatusConjurServerInfoResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StatusConjurServerInfoResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<StatusConjurServerInfoResponse>() {
           @Override
           public void write(JsonWriter out, StatusConjurServerInfoResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additonal properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public StatusConjurServerInfoResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             StatusConjurServerInfoResponse instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of StatusConjurServerInfoResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of StatusConjurServerInfoResponse
  * @throws IOException if the JSON string is invalid with respect to StatusConjurServerInfoResponse
  */
  public static StatusConjurServerInfoResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StatusConjurServerInfoResponse.class);
  }

 /**
  * Convert an instance of StatusConjurServerInfoResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

