/**
 * Copyright 2014 Microsoft Open Technologies Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoftopentechnologies.tooling.msservices.helpers.azure.sdk;

import com.microsoft.windowsazure.core.pipeline.filter.ServiceRequestContext;
import com.microsoft.windowsazure.core.pipeline.filter.ServiceRequestFilter;
import com.microsoftopentechnologies.tooling.msservices.helpers.azure.rest.AzureRestAPIHelper;

public class AuthTokenRequestFilter implements ServiceRequestFilter {
    private String accessToken;

    public AuthTokenRequestFilter(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void filter(ServiceRequestContext request) {
        // set access token
        request.setHeader(AzureRestAPIHelper.AUTHORIZATION_HEADER, "Bearer " + accessToken);
    }
}
