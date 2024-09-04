plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    `maven-publish`
}

android {
    namespace = "com.kobil.kmmasmodule.android"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(projects.shared)
//    implementation(libs.kmmshared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)

    debugImplementation(libs.compose.ui.tooling)

    // 3rd party

    implementation(libs.coil.compose)
}



afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.github.Prathiv07"
                artifactId = "KMMasModule"
                version = "3.7"
                from(components["release"])

//                pom {
//                    groupId = "com.github.Prathiv07"
//                    artifactId = "KMMasModule"
//                    version = "3.4"
//
//                    withXml {
//                        val dependenciesNode = asNode().appendNode("dependencies")
//
//                        dependenciesNode.appendNode("dependency").apply {
//                            appendNode("groupId", "io.coil-kt")
//                            appendNode("artifactId", "coil-compose")
//                            appendNode("version", "2.7.0")
//                            appendNode("scope", "compile")
//                        }
//
//                    }
//                }

            }
        }
    }
}