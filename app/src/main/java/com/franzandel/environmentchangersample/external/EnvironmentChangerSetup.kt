package com.franzandel.environmentchangersample.external

import com.franzandel.environmentchanger.data.EndpointSession
import com.franzandel.environmentchanger.external.BaseEnvironmentChangerSetup
import com.franzandel.environmentchangersample.BuildConfig

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

class EnvironmentChangerSetup : BaseEnvironmentChangerSetup() {

    companion object {
        private const val LOGIN_ACTIVITY_CLASS_PATH =
            "com.franzandel.environmentchangersample.presentation.LoginActivity"
        const val PREF_URL_BASE_ONE = "pref_url_base_one"
        const val PREF_URL_BASE_TWO = "pref_url_base_two"
    }

    /**
     * Provide current class instance to EnvironmentChanger
     */
    override fun getEnvironmentChangerSetup(): BaseEnvironmentChangerSetup = this

    /**
     * Specify your next Activity class path after restarting app
     */
    override fun getNextFullClassName(): String = LOGIN_ACTIVITY_CLASS_PATH

    /**
     * Setup your Development Endpoint in EndpointSession
     */
    override fun setupDevelopmentEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(PREF_URL_BASE_ONE, BuildConfig.DEV_URL_BASE_ONE)
            setString(PREF_URL_BASE_TWO, BuildConfig.DEV_URL_BASE_TWO)
        }
    }

    /**
     * Setup your Staging Endpoint in EndpointSession
     */
    override fun setupStagingEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(PREF_URL_BASE_ONE, BuildConfig.STG_URL_BASE_ONE)
            setString(PREF_URL_BASE_TWO, BuildConfig.STG_URL_BASE_TWO)
        }
    }
}