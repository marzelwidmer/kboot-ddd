package ch.keepcalm.ddd.partner

@JvmInline
value class PartnerId private constructor(val value: String) {
    companion object {
        operator fun invoke(value: String): PartnerId {
            return PartnerId(value)
        }
    }
}
