import com.demo.datausage.build.*
plugins {
    id("common-compose-module-plugin")
}

android{
    namespace = "com.demo.datausage.features.consumption.qtr"
}

dependencies {
    implementation(project(mapOf("path" to ":core:repository")))
    implementation(project(mapOf("path" to ":common:domainmodels")))

    addAndroidDependencies()
    addAndroidUIDependencies()
    addComposeOfficialDependencies()
    addComposeThirdPartyDependencies()
}