package ch.keepcalm.application.partner

import ch.keepcalm.demo.partner.Partner
import ch.keepcalm.demo.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.stereotype.Service

@Service
class PartnerService(private val partnerRepository: PartnerRepository) {

    fun createPartner(name: String): Partner {
        val partnerName = PartnerName(name)
        val partner = Partner(1, partnerName)
        return partnerRepository.save(partner)
    }

    fun getPartnerById(id: Long): Partner? {
        return partnerRepository.findById(id)
    }
}
