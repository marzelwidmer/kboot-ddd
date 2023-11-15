package ch.keepcalm.domain.shared.exception

open class BusinessException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
