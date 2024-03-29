plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ecommerce.shopdaily"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ecommerce.shopdaily"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
            excludes += "mockito-extensions/org.mockito.plugins.MockMaker"
        }
    }
}

dependencies {
    //compose navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    //pager
    implementation("com.google.accompanist:accompanist-pager:0.29.0-alpha")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.29.0-alpha")

    //dagger hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-compiler:2.44.2")

    //that I can use hiltViewModel() method
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    //room
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")

    //coil
    implementation("io.coil-kt:coil-compose:2.2.2")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("androidx.compose.material:material:1.3.1")

    //junit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    //truth
    testImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("com.google.truth:truth:1.1.3")

    //mockito
    testImplementation("org.mockito:mockito-core:3.11.2")
    androidTestImplementation("org.mockito:mockito-android:3.11.2")

    //arch core
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")

    //compose testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.3")
}

kapt {
    correctErrorTypes = true
}