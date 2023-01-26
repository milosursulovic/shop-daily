val composeUIVersion by extra { "1.3.3" }
val navVersion by extra { "2.5.3" }
val retrofitVersion by extra { "2.9.0" }
val okhttpVersion by extra { "4.10." }
val hiltVersion by extra { "2.44.2" }
val pagerVersion by extra { "0.29.0-alpha" }
val roomVersion by extra { "2.5.0" }
val coilVersion by extra { "2.2.2" }
val navigationHiltVersion by extra { "1.0.0" }

plugins {
    id("com.google.dagger.hilt.android") version "2.44.2" apply false
    id ("com.android.application") version "7.3.1" apply false
    id ("com.android.library") version "7.3.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
}