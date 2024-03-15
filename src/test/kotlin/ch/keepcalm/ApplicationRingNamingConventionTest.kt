package ch.keepcalm

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.springframework.stereotype.Service


@AnalyzeClasses(packages = ["ch.keepcalm"])
class ApplicationRingNamingConventionTest {

    @ArchTest
    var `application services classes should be suffixed with Service`: ArchRule = classes()
        .that().resideInAPackage("..application..")
        .and().areAnnotatedWith(Service::class.java)
        .should().haveNameMatching(".*Service")
        .orShould().haveNameMatching(".*ServiceImpl")
        .because("Application Services should be suffixed with 'Services'")
        .`as`("Application Service Naming Convention")

}
