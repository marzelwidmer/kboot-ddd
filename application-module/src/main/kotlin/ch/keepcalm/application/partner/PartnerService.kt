package ch.keepcalm.application.partner

import ch.keepcalm.ddd.partner.Partner

interface PartnerService {
    fun createPartner(name: String)
    fun getPartnerById(id: String): Partner?
    fun getAllPartner(): List<Partner>?
}
