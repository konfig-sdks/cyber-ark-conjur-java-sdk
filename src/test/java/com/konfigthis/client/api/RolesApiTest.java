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

import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RolesApi
 */
@Disabled
public class RolesApiTest {

    private static RolesApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new RolesApi(apiClient);
    }

    /**
     * Deletes an existing role membership
     *
     * Deletes an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be removed as a member of the role specified in the endpoint URI. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteRoleMembershipTest() throws ApiException {
        String account = null;
        String kind = null;
        String identifier = null;
        String members = null;
        String member = null;
        String xRequestId = null;
        api.deleteRoleMembership(account, kind, identifier, members, member)
                .xRequestId(xRequestId)
                .execute();
        // TODO: test validations
    }

    /**
     * Get role information
     *
     * Gets detailed information about a specific role, including the role members.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  ##### Listing members  If &#x60;members&#x60; is provided, you will get the members of a role.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give limit a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is true, returns only the number of items in the list.  ##### Text search  If the search parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weights results so that those with matching id or a matching value of an annotation called name appear first, then those with another matching annotation value, and finally those with a matching kind.  ##### Parameter Priority  If Conjur is given any combination of optional parameters, it responds with ONLY results for the parameter of the highest priority.  1. &#x60;graph&#x60; 2. &#x60;all&#x60; 3. &#x60;memberships&#x60; 4. &#x60;members&#x60; 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getRoleInformationTest() throws ApiException {
        String account = null;
        String kind = null;
        String identifier = null;
        String xRequestId = null;
        String all = null;
        String memberships = null;
        String members = null;
        Integer offset = null;
        Integer limit = null;
        Boolean count = null;
        String search = null;
        String graph = null;
        Object response = api.getRoleInformation(account, kind, identifier)
                .xRequestId(xRequestId)
                .all(all)
                .memberships(memberships)
                .members(members)
                .offset(offset)
                .limit(limit)
                .count(count)
                .search(search)
                .graph(graph)
                .execute();
        // TODO: test validations
    }

    /**
     * Update or modify an existing role membership
     *
     * Updates or modifies an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be added as a member of the role specified in the endpoint URI. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateRoleMembershipTest() throws ApiException {
        String account = null;
        String kind = null;
        String identifier = null;
        String members = null;
        String member = null;
        String xRequestId = null;
        api.updateRoleMembership(account, kind, identifier, members, member)
                .xRequestId(xRequestId)
                .execute();
        // TODO: test validations
    }

}
