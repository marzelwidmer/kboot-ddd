package ch.keepcalm.ddd.partner

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should not be`
import java.util.*
import kotlin.test.Test

internal class PartnerIdTests {

    @Test
    fun `should create PartnerId with valid values`() {
        val validValue = UUID.randomUUID().toString()
        val result = PartnerId(validValue)
        result `should not be` null
        result.value `should be` validValue
    }
}
