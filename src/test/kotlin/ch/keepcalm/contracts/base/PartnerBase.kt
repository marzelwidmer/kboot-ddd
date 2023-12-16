package ch.keepcalm.contracts.base

import ch.keepcalm.presentation.api.partner.PartnerController
import ch.keepcalm.application.partner.PartnerService
import ch.keepcalm.domain.partner.Partner
import ch.keepcalm.domain.partner.PartnerId
import ch.keepcalm.domain.partner.PartnerName

import io.restassured.module.webtestclient.RestAssuredWebTestClient
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito

abstract class PartnerBase {

    @BeforeEach
    fun setup() {
        val partnerId = PartnerId(value = "1")
        val partnerName = PartnerName(value = "John")
        val partner = Partner(id = partnerId, name = partnerName)

        // Create a mock of PartnerService
        val partnerService = Mockito.mock(PartnerService::class.java)

        // Define the behavior of the mock
        Mockito.`when`(partnerService.getPartnerById("1")).thenReturn(partner)

        // Define the behavior of the mock
        Mockito.`when`(partnerService.getAllPartner()).thenReturn(listOf(partner))

        RestAssuredWebTestClient.standaloneSetup(PartnerController(partnerService))
    }

}
