/*
 * Contains the path variables that used in project
 */

object Paths {
    const val gradleClasspath = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlinGradlePluginClasspath =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val googleServicesClasspath =
        "com.google.gms:google-services:${Versions.googleServicesPluginVersion}"
    const val firebaseCrashlyticsPath =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsPluginVersion}"
    const val firebasePerformancefClasspath =
        "com.google.firebase:perf-plugin:${Versions.firebasePerformancePluginVersion}"
}
