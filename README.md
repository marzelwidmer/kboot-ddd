# kboot-ddd with ArchUnit

```
SPRING_PROFILES_ACTIVE=standalone mvn clean spring-boot:run -pl application-module
```

- **domain-module**: This module contains your domain models, which are `Partner` and `PartnerName` in this case.

- **application-module**: This module is divided into three main parts:
    - **domain**: Contains the `PartnerRepository` interface which defines the operations that can be performed on `Partner`.
    - **application**: Contains the application-specific logic, which includes `PartnerController`, `PartnerService`, and `PartnerRepositoryImpl`. The `PartnerRepositoryImpl` is an implementation of the `PartnerRepository` interface.
    - **infrastructure**: While it’s currently empty, this is where you’d typically put code that interacts with external systems like databases or web services.

- **etc/rest-client**: Contains an HTTP request file, which is likely used for testing your API endpoints.



## ArchUnit
Enable the following **domain** class  `src/main/kotlin/ch/keepcalm/domain/SomeDomainClassThatBrakeArchRules.kt`
to break the `OnionArchitekure` **rule**.
