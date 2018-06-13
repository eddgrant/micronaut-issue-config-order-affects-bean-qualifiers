import io.micronaut.runtime.Micronaut
import uk.gov.hmrc.releasesclient.ReportAllServiceStatesFunction

class Application {
    static void main(String[] args) {
        Micronaut.run(ReportAllServiceStatesFunction.class)
    }
}
