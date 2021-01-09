plugins {
    kotlin("jvm") version "1.4.20"
}

group = "me.servb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.java-websocket:Java-WebSocket:1.5.1")
}
