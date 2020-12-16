package com.senyumkulite.catatankeuanganharian.environmentchanger.data.session

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.senyumkulite.catatankeuanganharian.environmentchanger.BuildConfig

/**
 * Created by Franz Andel on 06/10/20.
 * Android Engineer
 */

class EndpointSession(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("endpoint_session", 0)

    fun getString(key: String, defaultValue: String): String? =
        sharedPreferences.getString(key, defaultValue)

    fun setString(key: String, value: String?) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    fun clear() {
        sharedPreferences.edit {
            clear()
        }
    }

    companion object {
        const val PREF_URL_BASE_INTERNAL = "pref_url_base_internal"
        const val PREF_URL_BASE_KEYCLOAK = "pref_url_base_keycloak"
        const val PREF_URL_KEYCLOAK_AUTH = "pref_url_keycloak_auth"
        const val PREF_URL_KEYCLOAK_AUTH_GOOGLE = "pref_url_keycloak_auth_google"
        const val PREF_URL_KEYCLOAK_REGISTER = "pref_url_keycloak_register"
        const val PREF_URL_KEYCLOAK_TOKEN = "pref_url_keycloak_token"
        const val PREF_URL_ASSET_INTERNAL = "pref_url_asset_internal"
        const val PREF_URL_COUCH_BASE = "pref_url_couch_base"
        const val PREF_URL_SENYUMKU_DEPOSITO = "pref_url_senyumku_deposito"
        const val PREF_URL_BANK_FETCHING = "pref_url_bank_fetching"
    }

    fun setUrlBaseInternal(urlBaseInternal: String) {
        setString(PREF_URL_BASE_INTERNAL, urlBaseInternal)
    }

    fun getUrlBaseInternal(): String =
        getString(PREF_URL_BASE_INTERNAL, BuildConfig.URL_BASE_INTERNAL)
            ?: BuildConfig.URL_BASE_INTERNAL

    fun setUrlBaseKeycloak(urlBaseKeycloak: String) {
        setString(PREF_URL_BASE_KEYCLOAK, urlBaseKeycloak)
    }

    fun getUrlBaseKeycloak(): String =
        getString(PREF_URL_BASE_KEYCLOAK, BuildConfig.URL_BASE_KEYCLOAK)
            ?: BuildConfig.URL_BASE_KEYCLOAK

    fun setUrlKeycloakAuth(urlKeycloakAuth: String) {
        setString(PREF_URL_KEYCLOAK_AUTH, urlKeycloakAuth)
    }

    fun getUrlKeycloakAuth(): String =
        getString(PREF_URL_KEYCLOAK_AUTH, BuildConfig.URL_KEYCLOAK_AUTH)
            ?: BuildConfig.URL_KEYCLOAK_AUTH

    fun setUrlKeycloakAuthGoogle(urlKeycloakAuthGoogle: String) {
        setString(PREF_URL_KEYCLOAK_AUTH_GOOGLE, urlKeycloakAuthGoogle)
    }

    fun getUrlKeycloakAuthGoogle(): String =
        getString(PREF_URL_KEYCLOAK_AUTH_GOOGLE, BuildConfig.URL_KEYCLOAK_AUTH_GOOGLE)
            ?: BuildConfig.URL_KEYCLOAK_AUTH_GOOGLE

    fun setUrlKeycloakRegister(urlKeycloakRegister: String) {
        setString(PREF_URL_KEYCLOAK_REGISTER, urlKeycloakRegister)
    }

    fun getUrlKeycloakRegister(): String =
        getString(PREF_URL_KEYCLOAK_REGISTER, BuildConfig.URL_KEYCLOAK_REGISTER)
            ?: BuildConfig.URL_KEYCLOAK_REGISTER

    fun setUrlKeycloakToken(urlKeycloakToken: String) {
        setString(PREF_URL_KEYCLOAK_TOKEN, urlKeycloakToken)
    }

    fun getUrlKeycloakToken(): String =
        getString(PREF_URL_KEYCLOAK_TOKEN, BuildConfig.URL_KEYCLOAK_TOKEN)
            ?: BuildConfig.URL_KEYCLOAK_TOKEN

    fun setUrlAssetInternal(urlAssetInternal: String) {
        setString(PREF_URL_ASSET_INTERNAL, urlAssetInternal)
    }

    fun getUrlAssetInternal(): String =
        getString(PREF_URL_ASSET_INTERNAL, BuildConfig.URL_ASSET_INTERNAL)
            ?: BuildConfig.URL_ASSET_INTERNAL

    fun setUrlCouchBase(urlCouchBase: String) {
        setString(PREF_URL_COUCH_BASE, urlCouchBase)
    }

    fun getUrlCouchBase(): String =
        getString(PREF_URL_COUCH_BASE, BuildConfig.URL_COUCH_BASE) ?: BuildConfig.URL_COUCH_BASE

    fun setUrlSenyumkuDeposito(urlSenyumkuDeposito: String) {
        setString(PREF_URL_SENYUMKU_DEPOSITO, urlSenyumkuDeposito)
    }

    fun getUrlSenyumkuDeposito(): String =
        getString(PREF_URL_SENYUMKU_DEPOSITO, BuildConfig.URL_SENYUMKU_DEPOSITO)
            ?: BuildConfig.URL_SENYUMKU_DEPOSITO

    fun setUrlBankFetching(urlBankFetching: String) {
        setString(PREF_URL_BANK_FETCHING, urlBankFetching)
    }

    fun getUrlBankFetching(): String =
        getString(PREF_URL_BANK_FETCHING, BuildConfig.URL_BANK_FETCHING)
            ?: BuildConfig.URL_BANK_FETCHING
}