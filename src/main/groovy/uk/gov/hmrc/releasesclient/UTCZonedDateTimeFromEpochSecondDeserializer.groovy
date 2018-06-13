package uk.gov.hmrc.releasesclient

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class UTCZonedDateTimeFromEpochSecondDeserializer extends StdDeserializer<ZonedDateTime> {

    protected UTCZonedDateTimeFromEpochSecondDeserializer() {
        super(ZonedDateTime.class)
    }

    @Override
    ZonedDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return Instant.ofEpochSecond(jp.readValueAs(Long.class)).atZone(ZoneId.of("UTC"))
    }

}
