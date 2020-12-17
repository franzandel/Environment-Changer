package com.franzandel.environmentchanger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senyumkulite.catatankeuanganharian.environmentchanger.data.session.EndpointSession
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