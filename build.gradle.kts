import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

group = ""
version = "1.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://repo.aikar.co/nexus/content/groups/aikar/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")

    compileOnly(group = "org.spigotmc", name = "spigot-api", version = "1.17-R0.1-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "16"
        javaParameters = true
        freeCompilerArgs = listOf(
            "-Xopt-in=kotlin.ExperimentalStdlibApi"
        )
    }
}
