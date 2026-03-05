plugins {
    java
    id("org.jetbrains.kotlin.jvm")
}

group = "top.likoslupus"
version = property("ethaphio4j-version") as String

repositories {
    mavenCentral()
}

dependencies {

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain((property("java-version") as String).toInt())
}
