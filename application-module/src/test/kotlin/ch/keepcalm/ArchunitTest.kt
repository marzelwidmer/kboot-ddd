package ch.keepcalm

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchitectureTest {

    @Test
    fun `validate architecture`() {
        val importedClasses: JavaClasses = ClassFileImporter().importPackages("ch.keepcalm")

        val rule: ArchRule = noClasses()
            .that().resideInAPackage("..domain..")
            .should().dependOnClassesThat()
            .resideInAnyPackage("..application..", "..infrastructure..")

        rule.check(importedClasses)
    }

//
//    @Test
//    fun `domain should not depend on infrastructure`() {
//        val importedClasses: JavaClasses = ClassFileImporter().importPackages("ch.keepcalm")
//
//        val rule: ArchRule = noClasses()
//            .that().resideInAPackage("..domain..")
//            .should().dependOnClassesThat()
//            .resideInAPackage("..infrastructure..")
//
//        rule.check(importedClasses)
//    }

}
