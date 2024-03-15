package ch.keepcalm.infrastructure.partner.inMemory

import ch.keepcalm.domain.partner.Partner
import ch.keepcalm.domain.partner.PartnerRepository
import org.springframework.stereotype.Repository

//@Profile("inMemory")
@Repository
class PartnerRepositoryInMemoryImpl : PartnerRepository {
    private val inMemoryStorage = mutableMapOf<String, Partner>()

    override fun findById(id: String): Partner? {
        return inMemoryStorage[id]
    }

    override fun save(partner: Partner) {
        inMemoryStorage[partner.id.value] = partner
    }

    override fun findAll(): List<Partner>? {
        return inMemoryStorage.values.toList()
    }
}
