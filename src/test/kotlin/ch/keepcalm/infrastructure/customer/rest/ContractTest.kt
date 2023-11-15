package ch.keepcalm.infrastructure.customer.rest

import ch.keepcalm.domain.customer.Customer
import ch.keepcalm.domain.customer.CustomerId
import ch.keepcalm.domain.customer.Name
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(
    ids = ["ch.keepcalm:kboot-ddd:0.0.1.RELEASE"],
    repositoryRoot = "git://https://github.com/marzelwidmer/contracts.git",
    stubsMode = StubRunnerProperties.StubsMode.REMOTE,
    generateStubs = true
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContractTest {

    lateinit var customerRestRepository: CustomerRestRepository

    @StubRunnerPort("kboot-ddd") var port: Int? = null

    @BeforeAll
    fun setup() {
        val baseUrl = "http://localhost:$port"
        customerRestRepository = createRestRepository(baseUrl)
    }

    @Test
    fun `should return all customers and posts`() = runTest {
        val customers =
            customerRestRepository
                .findAllCustomers()
                .map {
                    Customer(
                        customerId = CustomerId(it.customerId.toString()),
                        name = Name(it.name)
                    )
                }
                .toList()

        customers.forEach { println(it.name.value) }
    }

    @Test
    fun `chain multiple flows together`() = runTest {
            customerRestRepository.findAllCustomers().map {
                Customer(customerId = CustomerId(it.customerId.toString()), name = Name(it.name))
            }
    }
}
