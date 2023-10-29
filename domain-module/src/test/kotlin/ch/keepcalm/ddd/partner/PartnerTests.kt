package ch.keepcalm.ddd.partner

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should not be`
import java.util.*
import kotlin.test.Test

internal class PartnerTests {

    @Test
    fun `should create Partner with valid values`() {
        val partnerId = PartnerId(value = UUID.randomUUID().toString())
        val partnerName = PartnerName(value = "John")

        val result = Partner(id = partnerId, name = partnerName)
        result `should not be` null
        result.name.value `should be` "John"
    }
}
