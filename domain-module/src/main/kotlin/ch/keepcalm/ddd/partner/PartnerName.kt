package ch.keepcalm.ddd.partner

@JvmInline
value class PartnerName private constructor(val value: String) {
    companion object {
        operator fun invoke(value: String): PartnerName {
            return PartnerName(value)
        }
    }
}
