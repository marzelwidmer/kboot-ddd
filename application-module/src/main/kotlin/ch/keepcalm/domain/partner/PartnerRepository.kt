package ch.keepcalm.domain.partner

import ch.keepcalm.ddd.partner.Partner

interface PartnerRepository {
    fun findById(id: Long): Partner?
    fun save(partner: Partner)
}
