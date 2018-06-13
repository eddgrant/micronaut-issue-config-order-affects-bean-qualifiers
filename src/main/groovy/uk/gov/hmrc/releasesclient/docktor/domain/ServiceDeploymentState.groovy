package uk.gov.hmrc.releasesclient.docktor.domain

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import groovy.transform.Canonical
import uk.gov.hmrc.releasesclient.UTCZonedDateTimeFromEpochSecondDeserializer

import java.time.ZonedDateTime

@Canonical
class ServiceDeploymentState {

    HealthcheckConfiguration healthcheck

    String app

    int attemptCount

    @JsonProperty("state_name")
    String stateInfo

    boolean noop

    String instances

    @JsonProperty("slug_uri")
    String slugUri

    int slots

    @JsonProperty("state_changed_at")
    @JsonDeserialize(using = UTCZonedDateTimeFromEpochSecondDeserializer)
    ZonedDateTime stateChangedAt

    @JsonProperty("last_healthy_at")
    @JsonDeserialize(using = UTCZonedDateTimeFromEpochSecondDeserializer)
    ZonedDateTime lastHealthyAt

    String state

    @JsonProperty("slug_runner_version")
    String slugRunnerVersion
}
