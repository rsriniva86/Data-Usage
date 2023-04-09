package com.demo.datausage.build

internal val androidDependencies = listOf(
    Dependencies.appCompat,
    Dependencies.ktx,
    Dependencies.timber,
    Dependencies.localBroadcastManager
)

internal val androidUIDependencies = listOf(
    Dependencies.materialDesign
)

internal val kotlinCoroutineDependencies = listOf(
    Dependencies.kotlinCoroutineAndroid,
    Dependencies.kotlinCoroutineCore
)

internal val junitTestDependencies = listOf(
    Dependencies.junit,
    Dependencies.kotlinCoroutineTest
)
internal val mokitoAndroidTestDependencies = listOf(
    Dependencies.mokitoNhaarman,
    Dependencies.mokitoAndroid
)

internal val mockWebServerAndroidTestDependencies = listOf(
    Dependencies.mockWebServer
)

internal val androidTestDependencies = listOf(
    Dependencies.extJunit,
    Dependencies.espresso
)

internal val composeOfficialDependencies = listOf(
    Dependencies.composeUi,
    Dependencies.composeUiTooling,
    Dependencies.composeMaterial,
    Dependencies.composeMaterial3,
    Dependencies.composeMaterialIconsExtended,
    Dependencies.composeRuntimeLivedata,
    Dependencies.composeConstraintLayout,
    Dependencies.composePaging,
    Dependencies.composeViewModel,
    Dependencies.composeActivity,
    Dependencies.composeNavigation,
)

internal val composeThirdPartyDependencies = listOf(
    Dependencies.composeLottie,
)

internal val retrofitDependencies = listOf(
    Dependencies.retrofit,
    Dependencies.retrofitGSON,
    Dependencies.retrofitLogInterceptor
)

internal val koinDependencies = listOf(
    Dependencies.koin,
    Dependencies.koinAndroid,
    Dependencies.koinAndroidXCompose
)

internal val dbDependencies = listOf(
    Dependencies.roomRuntime,
    Dependencies.roomKtx,
    Dependencies.roomCompiler
)

