plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("30.0.1")

    defaultConfig {
        applicationId = "io.github.ovso.sdksearch"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
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
        viewBinding = true
        dataBinding = true
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    implementation(kotlin("stdlib", "1.3.72"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")
    implementation("androidx.activity:activity-ktx:1.1.0")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.7.2")

    // moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.9.2")
    implementation("com.squareup.moshi:moshi-kotlin-codegen:1.9.2")
    implementation("com.squareup.retrofit2:converter-moshi:2.7.2")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.7")

    // dagger
    implementation("com.google.dagger:dagger:2.28.1")
    implementation("com.google.dagger:hilt-android:2.28.1-alpha")
    implementation("com.google.dagger:hilt-android-testing:2.28.1-alpha")
    implementation("androidx.hilt:hilt-common:1.0.0-alpha02")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("com.google.dagger:dagger-compiler:2.28.1")
    kapt("com.google.dagger:hilt-android-compiler:2.28.1-alpha")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.28.1-alpha")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.28.1-alpha")

    // debugging
    implementation("androidx.startup:startup-runtime:1.0.0-alpha02")
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("com.orhanobut:logger:2.2.0")

    // rx
    implementation("io.reactivex.rxjava3:rxjava:3.0.5")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.0")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

}