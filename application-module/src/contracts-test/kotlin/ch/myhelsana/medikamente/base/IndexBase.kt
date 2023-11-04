package ch.myhelsana.medikamente.base

import ch.keepcalm.KbootServiceApplication
import io.restassured.RestAssured
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(RestDocumentationExtension::class, SpringExtension::class)
@SpringBootTest(
    classes = [KbootServiceApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = ["server.port=0", "spring.main.banner-mode=off"]
)
abstract class IndexBase {

    @LocalServerPort
    var port = 0

    @BeforeEach
    fun setup(restDocumentation: RestDocumentationContextProvider) {
        RestAssured.baseURI = "http://localhost:$port"
        runBlocking {

        }
    }
}
