package com.franzandel.environmentchangersample.constants

/**
 * Created by Franz Andel on 15/12/20.
 * Android Engineer
 */

object Screen {
    private const val domain = "com.franzandel.environmentchanger"

    val environmentChanger =
        Class.forName("$domain.presentation.EnvironmentChangerActivity")
}