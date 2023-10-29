package ch.keepcalm.application.partner

import ch.keepcalm.ddd.partner.Partner
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
        val partner = Partner(id = UUID.randomUUID().toString(), name = partnerName)
        partnerRepository.save(partner)
    }

    fun getPartnerById(id: Long): Partner? {
        return partnerRepository.findById(id)
    }
}
