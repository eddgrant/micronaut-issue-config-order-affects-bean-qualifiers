package uk.gov.hmrc.releasesclient

import io.micronaut.function.client.FunctionClient
import io.reactivex.Single

import javax.inject.Named

@FunctionClient
@Named("report-all-service-states")
interface ReportAllServiceStatesFunctionClient {

    String getServiceDeploymentState(final String serviceName)
}
