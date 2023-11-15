package ch.keepcalm.ddd.customer

data class Customer(val customerId: CustomerId, val name: Name)

@JvmInline
value class CustomerId(val value: String) {
    init {
        require(value.isNotEmpty()) { "CustomerId must be non-empty" }
    }
//    override fun toString() = value
}

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotEmpty()) { "Name must be non-empty" }
    }

//    override fun toString() = value
}



