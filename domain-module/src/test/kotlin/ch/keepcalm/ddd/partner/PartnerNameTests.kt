package ch.keepcalm.ddd.partner

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should not be`
import kotlin.test.Test
import java.util.*

internal class PartnerNameTests {

    @Test
    fun `should create PartnerName with valid values`() {
        val validValue = UUID.randomUUID().toString()
        val result = PartnerName(validValue)
        result `should not be` null
        result.value `should be` validValue
    }
}
