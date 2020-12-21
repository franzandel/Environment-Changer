package com.franzandel.environmentchanger.external

import com.franzandel.environmentchanger.BuildConfig
import com.franzandel.environmentchanger.constants.EndpointConstants
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.EndpointSession
import com.senyumkulite.catatankeuanganharian.environmentchanger.external.EnvironmentChangerSetup
import com.senyumkulite.catatankeuanganharian.environmentchanger.presentation.EnvironmentChangerActivity

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

class EnvironmentChangerSetupImpl :
    EnvironmentChangerSetup {

    companion object {
        private const val loginActivityClass =
            "com.franzandel.environmentchanger.presentation.LoginActivity"
    }

    override fun init() {
        EnvironmentChangerActivity.environmentChangerSetup = this
    }

    override fun getNextFullClassName(): String =
        loginActivityClass

    override fun setupDevelopmentEnvironment(endpointSession: EndpointSession) {
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

    override fun setupStagingEnvironment(endpointSession: EndpointSession) {
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