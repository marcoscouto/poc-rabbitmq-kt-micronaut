package com.marcoscoutozup.consumer

import com.marcoscoutozup.dto.Transaction
import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener
import org.slf4j.LoggerFactory

@RabbitListener
class TransactionConsumer {

    val log = LoggerFactory.getLogger(TransactionConsumer::class.java)

    @Queue("\${topics}")
    fun listener(transaction: Transaction){
        log.info("[CONSUMER] Transaction received: {}", transaction)
    }
}