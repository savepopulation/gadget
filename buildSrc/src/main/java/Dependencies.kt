/*
 * Dependencies
 * Contains the dependencies of the project
 */

// Core
object CoreLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
}

// Support
object SupportLibraries {
    const val design = "com.google.android.material:material:${Versions.supportDesignVersion}"
    const val multidex = "androidx.multidex:multidex:${Versions.multiDexVersion}"
}

// Test
object TestLibraries {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val runnner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragmentTestVersion}"
    const val testRules = "androidx.test:rules:${Versions.testRulesVersion}"
    const val testCore = "androidx.test:core-ktx:${Versions.testCoreVersion}"
    const val jUnitKtx = "androidx.test.ext:junit-ktx:${Versions.jUnitKtxVersion}"
    const val truth = "com.google.truth:truth:${Versions.truthVersion}"
    const val truthExt = "androidx.test.ext:truth:${Versions.truthExtVersion}"
    const val mockK = "io.mockk:mockk-android:${Versions.mockKVersion}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
}

// Other
object Libraries {
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBomVersion}"
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebasePerformance = "com.google.firebase:firebase-perf-ktx"
    const val javaxAnnotation = "org.glassfish:javax.annotation:${Versions.javaxAnnotationVersion}"
    const val googleTagManager =
        "com.google.android.gms:play-services-tagmanager:${Versions.tagManagerVersion}"
}
