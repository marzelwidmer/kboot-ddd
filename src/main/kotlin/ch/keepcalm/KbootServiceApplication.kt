package ch.keepcalm

import ch.keepcalm.domain.partner.Partner
import ch.keepcalm.domain.partner.PartnerId
import ch.keepcalm.domain.partner.PartnerName
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import java.util.*

@SpringBootApplication
class KbootServiceApplication

fun main(args: Array<String>) {
    runApplication<KbootServiceApplication>(*args) {
        addInitializers(
            beans {
                bean {
                    ApplicationRunner { println("ApplicationRunner ----------------->") }
                    val partner = Partner(id = PartnerId(value = UUID.randomUUID().toString()), PartnerName(value = "John"))
                    println(partner.name)
                }
            }
        )
    }
}


