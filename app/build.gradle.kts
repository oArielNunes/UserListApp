import org.gradle.kotlin.dsl.implementation


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.userlistapp"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.example.userlistapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

        //bibliotecas core //
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

        //Dependencias de teste //
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //RecyclerView
    implementation(libs.androidx.recyclerview)

    // Retrofit para chamadas de API
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // OkHttp (últi para debugs)
    implementation(libs.logging.interceptor)

    //Componentes LifeCycle (ViewModel e LiveData)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.core.ktx)

    // Coroutine (chamadas assíncronas com Retrofit)
    implementation(libs.kotlinx.coroutines.android)



}