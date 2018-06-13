package uk.gov.hmrc.releasesclient

import groovy.transform.Field
import uk.gov.hmrc.releasesclient.docktor.DocktorClient
import uk.gov.hmrc.releasesclient.docktor.domain.ServiceDeploymentState

import javax.inject.Inject

@Field @Inject DocktorClient docktorClient

String getServiceDeploymentState(final String serviceName) {
     final ServiceDeploymentState serviceDeploymentState = docktorClient
            .getServiceDeploymentState(serviceName)
            .blockingGet()
    return serviceDeploymentState
}
