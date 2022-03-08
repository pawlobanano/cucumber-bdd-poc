# Proof of concept for Cucumber BDD made at spare time

Cucumber is a software tool that supports behavior-driven development (BDD). Central to the Cucumber BDD approach is its ordinary language parser called Gherkin. It allows expected software behaviors to be specified in a logical language that customers can understand. As such, Cucumber allows the execution of feature documentation written in business-facing text. It is often used for testing other software. It runs automated acceptance tests written in a behavior-driven development (BDD) style.
(source: wikipedia)

# Gradle configuration
It needs adjustments in gradle file - example:
```gradle
{
    [...]
    testImplementation 'io.cucumber:cucumber-java:7.2.2'
    testImplementation 'io.cucumber:cucumber-junit:7.2.2'
    testImplementation 'org.seleniumhq.selenium:selenium-java:4.1.1'
    testImplementation 'io.github.bonigarcia:webdrivermanager:5.0.3'
}

configurations {
    cucumberRuntime {
        extendsFrom testImplementation
    }
}

task cucumber() {
    dependsOn assemble, testClasses
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = ['--plugin', 'pretty', '--glue', 'gradle.cucumber', 'src/test/resources']
        }
    }
}
```
