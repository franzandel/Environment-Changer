package com.franzandel.environmentchangersample.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.environmentchanger.data.EndpointSession
import com.franzandel.environmentchanger.presentation.EnvironmentChangerActivity
import com.franzandel.environmentchangersample.BuildConfig
import com.franzandel.environmentchangersample.R
import com.franzandel.environmentchangersample.external.EnvironmentChangerSetup

class SplashScreenActivity : AppCompatActivity() {

    private val endpointSession by lazy {
        EndpointSession.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Navigate to Environment Changer if Not Production Environment & Never selected Environment before
        if (BuildConfig.DEBUG && !endpointSession.getIsEnvironmentChangerShown()) {
            EnvironmentChangerSetup().init() // Call this before navigating to Environment Changer
            goToEnvironmentChanger()
        } else {
            goToLogin()
        }
        finish()
    }

    private fun goToEnvironmentChanger() {
        Intent(this, EnvironmentChangerActivity.CLASS_PATH).run {
            startActivity(this)
        }
    }

    private fun goToLogin() {
        Intent(this, LoginActivity::class.java).run {
            startActivity(this)
        }
    }
}