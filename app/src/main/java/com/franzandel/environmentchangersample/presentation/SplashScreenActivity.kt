package com.franzandel.environmentchangersample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.environmentchangersample.R
import com.franzandel.environmentchangersample.constants.Screen
import com.franzandel.environmentchangersample.extension.goTo
import com.franzandel.environmentchangersample.external.EnvironmentChangerSetupImpl

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        EnvironmentChangerSetupImpl().init()
        goTo(Screen.environmentChanger)
        finish()
    }
}