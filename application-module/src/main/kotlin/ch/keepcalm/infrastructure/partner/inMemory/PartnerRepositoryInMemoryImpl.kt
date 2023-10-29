package ch.keepcalm.infrastructure.partner.inMemory

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.ddd.partner.PartnerId
import ch.keepcalm.ddd.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.stereotype.Repository

@Repository
class PartnerRepositoryInMemoryImpl : PartnerRepository {
    private val inMemoryStorage = mutableMapOf<Long, Partner>()

    override fun findById(id: Long): Partner? {
        return inMemoryStorage[id]
    }

    override fun save(partner: Partner) {
        inMemoryStorage[partner.id.value.toLong()] = partner
    }
}
