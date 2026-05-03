plugins {
    id("java")
}

group = "com.josebertojunit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("net.datafaker:datafaker:2.5.4")

}

tasks.test {
    useJUnitPlatform()
}