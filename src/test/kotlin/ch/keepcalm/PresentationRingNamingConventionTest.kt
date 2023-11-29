package ch.keepcalm

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RestController


@AnalyzeClasses(packages = ["ch.keepcalm"])
class PresentationRingNamingConventionTest {

    @ArchTest
    val `classes ending with Controller in api package should not be annotated with @Component`: ArchRule = classes()
        .that().resideInAPackage("..presentation.api..")
        .and().haveSimpleNameEndingWith("Controller")
        .should().notBeAnnotatedWith(Component::class.java)
        .allowEmptyShould(true)
        .because("Classes ending with Controller in api package should not be annotated with @Component")
        .`as`("API Controllers Annotation Convention")

    @ArchTest
    var `application api rest controllers should be annotated with RestController`: ArchRule = classes()
        .that().resideInAPackage("..presentation.api..")
        .and().areAnnotatedWith(RestController::class.java)
        .should().haveNameMatching(".*Controller")
        .andShould().notBeAnnotatedWith(Component::class.java)
        .allowEmptyShould(true)
        .because("Application API rest controllers should be suffixed with 'Controller' and not annotated with @Component")
        .`as`("Application API Rest Controllers Naming Convention")
}
