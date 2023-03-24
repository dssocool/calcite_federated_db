plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    implementation("org.apache.calcite:calcite-core:1.34.0")
    implementation("org.apache.calcite:calcite-server:1.34.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}