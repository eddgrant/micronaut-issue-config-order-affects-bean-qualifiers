package uk.gov.hmrc.releasesclient.docktor

import io.micronaut.http.annotation.Get
import io.reactivex.Single
import uk.gov.hmrc.releasesclient.docktor.domain.ServiceDeploymentState

import javax.validation.constraints.NotBlank

//@Validated
interface DocktorOperations {

    @Get("/apps/{serviceName}")
    Single<ServiceDeploymentState> getServiceDeploymentState(@NotBlank final String serviceName)
}
