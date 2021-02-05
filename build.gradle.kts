plugins {
    kotlin("multiplatform") version "1.4.20" apply false
    kotlin("jvm") version "1.4.20" apply false
    kotlin("js") version "1.4.20" apply false
    kotlin("plugin.serialization") version "1.4.20" apply false
}

group = "me.servb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
