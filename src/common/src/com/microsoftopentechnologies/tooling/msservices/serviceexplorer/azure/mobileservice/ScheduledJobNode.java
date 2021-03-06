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
package com.microsoftopentechnologies.tooling.msservices.serviceexplorer.azure.mobileservice;

import com.microsoftopentechnologies.tooling.msservices.helpers.azure.AzureCmdException;
import com.microsoftopentechnologies.tooling.msservices.helpers.azure.AzureManagerImpl;
import com.microsoftopentechnologies.tooling.msservices.model.ms.Job;
import com.microsoftopentechnologies.tooling.msservices.model.ms.MobileService;
import com.microsoftopentechnologies.tooling.msservices.serviceexplorer.Node;
import com.microsoftopentechnologies.tooling.msservices.serviceexplorer.NodeActionEvent;

public class ScheduledJobNode extends ScriptNodeBase {
    public static final String ICON_PATH = "job.png";
    protected Job job;

    public ScheduledJobNode(Node parent, Job job) {
        super(job.getName(), job.getName(), parent, ICON_PATH);
        this.job = job;
    }

    @Override
    protected void onNodeClick(NodeActionEvent event) {
        onNodeClickInternal(job);
    }

    @Override
    protected void downloadScript(MobileService mobileService, String scriptName, String localFilePath) throws AzureCmdException {
        AzureManagerImpl.getManager().downloadJobScript(
                mobileService.getSubcriptionId(),
                mobileService.getName(),
                scriptName,
                localFilePath);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
