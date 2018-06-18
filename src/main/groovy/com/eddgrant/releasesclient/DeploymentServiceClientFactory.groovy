package com.eddgrant.releasesclient

import io.micronaut.context.annotation.EachBean
import io.micronaut.context.annotation.Factory

@Factory
class DeploymentServiceClientFactory {

    @EachBean(DeploymentServiceClientConfiguration)
    DeploymentServiceClient deploymentServiceClient(final DeploymentServiceClientConfiguration deploymentServiceConfiguration) {
        return new DeploymentServiceClient(endpoint: deploymentServiceConfiguration.endpoint)
    }
}
