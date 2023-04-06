import com.demo.datausage.build.*
plugins {
    id("common-compose-module-plugin")
}

android{
    namespace = "com.demo.datausage.features.consumption.years"
}

dependencies {
    implementation(project(mapOf("path" to ":core:repository")))

    addAndroidDependencies()
    addAndroidUIDependencies()
    addComposeOfficialDependencies()
    addComposeThirdPartyDependencies()
}