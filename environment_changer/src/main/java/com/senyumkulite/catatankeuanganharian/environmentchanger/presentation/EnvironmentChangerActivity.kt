package com.senyumkulite.catatankeuanganharian.environmentchanger.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.processphoenix.ProcessPhoenix
import com.senyumkulite.catatankeuanganharian.environmentchanger.R
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.EnvironmentChanger
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.NetworkChangeManager
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.NetworkChangeManagerImpl
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.constants.EnvironmentChangerConstants
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.session.EndpointSession
import kotlinx.android.synthetic.main.activity_environment_changer.*

class EnvironmentChangerActivity : AppCompatActivity() {

    companion object {
        private const val WALKTHROUGH_ACTIVITY =
            "com.franzandel.environmentchanger.LoginActivity"
        lateinit var environmentChanger: EnvironmentChanger
    }

    private val endpointSession by lazy {
        EndpointSession(applicationContext)
    }

    private val networkChangeManager: NetworkChangeManager by lazy {
        NetworkChangeManagerImpl(endpointSession)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environment_changer)

        setupUIClickListener()
    }

    private fun setupUIClickListener() {
        rbDevelopment.setOnClickListener {
//            networkChangeManager.onEnvironmentChanged(EnvironmentChangerConstants.DEVELOPMENT)
            environmentChanger.developmentSelected(endpointSession)
            restartAppAndGoToWalkthrough()
        }

        rbStaging.setOnClickListener {
//            networkChangeManager.onEnvironmentChanged(EnvironmentChangerConstants.STAGING)
            environmentChanger.stagingSelected(endpointSession)
            restartAppAndGoToWalkthrough()
        }
    }

    private fun restartAppAndGoToWalkthrough() {
        // Must have this delay otherwise Session won't be set
        Handler().postDelayed({
            kotlin.run {
                val intent = Intent(
                    this,
                    Class.forName(WALKTHROUGH_ACTIVITY)
                )
                ProcessPhoenix.triggerRebirth(this, intent)
            }
        }, 100L)
    }
}