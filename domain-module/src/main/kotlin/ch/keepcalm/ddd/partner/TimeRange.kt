package ch.keepcalm.ddd.partner

import ch.keepcalm.ddd.shared.exception.BusinessException
import java.time.LocalDate

class TimeRange private constructor(val beginTime: LocalDate, val endTime: LocalDate) {

    companion object {
        operator fun invoke(beginTime: LocalDate, endTime: LocalDate): TimeRange {
            check(!beginTime.isAfter(endTime)) { throw TimeRangeNotValidException(beginTime, endTime) }
            check(!endTime.minusYears(5L).isAfter(beginTime)) { throw TimeRangeNotValidException(beginTime, endTime) }
            check(!beginTime.isBefore(LocalDate.now().minusYears(5L).withDayOfYear(1))) { throw TimeRangeNotValidException(beginTime, endTime) }
            return TimeRange(beginTime, endTime)
        }
    }
}

class TimeRangeNotValidException(beginTime: LocalDate, endTime: LocalDate) : BusinessException("TimeRange [$beginTime,$endTime] doesn't match business case")

