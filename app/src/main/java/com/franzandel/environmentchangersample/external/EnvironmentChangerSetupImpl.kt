package com.franzandel.environmentchangersample.external

import com.franzandel.environmentchanger.data.EndpointSession
import com.franzandel.environmentchanger.external.EnvironmentChangerSetup
import com.franzandel.environmentchanger.presentation.EnvironmentChangerActivity
import com.franzandel.environmentchangersample.BuildConfig
import com.franzandel.environmentchangersample.constants.EndpointConstants

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

class EnvironmentChangerSetupImpl : EnvironmentChangerSetup {

    companion object {
        private const val loginActivityClass =
            "com.franzandel.environmentchangersample.presentation.LoginActivity"
    }

    /**
     * Connect your class to EnvironmentChanger
     */
    override fun init() {
        EnvironmentChangerActivity.environmentChangerSetup = this
    }

    /**
     * Specify your next Activity class path after restarting app
     */
    override fun getNextFullClassName(): String = loginActivityClass

    /**
     * Setup your Development Endpoint
     */
    override fun setupDevelopmentEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(
                EndpointConstants.PREF_URL_BASE_ONE,
                BuildConfig.DEV_URL_BASE_ONE
            )
            setString(
                EndpointConstants.PREF_URL_BASE_TWO,
                BuildConfig.DEV_URL_BASE_TWO
            )
        }
    }

    /**
     * Setup your Staging Endpoint
     */
    override fun setupStagingEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(
                EndpointConstants.PREF_URL_BASE_ONE,
                BuildConfig.STG_URL_BASE_ONE
            )
            setString(
                EndpointConstants.PREF_URL_BASE_TWO,
                BuildConfig.STG_URL_BASE_TWO
            )
        }
    }
}