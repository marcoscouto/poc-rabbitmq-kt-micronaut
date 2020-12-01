package com.marcoscoutozup.producer

import com.marcoscoutozup.dto.Transaction
import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@RabbitClient
interface TransactionProducer {

    @Binding("\${rmq.config.topics}")
    fun send(transaction: Transaction)

}