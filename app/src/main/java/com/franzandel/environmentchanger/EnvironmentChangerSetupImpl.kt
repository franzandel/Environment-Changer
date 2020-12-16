package com.franzandel.environmentchanger

import com.senyumkulite.catatankeuanganharian.environmentchanger.data.EnvironmentChangerSetup
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.session.EndpointSession
import com.senyumkulite.catatankeuanganharian.environmentchanger.presentation.EnvironmentChangerActivity

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

class EnvironmentChangerSetupImpl : EnvironmentChangerSetup {

    init {
        EnvironmentChangerActivity.environmentChangerSetup = this
    }

    override fun getNextFullClassName(): String = "com.franzandel.environmentchanger.LoginActivity"

    override fun setupDevelopmentEnvironment(endpointSession: EndpointSession) {
        endpointSession.apply {
            setString(EndpointConstants.PREF_URL_BASE_ONE, BuildConfig.DEV_URL_BASE_ONE)
            setString(EndpointConstants.PREF_URL_BASE_TWO, BuildConfig.DEV_URL_BASE_TWO)
        }
    }

    override fun setupStagingEnvironment(endpointSession: EndpointSession) {
        endpointSession.apply {
            setString(EndpointConstants.PREF_URL_BASE_ONE, BuildConfig.STG_URL_BASE_ONE)
            setString(EndpointConstants.PREF_URL_BASE_TWO, BuildConfig.STG_URL_BASE_TWO)
        }
    }
}