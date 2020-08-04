plugins {
    kotlin("multiplatform") version "1.4.0-rc"
}
group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    maven {
        url = uri("https://teamcity.jetbrains.com/guestAuth/app/rest/builds/buildType:(id:KotlinTools_KotlinxDatetime_Build_All),branch:(name:master,default:any)/artifacts/content/maven")
    }
}

kotlin {

    jvm()

    macosX64("macosX64")
    iosX64("iosX64")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.0.1-SNAPSHOT")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
        }
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        macosX64().compilations["main"].defaultSourceSet {
            dependsOn(nativeMain)
        }
        iosX64().compilations["main"].defaultSourceSet {
            dependsOn(nativeMain)
        }
    }
}