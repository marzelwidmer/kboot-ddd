package ch.keepcalm.ddd.shared.exception

open class BusinessException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
