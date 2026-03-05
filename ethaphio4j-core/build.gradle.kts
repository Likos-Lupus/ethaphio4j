plugins {
    java
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${property("kotlin-version")}")
}

kotlin {
    jvmToolchain((property("java-version") as String).toInt())
}
