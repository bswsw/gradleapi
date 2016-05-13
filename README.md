Spring4 + Spring Data + JPA + Gradle Restful API Sample 
=====================

##Development Environment
* Macbook Pro Retina
* STS
* Spring 4
* Spring Data
* JPA
* MySql 5.5.42


##Using Dependency
```
def version = [
    spring: '4.1.6.RELEASE',
    servletAPI: '3.1.0',
    commonsCollections: '3.2.1',
    junit: '4.12',
    slf4j: '1.7.12'
]

dependencies {
    providedCompile "javax.servlet:javax.servlet-api:${version.servletAPI}"
    
    compile "org.springframework:spring-webmvc:${version.spring}"
    compile 'org.springframework.data:spring-data-jpa:1.10.1.RELEASE'
    
    compile 'javax.validation:validation-api:1.1.0.Final'
    
    compile "org.slf4j:slf4j-api:${version.slf4j}"
    
    compile 'com.fasterxml.jackson.core:jackson-core:2.7.4'
    compile 'com.fasterxml.jackson.core:jackson-databind:2.7.4'
    
    compile 'commons-dbcp:commons-dbcp:1.4'
    compile 'mysql:mysql-connector-java:5.1.31'
    compile 'org.hibernate:hibernate-entitymanager:5.1.0.Final'
    
    compile group: 'commons-collections', name: 'commons-collections', version: '3.2'
    testCompile group: 'junit', name: 'junit', version: "${version.junit}"
}
```
