package com.senyumkulite.catatankeuanganharian.environmentchanger.external

import com.senyumkulite.catatankeuanganharian.environmentchanger.data.EndpointSession

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

interface EnvironmentChangerSetup {
    fun init()
    fun getNextFullClassName(): String
    fun setupDevelopmentEnvironment(endpointSession: EndpointSession)
    fun setupStagingEnvironment(endpointSession: EndpointSession)
}