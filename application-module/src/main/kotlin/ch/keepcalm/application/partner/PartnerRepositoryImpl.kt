package ch.keepcalm.application.partner

import ch.keepcalm.demo.partner.Partner
import ch.keepcalm.demo.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.stereotype.Component

@Component
class PartnerRepositoryImpl : PartnerRepository {
    override fun findById(id: Long): Partner? {
        println("----------> $id")
        return Partner(id = 1, name = PartnerName(value = " John "))
    }

    override fun save(partner: Partner): Partner {
        println("----------> $partner")
        return partner
    }
}
