package ch.keepcalm.infrastructure.logging

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import reactor.core.publisher.Mono

object RequestResponseLogger {

    fun logRequest(): ExchangeFilterFunction = ExchangeFilterFunction.ofRequestProcessor { clientRequest: ClientRequest ->
        logger.debug {
            "Request ${clientRequest.headers()} ${clientRequest.method()} ${clientRequest.url()}"
        }
        Mono.just(clientRequest)
    }

    fun logResponse(): ExchangeFilterFunction = ExchangeFilterFunction.ofResponseProcessor { clientResponse: ClientResponse ->
        logStatus(clientResponse)
        logHeaders(clientResponse)
        Mono.just(clientResponse)
    }

    private fun logStatus(response: ClientResponse) {
        val status: HttpStatusCode = response.statusCode()
        logger.debug {
            "Returned status code ${status.value()} (${(status as HttpStatus).reasonPhrase})"
        }
    }

    private fun logHeaders(response: ClientResponse) {
        response.headers().asHttpHeaders().forEach { name: String?, values: List<String?> ->
            logger.debug {
                "${name}=${values}"
            }
        }
    }
}
