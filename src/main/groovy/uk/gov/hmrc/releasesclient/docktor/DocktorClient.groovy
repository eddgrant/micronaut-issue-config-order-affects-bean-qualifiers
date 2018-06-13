package uk.gov.hmrc.releasesclient.docktor

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.Client
import io.reactivex.Single
import uk.gov.hmrc.releasesclient.docktor.domain.ServiceDeploymentState

import javax.validation.constraints.NotBlank

@Client("http://docktor.service:8080")
@Headers([@Header(name="Host", value="docktor.service"),
          @Header(name="Accept", value="application/json")])
interface DocktorClient {

    @Get("/apps/")
    List<String> getKnownServiceNames()

    @Get("/apps/{serviceName}")
    Single<ServiceDeploymentState> getServiceDeploymentState(final @NotBlank String serviceName)
}
