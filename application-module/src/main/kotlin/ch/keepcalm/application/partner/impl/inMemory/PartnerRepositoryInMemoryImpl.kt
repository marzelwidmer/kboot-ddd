package ch.keepcalm.application.partner.impl.inMemory

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository

@Profile("inMemory")
@Repository
class PartnerServiceInMemoryImpl(private val partnerRepository: PartnerRepository) {
    fun getPartner(id: String): Partner? {
        return partnerRepository.findById(id)
    }

    fun createPartner(partner: Partner) {
        partnerRepository.save(partner)
    }
}
