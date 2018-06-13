package uk.gov.hmrc.releasesclient

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification

class ReportAllServiceStatesHandlerFunctionSpec extends Specification {

    void "test report all service states handler function"() {
        given:
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer)
        ReportAllServiceStatesFunctionClient client = server.getApplicationContext().getBean(ReportAllServiceStatesFunctionClient)

        expect:
        client.getServiceDeploymentState("captain") == "hello-world"

        cleanup:
        if(server != null) server.stop()
    }
}
