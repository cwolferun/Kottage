package com.kottage.config

import com.kottage.model.Response
import com.kottage.model.Site
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.annotation.PostConstruct

@Configuration
class AppBeans {

    @Value("#{\${valuesMap}}")
    lateinit var things: Map<String, List<String>>

    @PostConstruct
    fun dothing() = println(things["app-cat"])

    @Primary
    @Bean(name = ["List"])
    fun getList() {
        things.map { }
    }

    val makeSite = { name: String, urls: List<String> -> Site(name, cookResp(urls)) }

    fun cookResp(urls: List<String>): Map<String, Response> = urls.map { it to Response() }.toMap()

}