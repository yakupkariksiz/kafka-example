package com.kariksiz.kafkaexample.controller

import com.kariksiz.kafkaexample.dto.ExampleDto
import com.kariksiz.kafkaexample.dto.UserDto
import com.kariksiz.kafkaexample.producer.ExampleJsonProducer
import com.kariksiz.kafkaexample.producer.ExampleStringProducer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ExampleController(
    private val exampleStringProducer: ExampleStringProducer,
    private val exampleJsonProducer: ExampleJsonProducer
) {

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendTestMessage(@RequestBody requestBody: RequestBodyDto) {
        exampleStringProducer.sendStringMessage(message = requestBody.message)
        exampleJsonProducer.sendExampleDtoMessage(dto = ExampleDto(requestBody.message))
        exampleJsonProducer.sendUserDtoMessage(
            dto = UserDto(
                id = Random.nextLong(0, 100),
                name = requestBody.message
            )
        )
    }

    @GetMapping("/hello/{message}")
    @ResponseStatus(HttpStatus.OK)
    fun hello(@PathVariable message: String): String {
        return "Hello $message";
    }

    data class RequestBodyDto(val message: String)
}