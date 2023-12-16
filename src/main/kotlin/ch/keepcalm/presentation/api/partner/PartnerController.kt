package ch.keepcalm.presentation.api.partner

import ch.keepcalm.application.partner.PartnerService
import ch.keepcalm.domain.partner.Partner
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partners")
class PartnerController(private val partnerService: PartnerService) {

    @PostMapping
    fun createPartner(@RequestBody name: String) {
        partnerService.createPartner(name)
    }

    @GetMapping("/{id}")
    fun getPartner(@PathVariable id: String): Partner? {
        return partnerService.getPartnerById(id)
    }

    @GetMapping("")
    fun getPartners(): List<Partner>? {
        return partnerService.getAllPartner()
    }
}
