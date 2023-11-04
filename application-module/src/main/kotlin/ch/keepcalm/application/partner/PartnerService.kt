package ch.keepcalm.application.partner

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.ddd.partner.PartnerId
import ch.keepcalm.ddd.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import ch.keepcalm.infrastructure.logging.logger
import org.springframework.stereotype.Service
import java.util.*

interface PartnerService {
    fun createPartner(name: String)
    fun getPartnerById(id: String): Partner?
    fun getAllPartner(): List<Partner>?
}

@Service
class PartnerServiceImpl(
    private val partnerRepository: PartnerRepository
) : PartnerService{

    override fun createPartner(name: String) {
        val partnerName = PartnerName(name)
        val partnerId = PartnerId(value = UUID.randomUUID().toString())

        logger.info {
            "ID ----------> ${partnerId.value}"
        }

        val partner = Partner(id = partnerId, name = partnerName)
        partnerRepository.save(partner)
    }

    override  fun getPartnerById(id: String): Partner? {
        return partnerRepository.findById(id)
    }

    override fun getAllPartner(): List<Partner>? {
       return partnerRepository.findAll()
    }
}

