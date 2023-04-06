import com.demo.datausage.build.addAndroidDependencies
import com.demo.datausage.build.addAndroidUIDependencies
import com.demo.datausage.build.addComposeOfficialDependencies
import com.demo.datausage.build.addComposeThirdPartyDependencies
import com.demo.datausage.build.addRetrofitDependencies

plugins {
    id("common-kotlin-module-plugin")
}

android{
    namespace = "com.demo.datausage.core.repository"
}

dependencies {
    implementation(project(mapOf("path" to ":core:data:datasource:remote")))

    addAndroidDependencies()
    addRetrofitDependencies()
}