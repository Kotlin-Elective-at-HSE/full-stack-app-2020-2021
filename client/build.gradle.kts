plugins {
    kotlin("js") version "1.4.20"
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
