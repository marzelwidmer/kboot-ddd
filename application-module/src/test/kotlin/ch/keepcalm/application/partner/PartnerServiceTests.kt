package ch.keepcalm.application.partner

import ch.keepcalm.ddd.partner.Partner
import ch.keepcalm.ddd.partner.PartnerId
import ch.keepcalm.ddd.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class PartnerServiceTest : StringSpec({

    val mockPartnerRepository = mockk<PartnerRepository>()
    val partnerService = PartnerServiceImpl(mockPartnerRepository)

    "createPartner should save a partner" {
        val name = "Test Partner"

        every { mockPartnerRepository.save(any()) } returns Unit

        partnerService.createPartner(name)

        // Verify that save was called on mockPartnerRepository with any Partner object
        verify { mockPartnerRepository.save(any()) }
    }

    "getPartnerById should return a partner" {
        val id = "test-id"
        val expectedPartner = Partner(PartnerId(id), PartnerName("Test"))

        every { mockPartnerRepository.findById(id) } returns expectedPartner

        val result = partnerService.getPartnerById(id)

        result shouldBe expectedPartner

        // Verify that findById was called on mockPartnerRepository with the correct id
        verify { mockPartnerRepository.findById(id) }
    }
})
