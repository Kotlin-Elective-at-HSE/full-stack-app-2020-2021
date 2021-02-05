plugins {
    kotlin("js")
}

group = "me.servb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
    }
}

dependencies {
    implementation(project(":protocol"))
}
