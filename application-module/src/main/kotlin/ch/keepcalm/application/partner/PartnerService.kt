package ch.keepcalm.application.partner

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.ddd.partner.PartnerId
import ch.keepcalm.ddd.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PartnerService(
    private val partnerRepository: PartnerRepository
) {

    fun createPartner(name: String) {
        val partnerName = PartnerName(name)
        val partnerId = PartnerId(value = UUID.randomUUID().toString())
        println(partnerId.value)
        val partner = Partner(id = partnerId, name = partnerName)
        partnerRepository.save(partner)
    }

    fun getPartnerById(id: String): Partner? {
        return partnerRepository.findById(id)
    }
}
