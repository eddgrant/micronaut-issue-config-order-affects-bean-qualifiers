package com.eddgrant.releasesclient

import io.micronaut.context.ApplicationContext
import io.micronaut.inject.qualifiers.Qualifiers
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification

class DeploymentServiceClientSpec extends Specification {

    void "it should create the correct number of deployment service clients from the configuration"() {
        given:
        final EmbeddedServer server = ApplicationContext.run(EmbeddedServer)
        final ApplicationContext applicationContext = server.getApplicationContext()

        when:
        final Set<DeploymentServiceClient> deploymentServices = applicationContext.getBeansOfType(DeploymentServiceClient)

        then:
        deploymentServices.size() == 5

        cleanup:
        if(server != null) server.stop()
    }

    void "it should configure each of the deployment service client instances with the right endpoint"() {
        given:
        final EmbeddedServer server = ApplicationContext.run(EmbeddedServer)
        final ApplicationContext applicationContext = server.getApplicationContext()

        when:
        final DeploymentServiceClient publicDeploymentService = applicationContext.getBean(DeploymentServiceClient, Qualifiers.byName("public"))
        final DeploymentServiceClient publicMonolithDeploymentService = applicationContext.getBean(DeploymentServiceClient, Qualifiers.byName("public-monolith"))
        final DeploymentServiceClient publicRateDeploymentService = applicationContext.getBean(DeploymentServiceClient, Qualifiers.byName("public-rate"))
        final DeploymentServiceClient protectedDeploymentService = applicationContext.getBean(DeploymentServiceClient, Qualifiers.byName("protected"))
        final DeploymentServiceClient protectedRateDeploymentService = applicationContext.getBean(DeploymentServiceClient, Qualifiers.byName("protected-rate"))

        then:
        publicDeploymentService.endpoint == "https://deployments-service.public.my-internal-domain/"
        publicMonolithDeploymentService.endpoint == "https://deployments-service.public-monolith.my-internal-domain/"
        publicRateDeploymentService.endpoint == "https://deployments-service.public-rate.my-internal-domain/"
        protectedDeploymentService.endpoint == "https://deployments-service.protected.my-internal-domain/"
        protectedRateDeploymentService.endpoint == "https://deployments-service.protected-rate.my-internal-domain/"

        cleanup:
        if(server != null) server.stop()
    }
}
