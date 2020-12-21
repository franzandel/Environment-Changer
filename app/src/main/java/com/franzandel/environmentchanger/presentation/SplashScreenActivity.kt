package com.franzandel.environmentchanger.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.environmentchanger.R
import com.franzandel.environmentchanger.constants.Screen
import com.franzandel.environmentchanger.extension.goTo
import com.franzandel.environmentchanger.external.EnvironmentChangerSetupImpl

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        EnvironmentChangerSetupImpl().init()
        goTo(Screen.environmentChanger)
        finish()
    }
}