package ch.keepcalm.infrastructure.partner.redis

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.ddd.partner.PartnerId
import ch.keepcalm.ddd.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository


@Profile("redis")
@Primary
@Repository
class PartnerRepositoryRedisImpl(
    private val partnerRedisRepository: PartnerRedisRepository
) : PartnerRepository {

    override fun findById(id: String): Partner? {
        return partnerRedisRepository.findById(id).map { partnerDto ->
            Partner(id = PartnerId(value = partnerDto.id), name = PartnerName(partnerDto.name))
        }.orElse(null)
    }

    override fun save(partner: Partner) {
        partnerRedisRepository.save(PartnerDTO(id = partner.id.value, name = partner.name.toString()))
    }

}
