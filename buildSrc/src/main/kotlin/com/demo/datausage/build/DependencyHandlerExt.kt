package com.demo.datausage.build

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addAndroidDependencies() {
    androidDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addAndroidUIDependencies() {
    androidUIDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addJUnitTestDependencies() {
    junitTestDependencies.forEach {
        add("testImplementation", it)
    }
}



fun DependencyHandler.addAndroidTestDependencies() {
    androidTestDependencies.forEach {
        add("implementation", it)
    }
    addMokitoAndroidTest()
}
private fun DependencyHandler.addMokitoAndroidTest(){
    mokitoAndroidTestDependencies.forEach{
        add("androidTestImplementation", it)
    }
}

fun DependencyHandler.addMockWebServerAndroidTestDependencies(){
    mockWebServerAndroidTestDependencies.forEach{
        add("androidTestImplementation", it)
    }
}


fun DependencyHandler.addComposeOfficialDependencies() {
    composeOfficialDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeThirdPartyDependencies() {
    composeThirdPartyDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeUITestDependencies() {
    composeUITestDependencies.forEach {
        if (it == Dependencies.composeUiTestManifest) {
            add("debugImplementation", it)
        } else {
            add("androidTestImplementation", it)
        }

    }
}

fun DependencyHandler.addRetrofitDependencies() {
    retrofitDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addDependencyInjectionDependencies() {
    koinDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addKotlinCoroutineDependencies() {
    kotlinCoroutineDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addDBDependencies() {
    dbDependencies.forEach {
        if (it == Dependencies.roomCompiler) {
            add("kapt", it)
        } else {
            add("implementation", it)
        }

    }
}



