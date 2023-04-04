import com.demo.datausage.build.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = com.demo.datausage.build.ConfigData.namespace
    compileSdk = com.demo.datausage.build.ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = com.demo.datausage.build.ConfigData.applicationId
        minSdk = com.demo.datausage.build.ConfigData.minSdkVersion
        targetSdk = com.demo.datausage.build.ConfigData.targetSdkVersion
        versionCode = com.demo.datausage.build.ConfigData.applicationVersionCode
        versionName = com.demo.datausage.build.ConfigData.applicationVersionName
        testInstrumentationRunner = com.demo.datausage.build.ConfigData.testInstrumentationRunner
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
}

dependencies {
    addAndroidDependencies()
    addAndroidUIDependencies()
    addJUnitTestDependencies()
    addAndroidTestDependencies()
}