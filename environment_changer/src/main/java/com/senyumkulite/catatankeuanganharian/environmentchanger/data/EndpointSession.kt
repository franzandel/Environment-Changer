package com.senyumkulite.catatankeuanganharian.environmentchanger.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by Franz Andel on 06/10/20.
 * Android Engineer
 */

class EndpointSession(context: Context) {

    companion object {
        private const val SESSION_NAME = "endpoint_session"
        private var endpointSession: EndpointSession? = null
        private val LOCK = Any()

        fun getInstance(context: Context): EndpointSession =
            endpointSession
                ?: synchronized(LOCK) {
                    endpointSession
                        ?: createEndpointSession(
                            context
                        )
                            .also { endpointSession = it }
                }

        private fun createEndpointSession(context: Context) =
            EndpointSession(
                context
            )
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SESSION_NAME, Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String): String? =
        sharedPreferences.getString(key, defaultValue)

    fun setString(key: String, value: String?) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }
}