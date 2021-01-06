plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.mocha.spongeplugin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    val sponge = create("org.spongepowered:spongeapi:7.3.0")
    api(sponge)
    kapt(sponge)
    val stdlib = create(kotlin("stdlib-jdk8"))
    api(stdlib)
    shadow(stdlib)
}

tasks {
    jar {
        enabled = false
    }

    build {
        dependsOn(shadowJar)
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

kapt {
    includeCompileClasspath = false
}

artifacts {
    archives(tasks.shadowJar)
}