package com.marcoscoutozup.producer

import com.marcoscoutozup.dto.Transaction
import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@RabbitClient
interface TransactionProducer {

    @Binding("transaction")
    fun send(transaction: Transaction)

}