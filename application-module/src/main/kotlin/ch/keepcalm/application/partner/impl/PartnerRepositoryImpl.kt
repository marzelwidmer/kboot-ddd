package ch.keepcalm.application.partner.impl

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.ddd.partner.PartnerId
import ch.keepcalm.ddd.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import ch.keepcalm.infrastructure.partner.PartnerDTO
import ch.keepcalm.infrastructure.partner.PartnerRedisRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
//
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

@Repository
class PartnerRepositoryRedisImpl(
    private val partnerRedisRepository: PartnerRedisRepository
) : PartnerRepository {

    override fun findById(id: Long): Partner? {
        return partnerRedisRepository.findById(id.toString()).map { partnerDto ->
            Partner(id = PartnerId(value = partnerDto.id), name = PartnerName(partnerDto.name))
        }.orElse(null)
    }

    override fun save(partner: Partner) {
        partnerRedisRepository.save(PartnerDTO(id = partner.id.value, name = partner.name.toString()))
    }

}
