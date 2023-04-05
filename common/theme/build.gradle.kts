import com.demo.datausage.build.addAndroidDependencies
import com.demo.datausage.build.addAndroidUIDependencies
import com.demo.datausage.build.addComposeOfficialDependencies
import com.demo.datausage.build.addComposeThirdPartyDependencies

plugins {
    id("common-compose-module-plugin")
}

android{
    namespace = "com.demo.datausage.common.theme"

}

dependencies {
    addComposeOfficialDependencies()
    addComposeThirdPartyDependencies()
    addAndroidDependencies()
    addAndroidUIDependencies()
}