package com.demo.datausage.build

internal val androidDependencies = listOf(
    Dependencies.appCompat,
    Dependencies.ktx
)

internal val androidUIDependencies = listOf(
    Dependencies.materialDesign
)

internal val junitTestDependencies = listOf(
    Dependencies.junit
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