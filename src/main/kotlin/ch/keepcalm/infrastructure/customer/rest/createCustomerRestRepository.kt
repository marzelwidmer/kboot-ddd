package ch.keepcalm.infrastructure.customer.rest

import ch.keepcalm.infrastructure.logging.RequestResponseLogger.logRequest
import ch.keepcalm.infrastructure.logging.RequestResponseLogger.logResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

fun createRestRepository(baseUrl: String = "https://jsonplaceholder.typicode.com"): CustomerRestRepository {
    val client = WebClient.builder()
        .baseUrl(baseUrl)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .filter(logRequest())
        .filter(logResponse())
        .build()
    return HttpServiceProxyFactory
        .builderFor(WebClientAdapter.create(client))
        .build().createClient()
}
