package com.marcoscoutozup.producer

import com.marcoscoutozup.dto.Transaction
import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDateTime
import java.util.*
import javax.inject.Singleton
import kotlin.random.asKotlinRandom

@Singleton
class Producer(val producer: TransactionProducer) {

    val log = LoggerFactory.getLogger(Producer::class.java)

    @Scheduled(fixedRate = "\${rmq.config.timer}")
    fun sender(){
        val uuid = UUID.randomUUID().toString()
        val value = BigDecimal(Random()
                .asKotlinRandom()
                .nextDouble(10.0, 1000.0))
                .setScale(2, RoundingMode.CEILING)

        val transaction = Transaction(uuid, value, LocalDateTime.now())
        log.info("[PRODUCER] Sending transaction = {}", transaction)
        producer.send(transaction)
    }

}