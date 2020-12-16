package com.senyumkulite.catatankeuanganharian.environmentchanger.data

import com.senyumkulite.catatankeuanganharian.environmentchanger.data.session.EndpointSession

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

interface EnvironmentChangerSetup {
    fun getNextFullClassName(): String
    fun setupDevelopmentEnvironment(endpointSession: EndpointSession)
    fun setupStagingEnvironment(endpointSession: EndpointSession)
}