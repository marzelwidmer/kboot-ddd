package ch.keepcalm.infrastructure.customer.rest

import kotlinx.coroutines.flow.Flow
import org.springframework.web.service.annotation.GetExchange

fun interface CustomerRestRepository {

    @GetExchange("/customers")
    fun findAllCustomers(): Flow<CustomerResponse>

}



