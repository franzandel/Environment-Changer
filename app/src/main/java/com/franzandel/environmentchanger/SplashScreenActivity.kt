package com.franzandel.environmentchanger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        EnvironmentChangerSetupImpl().init()
        goTo(Screen.environmentChanger)
        finish()
    }
}