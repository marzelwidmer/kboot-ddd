package ch.keepcalm.application.partner

import ch.keepcalm.domain.partner.Partner


interface PartnerService {
    fun createPartner(name: String)
    fun getPartnerById(id: String): Partner?
    fun getAllPartner(): List<Partner>?
}
