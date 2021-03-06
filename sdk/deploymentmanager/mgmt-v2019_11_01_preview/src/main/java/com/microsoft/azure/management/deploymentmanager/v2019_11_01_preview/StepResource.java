/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.implementation.DeploymentManagerManager;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.implementation.StepResourceInner;

/**
 * Type representing StepResource.
 */
public interface StepResource extends HasInner<StepResourceInner>, Resource, GroupableResourceCore<DeploymentManagerManager, StepResourceInner>, HasResourceGroup, Refreshable<StepResource>, Updatable<StepResource.Update>, HasManager<DeploymentManagerManager> {
    /**
     * @return the properties value.
     */
    StepProperties properties();

    /**
     * The entirety of the StepResource definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithProperties, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of StepResource definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a StepResource definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the StepResource definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithProperties> {
        }

        /**
         * The stage of the stepresource definition allowing to specify Properties.
         */
        interface WithProperties {
           /**
            * Specifies properties.
            * @param properties The properties that define the step
            * @return the next definition stage
*/
            WithCreate withProperties(StepProperties properties);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<StepResource>, Resource.DefinitionWithTags<WithCreate> {
        }
    }
    /**
     * The template for a StepResource update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<StepResource>, Resource.UpdateWithTags<Update> {
    }

    /**
     * Grouping of StepResource update stages.
     */
    interface UpdateStages {
    }
}
