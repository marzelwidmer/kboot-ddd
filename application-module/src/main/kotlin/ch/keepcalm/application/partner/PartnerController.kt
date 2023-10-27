package ch.keepcalm.application.partner

import ch.keepcalm.demo.partner.Partner
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partners")
class PartnerController(private val partnerService: PartnerService) {
    @PostMapping
    fun createPartner(@RequestBody name: String): Partner {
        return partnerService.createPartner(name)
    }

    @GetMapping("/{id}")
    fun getPartner(@PathVariable id: Long): Partner? {
        return partnerService.getPartnerById(id)
    }
}
