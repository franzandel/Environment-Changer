package com.franzandel.environmentchangersample.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.environmentchanger.presentation.EnvironmentChangerActivity
import com.franzandel.environmentchangersample.R
import com.franzandel.environmentchangersample.external.EnvironmentChangerSetup

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        EnvironmentChangerSetup().init() // Call this before navigating to Environment Changer
        Intent(this, EnvironmentChangerActivity.CLASS_PATH).run {
            startActivity(this)
        }
        finish()
    }
}