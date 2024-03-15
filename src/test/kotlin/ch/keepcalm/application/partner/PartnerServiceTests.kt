package ch.keepcalm.application.partner

import ch.keepcalm.domain.partner.Partner
import ch.keepcalm.domain.partner.PartnerId
import ch.keepcalm.domain.partner.PartnerName
import ch.keepcalm.domain.partner.PartnerRepository
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class PartnerServiceTest {

    private val mockPartnerRepository = mockk<PartnerRepository>()
    private val partnerService = PartnerServiceImpl(mockPartnerRepository)

    @Test
    fun `createPartner should save a partner`() {
        val name = "Test Partner"

        every { mockPartnerRepository.save(any()) } returns Unit

        partnerService.createPartner(name)

        // Verify that save was called on mockPartnerRepository with any Partner object
        verify { mockPartnerRepository.save(any()) }
    }

    @Test
    fun `getPartnerById should return a partner`() {
        val id = "test-id"
        val expectedPartner = Partner(PartnerId(id), PartnerName("Test"))

        every { mockPartnerRepository.findById(id) } returns expectedPartner

        val result = partnerService.getPartnerById(id)

        assertEquals(expectedPartner, result)

        // Verify that findById was called on mockPartnerRepository with the correct id
        verify { mockPartnerRepository.findById(id) }
    }

    @Test
    fun `getAllPartner should return all partners`() {
        val expectedPartners = listOf(
            Partner(PartnerId("id1"), PartnerName("Test1")),
            Partner(PartnerId("id2"), PartnerName("Test2"))
        )

        every { mockPartnerRepository.findAll() } returns expectedPartners

        val result = partnerService.getAllPartner()

        assertEquals(expectedPartners, result)

        // Verify that findAll was called on mockPartnerRepository
        verify { mockPartnerRepository.findAll() }
    }
}

