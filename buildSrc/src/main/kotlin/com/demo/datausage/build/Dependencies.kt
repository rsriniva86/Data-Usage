package com.demo.datausage.build

object Dependencies {

    const val androidPlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val localBroadcastManager =
        "androidx.localbroadcastmanager:localbroadcastmanager:${Versions.localBroadcast}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val junit = "junit:junit:${Versions.jUnit}"
    const val mokitoNhaarman= "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mokitoNhaarman}"
    const val mokitoAndroid= "org.mockito:mockito-android:${Versions.mokitoAndroid}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.material3}"
    const val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeRuntimeLivedata =
        "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}"
    const val composePaging = "androidx.paging:paging-compose:${Versions.pagingCompose}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidLifecycleGrouped}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeLottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"
    const val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGSON = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitLogInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitLogIntercepter}"
    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroid}"
    const val koinAndroidXCompose =
        "io.insert-koin:koin-androidx-compose:${Versions.koinAndroidXCompose}"
    const val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val kotlinCoroutineTest =
         "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
}


