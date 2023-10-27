package ch.keepcalm.domain.partner

import ch.keepcalm.demo.partner.Partner

interface PartnerRepository {
    fun findById(id: Long): Partner?
    fun save(partner: Partner): Partner
}
