rootProject.name = "ethaphio4j"

pluginManagement {
    val kotlinVersion = settings.extra["kotlin-version"] as String

    plugins {
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
    }
}

include("ethaphio4j-api")
include("ethaphio4j-core")
include("ethaphio4j-libgdx")
