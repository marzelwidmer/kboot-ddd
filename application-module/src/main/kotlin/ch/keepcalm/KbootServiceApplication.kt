package ch.keepcalm

import ch.keepcalm.demo.partner.Partner
import ch.keepcalm.demo.partner.PartnerName
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class KbootServiceApplication

fun main(args: Array<String>) {
    runApplication<KbootServiceApplication>(*args) {
        addInitializers(
            beans {
                bean {
                    ApplicationRunner { println("ApplicationRunner ----------------->") }
                    val partner = Partner(id = 1L, PartnerName(value = "John"))
                    println(partner.name)
                }
            }
        )
    }
}


