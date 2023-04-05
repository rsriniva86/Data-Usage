import com.demo.datausage.build.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = ConfigData.namespace
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.applicationVersionCode
        versionName = ConfigData.applicationVersionName
        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = com.demo.datausage.build.Versions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigData.kotlinCompilerExtensionVersion
    }
}

dependencies {
   // implementation("androidx.compose.material:material:1.1.1")
   // implementation("androidx.compose.foundation:foundation:1.1.1")
    implementation(project(mapOf("path" to ":common:theme")))

    addAndroidDependencies()
    addAndroidUIDependencies()
    addJUnitTestDependencies()
    addAndroidTestDependencies()
    addComposeOfficialDependencies()
    addComposeThirdPartyDependencies()
}