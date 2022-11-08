import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
    id("com.squareup.sqldelight") version "1.5.3"
}

group = "com.airlocksoftware"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.sqldelight:sqlite-driver:1.5.3")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

sqldelight {
  database("MyDatabase") {
    packageName = "com.airlocksoftware"
  }
}
