package ch.keepcalm

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

@AnalyzeClasses(packages = ["ch.keepcalm"])
class ArchitectureTest {

    @ArchTest
    val `validate architecture`: ArchRule = noClasses()
        .that().resideInAPackage("..domain..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..application..", "..infrastructure..")
        .because("Domain classes should not depend on classes in the application or infrastructure packages")
        .`as`("Architecture Validation")

    @ArchTest
    val `domain should be framework-free`: ArchRule = noClasses()
        .that().resideInAnyPackage("..domain..")
        .should().dependOnClassesThat().haveNameMatching("org.springframework.*")
        .orShould().dependOnClassesThat().haveNameMatching("javax.persistence.*")
        .because("Domain should be free from any framework implementation")
        .`as`("Domain Framework Dependency Validation")

}
