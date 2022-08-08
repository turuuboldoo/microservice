package com.example.postgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@SpringBootApplication
class PostgresApplication

fun main(args: Array<String>) {
    runApplication<PostgresApplication>(*args)
}

@RestController
class HelloController {

    @GetMapping
    fun message(): Map<String, String> {
        return mapOf("message" to "Hello! World")
    }

    @GetMapping("/hello")
    fun hello() = "Hello! There"

    @GetMapping("/redirect")
    fun redirect(httpServletResponse: HttpServletResponse) {
        httpServletResponse.setHeader("redirect", "http://127.0.0.1:34002")
        httpServletResponse.status = 302
    }
}
