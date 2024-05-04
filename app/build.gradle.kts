plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.app.depandancyinjectionwithapicall"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.depandancyinjectionwithapicall"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


        compileOptions {
            sourceCompatibility =  JavaVersion.VERSION_1_8
            targetCompatibility  = JavaVersion.VERSION_1_8
        }


    buildFeatures{
        viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // For hilt Implementation
    implementation ("com.google.dagger:hilt-android:2.46.1")
    kapt ("com.google.dagger:hilt-compiler:2.46.1")

    // For instrumentation tests
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.46.1")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.46.1")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.46.1")
    kaptTest ("com.google.dagger:hilt-compiler:2.46.1")

    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    implementation ("com.github.bumptech.glide:compiler:4.13.2")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.rollbar:rollbar-android:1.10.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.2.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")

}

kapt {
    correctErrorTypes = true
}

