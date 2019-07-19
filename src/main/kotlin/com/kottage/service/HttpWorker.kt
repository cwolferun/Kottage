package com.kottage.service

import com.kottage.model.Site
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import java.util.function.Consumer
import java.util.function.Supplier

@Service
class HttpWorker() {
    fun getStats(site:Site) {
        val webClient = WebClient.create(site.url).get().accept(MediaType.APPLICATION_JSON)
                .exchange().doOnError(handleError)

        val body = webClient.subscribe { response ->
            response.bodyToMono(object : ParameterizedTypeReference<Map<String, String>>() {})
                    .subscribe { body -> body.get("status") }
        }
    }

    val square: Supplier<String> =  Supplier{ -> "Ooo"}
    val handleError = Consumer<Throwable>{ it.printStackTrace() }
}
