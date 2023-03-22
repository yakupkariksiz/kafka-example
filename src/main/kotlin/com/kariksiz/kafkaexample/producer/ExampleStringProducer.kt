package com.kariksiz.kafkaexample.producer

import com.kariksiz.kafkaexample.config.EXAMPLE_TOPIC_NAME
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ExampleStringProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendStringMessage(message: String) {
        kafkaTemplate.send(EXAMPLE_TOPIC_NAME, message)
    }

}