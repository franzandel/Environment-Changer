package com.franzandel.environmentchanger

/**
 * Created by Franz Andel on 15/12/20.
 * Android Engineer
 */

object Screen {
    private const val domain = "com.senyumkulite.catatankeuanganharian"

    val environmentChanger =
        Class.forName("$domain.environmentchanger.presentation.EnvironmentChangerActivity")
}