package uk.gov.hmrc.releasesclient.docktor.domain

import groovy.transform.Canonical

@Canonical
class HealthcheckConfiguration {
    int retries
    boolean strict
    int startup_retries
    String endpoint
}
