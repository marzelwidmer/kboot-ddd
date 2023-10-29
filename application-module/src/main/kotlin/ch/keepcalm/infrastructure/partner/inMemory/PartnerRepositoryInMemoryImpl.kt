package ch.keepcalm.infrastructure.partner.inMemory

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository

@Profile("inMemory")
@Repository
class PartnerRepositoryInMemoryImpl : PartnerRepository {
    private val inMemoryStorage = mutableMapOf<String, Partner>()

    override fun findById(id: String): Partner? {
        return inMemoryStorage[id]
    }

    override fun save(partner: Partner) {
        inMemoryStorage[partner.id.value] = partner
    }
}
