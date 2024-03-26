package com.konfigthis.client;

import com.konfigthis.client.api.AuthenticationApi;
import com.konfigthis.client.api.CertificateAuthorityApi;
import com.konfigthis.client.api.HostFactoryApi;
import com.konfigthis.client.api.PoliciesApi;
import com.konfigthis.client.api.PublicKeysApi;
import com.konfigthis.client.api.ResourcesApi;
import com.konfigthis.client.api.RolesApi;
import com.konfigthis.client.api.SecretsApi;
import com.konfigthis.client.api.StatusApi;

public class CyberArkConjur {
    private ApiClient apiClient;
    public final AuthenticationApi authentication;
    public final CertificateAuthorityApi certificateAuthority;
    public final HostFactoryApi hostFactory;
    public final PoliciesApi policies;
    public final PublicKeysApi publicKeys;
    public final ResourcesApi resources;
    public final RolesApi roles;
    public final SecretsApi secrets;
    public final StatusApi status;

    public CyberArkConjur() {
        this(null);
    }

    public CyberArkConjur(Configuration configuration) {
        this.apiClient = new ApiClient(null, configuration);
        this.authentication = new AuthenticationApi(this.apiClient);
        this.certificateAuthority = new CertificateAuthorityApi(this.apiClient);
        this.hostFactory = new HostFactoryApi(this.apiClient);
        this.policies = new PoliciesApi(this.apiClient);
        this.publicKeys = new PublicKeysApi(this.apiClient);
        this.resources = new ResourcesApi(this.apiClient);
        this.roles = new RolesApi(this.apiClient);
        this.secrets = new SecretsApi(this.apiClient);
        this.status = new StatusApi(this.apiClient);
    }

}
