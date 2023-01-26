val composeUIVersion: String by rootProject.extra
val navVersion: String by rootProject.extra
val retrofitVersion: String by rootProject.extra
val okhttpVersion: String by rootProject.extra
val hiltVersion: String by rootProject.extra
val pagerVersion: String by rootProject.extra
val roomVersion: String by rootProject.extra
val coilVersion: String by rootProject.extra
val navigationHiltVersion: String by rootProject.extra

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
        }
    }
}

dependencies {
    //compose navigation
    implementation("androidx.navigation:navigation-compose:$navVersion")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")

    //okhttp
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")

    //pager
    implementation("com.google.accompanist:accompanist-pager:$pagerVersion")
    implementation("com.google.accompanist:accompanist-pager-indicators:$pagerVersion")

    //dagger hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    //that I can use hiltViewModel() method
    implementation("androidx.hilt:hilt-navigation-compose:$navigationHiltVersion")

    //room
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    //coil
    implementation("io.coil-kt:coil-compose:$coilVersion")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:$composeUIVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUIVersion")
    implementation("androidx.compose.material:material:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeUIVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeUIVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeUIVersion")
}

kapt {
    correctErrorTypes = true
}