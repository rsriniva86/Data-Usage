import com.demo.datausage.build.addAndroidDependencies
import com.demo.datausage.build.addDependencyInjectionDependencies
import com.demo.datausage.build.addRetrofitDependencies

plugins {
    id("common-kotlin-module-plugin")
}

android {
    namespace = "com.demo.datausage.core.data.datasource.remote"
}

dependencies {
    addAndroidDependencies()
}