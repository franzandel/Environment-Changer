package com.franzandel.environmentchangersample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.environmentchanger.data.EndpointSession
import com.franzandel.environmentchangersample.BuildConfig
import com.franzandel.environmentchangersample.R
import com.franzandel.environmentchangersample.constants.EndpointConstants
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val endpointSession by lazy {
        EndpointSession.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginDescription.text = endpointSession.getString(
            EndpointConstants.PREF_URL_BASE_ONE,
            BuildConfig.URL_BASE_ONE
        )
    }
}