package uk.gov.hmrc.releasesclient.docktor.domain

class GetKnownServiceNamesResponse {

    List<ServiceName> knownServices
}

class ServiceName {
    String app
}
