package com.eddgrant.releasesclient

import io.micronaut.context.annotation.EachProperty


@EachProperty("deploymentservice.client")
class DeploymentServiceClientConfiguration {
    String endpoint
}
