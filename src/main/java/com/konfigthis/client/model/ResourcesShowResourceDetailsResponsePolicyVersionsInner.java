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
 * ResourcesShowResourceDetailsResponsePolicyVersionsInner
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ResourcesShowResourceDetailsResponsePolicyVersionsInner {
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Double version;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_POLICY_TEXT = "policy_text";
  @SerializedName(SERIALIZED_NAME_POLICY_TEXT)
  private String policyText;

  public static final String SERIALIZED_NAME_POLICY_SHA256 = "policy_sha256";
  @SerializedName(SERIALIZED_NAME_POLICY_SHA256)
  private String policySha256;

  public static final String SERIALIZED_NAME_FINISHED_AT = "finished_at";
  @SerializedName(SERIALIZED_NAME_FINISHED_AT)
  private String finishedAt;

  public static final String SERIALIZED_NAME_CLIENT_IP = "client_ip";
  @SerializedName(SERIALIZED_NAME_CLIENT_IP)
  private String clientIp;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private String role;

  public ResourcesShowResourceDetailsResponsePolicyVersionsInner() {
  }

  public ResourcesShowResourceDetailsResponsePolicyVersionsInner version(Double version) {
    
    
    
    
    this.version = version;
    return this;
  }

  public ResourcesShowResourceDetailsResponsePolicyVersionsInner version(Integer version) {
    
    
    
    
    this.version = version.doubleValue();
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "15", value = "")

  public Double getVersion() {
    return version;
  }


  public void setVersion(Double version) {
    
    
    
    this.version = version;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner createdAt(String createdAt) {
    
    
    
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2021-03-23T16:37:09.250+00:00", value = "")

  public String getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(String createdAt) {
    
    
    
    this.createdAt = createdAt;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner policyText(String policyText) {
    
    
    
    
    this.policyText = policyText;
    return this;
  }

   /**
   * Get policyText
   * @return policyText
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "- !variable one/password - !variable testSecret ", value = "")

  public String getPolicyText() {
    return policyText;
  }


  public void setPolicyText(String policyText) {
    
    
    
    this.policyText = policyText;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner policySha256(String policySha256) {
    
    
    
    
    this.policySha256 = policySha256;
    return this;
  }

   /**
   * Get policySha256
   * @return policySha256
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "73d7b43ab17d69d163dedfaac88ec02a9c18ed8675abe4fe5643cd33470baf86", value = "")

  public String getPolicySha256() {
    return policySha256;
  }


  public void setPolicySha256(String policySha256) {
    
    
    
    this.policySha256 = policySha256;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner finishedAt(String finishedAt) {
    
    
    
    
    this.finishedAt = finishedAt;
    return this;
  }

   /**
   * Get finishedAt
   * @return finishedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2021-03-23T16:37:09.435+00:00", value = "")

  public String getFinishedAt() {
    return finishedAt;
  }


  public void setFinishedAt(String finishedAt) {
    
    
    
    this.finishedAt = finishedAt;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner clientIp(String clientIp) {
    
    
    
    
    this.clientIp = clientIp;
    return this;
  }

   /**
   * Get clientIp
   * @return clientIp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "172.19.0.6", value = "")

  public String getClientIp() {
    return clientIp;
  }


  public void setClientIp(String clientIp) {
    
    
    
    this.clientIp = clientIp;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "dev:policy:root", value = "")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public ResourcesShowResourceDetailsResponsePolicyVersionsInner role(String role) {
    
    
    
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "dev:user:admin", value = "")

  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    
    
    
    this.role = role;
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
   * @return the ResourcesShowResourceDetailsResponsePolicyVersionsInner instance itself
   */
  public ResourcesShowResourceDetailsResponsePolicyVersionsInner putAdditionalProperty(String key, Object value) {
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
    ResourcesShowResourceDetailsResponsePolicyVersionsInner resourcesShowResourceDetailsResponsePolicyVersionsInner = (ResourcesShowResourceDetailsResponsePolicyVersionsInner) o;
    return Objects.equals(this.version, resourcesShowResourceDetailsResponsePolicyVersionsInner.version) &&
        Objects.equals(this.createdAt, resourcesShowResourceDetailsResponsePolicyVersionsInner.createdAt) &&
        Objects.equals(this.policyText, resourcesShowResourceDetailsResponsePolicyVersionsInner.policyText) &&
        Objects.equals(this.policySha256, resourcesShowResourceDetailsResponsePolicyVersionsInner.policySha256) &&
        Objects.equals(this.finishedAt, resourcesShowResourceDetailsResponsePolicyVersionsInner.finishedAt) &&
        Objects.equals(this.clientIp, resourcesShowResourceDetailsResponsePolicyVersionsInner.clientIp) &&
        Objects.equals(this.id, resourcesShowResourceDetailsResponsePolicyVersionsInner.id) &&
        Objects.equals(this.role, resourcesShowResourceDetailsResponsePolicyVersionsInner.role)&&
        Objects.equals(this.additionalProperties, resourcesShowResourceDetailsResponsePolicyVersionsInner.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, createdAt, policyText, policySha256, finishedAt, clientIp, id, role, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourcesShowResourceDetailsResponsePolicyVersionsInner {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    policyText: ").append(toIndentedString(policyText)).append("\n");
    sb.append("    policySha256: ").append(toIndentedString(policySha256)).append("\n");
    sb.append("    finishedAt: ").append(toIndentedString(finishedAt)).append("\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
    openapiFields.add("created_at");
    openapiFields.add("policy_text");
    openapiFields.add("policy_sha256");
    openapiFields.add("finished_at");
    openapiFields.add("client_ip");
    openapiFields.add("id");
    openapiFields.add("role");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ResourcesShowResourceDetailsResponsePolicyVersionsInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ResourcesShowResourceDetailsResponsePolicyVersionsInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ResourcesShowResourceDetailsResponsePolicyVersionsInner is not found in the empty JSON string", ResourcesShowResourceDetailsResponsePolicyVersionsInner.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("created_at") != null && !jsonObj.get("created_at").isJsonNull()) && !jsonObj.get("created_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_at").toString()));
      }
      if ((jsonObj.get("policy_text") != null && !jsonObj.get("policy_text").isJsonNull()) && !jsonObj.get("policy_text").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `policy_text` to be a primitive type in the JSON string but got `%s`", jsonObj.get("policy_text").toString()));
      }
      if ((jsonObj.get("policy_sha256") != null && !jsonObj.get("policy_sha256").isJsonNull()) && !jsonObj.get("policy_sha256").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `policy_sha256` to be a primitive type in the JSON string but got `%s`", jsonObj.get("policy_sha256").toString()));
      }
      if ((jsonObj.get("finished_at") != null && !jsonObj.get("finished_at").isJsonNull()) && !jsonObj.get("finished_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `finished_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("finished_at").toString()));
      }
      if ((jsonObj.get("client_ip") != null && !jsonObj.get("client_ip").isJsonNull()) && !jsonObj.get("client_ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `client_ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("client_ip").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull()) && !jsonObj.get("role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ResourcesShowResourceDetailsResponsePolicyVersionsInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ResourcesShowResourceDetailsResponsePolicyVersionsInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ResourcesShowResourceDetailsResponsePolicyVersionsInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ResourcesShowResourceDetailsResponsePolicyVersionsInner.class));

       return (TypeAdapter<T>) new TypeAdapter<ResourcesShowResourceDetailsResponsePolicyVersionsInner>() {
           @Override
           public void write(JsonWriter out, ResourcesShowResourceDetailsResponsePolicyVersionsInner value) throws IOException {
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
           public ResourcesShowResourceDetailsResponsePolicyVersionsInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ResourcesShowResourceDetailsResponsePolicyVersionsInner instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ResourcesShowResourceDetailsResponsePolicyVersionsInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ResourcesShowResourceDetailsResponsePolicyVersionsInner
  * @throws IOException if the JSON string is invalid with respect to ResourcesShowResourceDetailsResponsePolicyVersionsInner
  */
  public static ResourcesShowResourceDetailsResponsePolicyVersionsInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ResourcesShowResourceDetailsResponsePolicyVersionsInner.class);
  }

 /**
  * Convert an instance of ResourcesShowResourceDetailsResponsePolicyVersionsInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

