package com.senyumkulite.catatankeuanganharian.environmentchanger.data

import com.senyumkulite.catatankeuanganharian.environmentchanger.BuildConfig
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.constants.EnvironmentChangerConstants
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.session.EndpointSession

class NetworkChangeManagerImpl(private val endpointSession: EndpointSession) :
    NetworkChangeManager {

    override fun onEnvironmentChanged(environment: String) {
        if (environment == EnvironmentChangerConstants.DEVELOPMENT) {
            setupDevelopmentEndpointSession()
        } else {
            setupStagingEndpointSession()
        }
    }

    private fun setupDevelopmentEndpointSession() {
        endpointSession.apply {
            setUrlBaseInternal(BuildConfig.DEV_URL_BASE_INTERNAL)
            setUrlBaseKeycloak(BuildConfig.DEV_URL_BASE_KEYCLOAK)
            setUrlKeycloakAuth(BuildConfig.DEV_URL_KEYCLOAK_AUTH)
            setUrlKeycloakAuthGoogle(BuildConfig.DEV_URL_KEYCLOAK_AUTH_GOOGLE)
            setUrlKeycloakRegister(BuildConfig.DEV_URL_KEYCLOAK_REGISTER)
            setUrlKeycloakToken(BuildConfig.DEV_URL_KEYCLOAK_TOKEN)
            setUrlAssetInternal(BuildConfig.DEV_URL_ASSET_INTERNAL)
            setUrlCouchBase(BuildConfig.DEV_URL_COUCH_BASE)
            setUrlSenyumkuDeposito(BuildConfig.DEV_URL_SENYUMKU_DEPOSITO)
            setUrlBankFetching(BuildConfig.DEV_URL_BANK_FETCHING)
        }
    }

    private fun setupStagingEndpointSession() {
        endpointSession.apply {
            setUrlBaseInternal(BuildConfig.STG_URL_BASE_INTERNAL)
            setUrlBaseKeycloak(BuildConfig.STG_URL_BASE_KEYCLOAK)
            setUrlKeycloakAuth(BuildConfig.STG_URL_KEYCLOAK_AUTH)
            setUrlKeycloakAuthGoogle(BuildConfig.STG_URL_KEYCLOAK_AUTH_GOOGLE)
            setUrlKeycloakRegister(BuildConfig.STG_URL_KEYCLOAK_REGISTER)
            setUrlKeycloakToken(BuildConfig.STG_URL_KEYCLOAK_TOKEN)
            setUrlAssetInternal(BuildConfig.STG_URL_ASSET_INTERNAL)
            setUrlCouchBase(BuildConfig.STG_URL_COUCH_BASE)
            setUrlSenyumkuDeposito(BuildConfig.STG_URL_SENYUMKU_DEPOSITO)
            setUrlBankFetching(BuildConfig.STG_URL_BANK_FETCHING)
        }
    }
}