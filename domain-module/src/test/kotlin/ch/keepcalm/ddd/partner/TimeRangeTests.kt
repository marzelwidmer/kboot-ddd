package ch.keepcalm.ddd.partner

import org.amshove.kluent.`should not be`
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import kotlin.test.Test

internal class TimeRangeTests {

    @Test
    fun `should create TimeRange with valid values`() {
        val result = TimeRange(LocalDate.now(), LocalDate.now())
        result `should not be` null
    }

    @Test
    fun `TimeRange end time do not match business rules`() {
        assertThrows<TimeRangeNotValidException> {
            TimeRange(LocalDate.now(), LocalDate.now().plusYears(6))
        }
    }

    @Test
    fun `TimeRange begin time do not match business rules`() {
        assertThrows<TimeRangeNotValidException> {
            TimeRange(LocalDate.now().plusDays(1), LocalDate.now())
        }
    }
}
