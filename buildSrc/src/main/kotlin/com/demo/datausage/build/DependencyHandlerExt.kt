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
        add("implementation", it)
    }
}

fun DependencyHandler.addAndroidTestDependencies() {
    androidTestDependencies.forEach {
        add("implementation", it)
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

fun DependencyHandler.addRetrofitDependencies() {
    retrofitDependencies.forEach {
        add("implementation", it)
    }
}