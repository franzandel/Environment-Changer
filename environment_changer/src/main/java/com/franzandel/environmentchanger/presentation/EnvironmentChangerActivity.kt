package com.franzandel.environmentchanger.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.environmentchanger.R
import com.franzandel.environmentchanger.data.EndpointSession
import com.franzandel.environmentchanger.external.EnvironmentChangerSetup
import com.jakewharton.processphoenix.ProcessPhoenix
import kotlinx.android.synthetic.main.activity_environment_changer.*

class EnvironmentChangerActivity : AppCompatActivity() {

    companion object {
        lateinit var environmentChangerSetup: EnvironmentChangerSetup
        val CLASS_PATH =
            Class.forName("com.franzandel.environmentchanger.presentation.EnvironmentChangerActivity")
    }

    private val endpointSession by lazy {
        EndpointSession.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environment_changer)

        setupUIClickListener()
    }

    private fun setupUIClickListener() {
        rbDevelopment.setOnClickListener {
            environmentChangerSetup.setupDevelopmentEnvironment(endpointSession)
            restartAppAndGoToWalkthrough()
        }

        rbStaging.setOnClickListener {
            environmentChangerSetup.setupStagingEnvironment(endpointSession)
            restartAppAndGoToWalkthrough()
        }
    }

    private fun restartAppAndGoToWalkthrough() {
        // Must have this delay otherwise Session won't be set
        Handler().postDelayed({
            kotlin.run {
                val intent = Intent(
                    this,
                    Class.forName(environmentChangerSetup.getNextFullClassName())
                )
                ProcessPhoenix.triggerRebirth(this, intent)
            }
        }, 100L)
    }
}