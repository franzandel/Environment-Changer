package com.franzandel.environmentchanger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.EnvironmentChangerSetup

class SplashScreenActivity : AppCompatActivity() {

    private val environmentChanger: EnvironmentChangerSetup = EnvironmentChangerSetupImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        goTo(Screen.environmentChanger)
        finish()
    }
}