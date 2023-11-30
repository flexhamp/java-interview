pluginManagement {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
    }
}

rootProject.name = "questions"
include("spring")
include("spring-boot")
include("java-code")