package ch.keepcalm.domain.partner

import ch.keepcalm.ddd.partner.Partner

interface PartnerRepository {
    fun findById(id: String): Partner?
    fun save(partner: Partner)
    fun findAll(): List<Partner>?
}
