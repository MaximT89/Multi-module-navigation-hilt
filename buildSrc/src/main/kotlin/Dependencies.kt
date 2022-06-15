object Dependencies {

    const val lifecycleVersion = "2.4.1"
    const val fragmentKtxVersion = "1.4.1"
    const val glideVersion = "4.13.0"
    const val loggingVersion = "4.9.0"
    const val retrofitVersion = "2.9.0"
    const val roomVersion = "2.4.2"
    const val navigationVersion = "2.4.2"
    const val coroutinesVersion = "1.6.1"
    const val rvVersion = "1.2.1"
    const val hiltVersion = "2.42"
    const val swipeRefresh = "1.1.0"
    const val coilVersion = "2.0.0-rc03"
    const val dataStoreVersion = "1.0.0"

    object LoggingInterceptor {
        const val logging = "com.squareup.okhttp3:logging-interceptor:$loggingVersion"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val ui = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    }

    object Lifecycle {
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        const val common = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    }

    object Fragment {
        const val fragment = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"
    }

    object RecyclerView {
        const val recyclerview = "androidx.recyclerview:recyclerview:$rvVersion"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:$hiltVersion"
        const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    }



}