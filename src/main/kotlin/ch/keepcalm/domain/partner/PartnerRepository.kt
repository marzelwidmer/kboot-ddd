package ch.keepcalm.domain.partner


interface PartnerRepository {
    fun findById(id: String): Partner?
    fun save(partner: Partner)
    fun findAll(): List<Partner>?
}
