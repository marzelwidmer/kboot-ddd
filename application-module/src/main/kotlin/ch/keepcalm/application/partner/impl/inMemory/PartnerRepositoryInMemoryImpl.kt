package ch.keepcalm.application.partner.impl.inMemory

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository

@Profile("inMemory")
@Repository
class PartnerServiceInMemoryImpl(private val partnerRepository: PartnerRepository) {
    fun getPartner(id: Long): Partner? {
        return partnerRepository.findById(id)
    }

    fun createPartner(partner: Partner) {
        partnerRepository.save(partner)
    }
}

//@Component
//class PartnerRepositoryImpl : PartnerRepository {
//    override fun findById(id: Long): Partner? {
//        println("----------> $id")
//        return Partner(id = 1, name = PartnerName(value = " John "))
//    }
//
//    override fun save(partner: Partner) {
//        println("----------> $partner")
//    }
//}
