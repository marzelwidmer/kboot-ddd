package ch.keepcalm.application.partner

import ch.keepcalm.ddd.partner.Partner
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
