package com.kariksiz.kafkaexample.consumer

import com.kariksiz.kafkaexample.config.EXAMPLE_TOPIC_NAME
import com.kariksiz.kafkaexample.config.EXAMPLE_TOPIC_NAME_THREE
import com.kariksiz.kafkaexample.config.EXAMPLE_TOPIC_NAME_TWO
import com.kariksiz.kafkaexample.config.GROUP_ID
import com.kariksiz.kafkaexample.dto.ExampleDto
import com.kariksiz.kafkaexample.dto.UserDto
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ExampleConsumer {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(topics = [EXAMPLE_TOPIC_NAME], groupId = GROUP_ID)
    fun firstListener(message: String) {
        logger.info("Message received: [$message]")
    }

    @KafkaListener(topics = [EXAMPLE_TOPIC_NAME_TWO], groupId = GROUP_ID)
    fun secondListener(message: ExampleDto) {
        logger.info("Message received: [$message]")
    }

    @KafkaListener(topics = [EXAMPLE_TOPIC_NAME_THREE], groupId = GROUP_ID)
    fun thirdListener(message: UserDto) {
        logger.info("Message received: [$message]")
    }
}