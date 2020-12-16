package com.franzandel.environmentchanger

import com.senyumkulite.catatankeuanganharian.environmentchanger.BuildConfig
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.EnvironmentChanger
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.session.EndpointSession
import com.senyumkulite.catatankeuanganharian.environmentchanger.presentation.EnvironmentChangerActivity

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

class EnvironmentChangerImpl: EnvironmentChanger {

    companion object {
        const val PREF_URL_BASE_INTERNAL = "pref_url_base_internal"
        const val PREF_URL_BASE_KEYCLOAK = "pref_url_base_keycloak"
    }

    init {
        EnvironmentChangerActivity.environmentChanger = this
    }

    override fun developmentSelected(endpointSession: EndpointSession) {
        endpointSession.apply {
            setString(PREF_URL_BASE_INTERNAL, BuildConfig.DEV_URL_BASE_INTERNAL)
            setString(PREF_URL_BASE_KEYCLOAK, BuildConfig.DEV_URL_BASE_KEYCLOAK)
        }
    }

    override fun stagingSelected(endpointSession: EndpointSession) {
        endpointSession.apply {
            setString(PREF_URL_BASE_INTERNAL, BuildConfig.STG_URL_BASE_INTERNAL)
            setString(PREF_URL_BASE_KEYCLOAK, BuildConfig.STG_URL_BASE_KEYCLOAK)
        }
    }
}