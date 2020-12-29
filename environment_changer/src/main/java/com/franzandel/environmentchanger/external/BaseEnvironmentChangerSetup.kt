package com.franzandel.environmentchanger.external

import com.franzandel.environmentchanger.data.EndpointSession
import com.franzandel.environmentchanger.presentation.EnvironmentChangerActivity

/**
 * Created by Franz Andel on 16/12/20.
 * Android Engineer
 */

abstract class BaseEnvironmentChangerSetup {
    abstract fun getEnvironmentChangerSetup(): BaseEnvironmentChangerSetup
    abstract fun getNextFullClassName(): String
    abstract fun setupDevelopmentEnvironment(endpointSession: EndpointSession)
    abstract fun setupStagingEnvironment(endpointSession: EndpointSession)

    fun init() {
        EnvironmentChangerActivity.environmentChangerSetup = getEnvironmentChangerSetup()
    }
}