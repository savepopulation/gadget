/*
 * Versions
 * Contains the versions of the project configuration and dependency versions
 */

import org.gradle.api.JavaVersion

object Versions {
    /*
     * Sdk Versions
     */
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30

    /*
     * Source Versions
     */
    val sourceCompatibilityVersion = JavaVersion.VERSION_1_8
    val targetCompatibilityVersion = JavaVersion.VERSION_1_8
    const val jvmTargetVersion = "1.8"

    /*
     * Dependency versions
     */
    const val buildToolsVersion = "29.0.2"
    const val gradleVersion = "4.1.1"
    const val kotlinVersion = "1.4.10"
    const val jUnitVersion = "4.12"
    const val testRunnerVersion = "1.1.1"
    const val espressoCoreVersion = "3.1.0"
    const val supportDesignVersion = "1.2.0-alpha06"
    const val fragmentTestVersion = "1.1.0"
    const val testRulesVersion = "1.1.1"
    const val testCoreVersion = "1.1.0"
    const val jUnitKtxVersion = "1.1.0-beta01"
    const val truthVersion = "1.0"
    const val truthExtVersion = "1.3.0-alpha01"
    const val mockKVersion = "1.9.3"
    const val coreTestingVersion = "2.0.0"
    const val robolectricVersion = "4.3.1"
    const val multiDexVersion = "2.0.1"
    const val javaxAnnotationVersion = "10.0-b28"

    // Firebase Versions
    const val firebaseAnalyticsVersion = "17.5.0"
    const val tagManagerVersion = "16.0.8"

    /*
     * Plugin Versions
     */
    const val googleServicesPluginVersion = "4.3.3"
}
