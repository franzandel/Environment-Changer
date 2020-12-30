# Environment-Changer
[![](https://jitpack.io/v/franzandel/Environment-Changer.svg)](https://jitpack.io/#franzandel/Environment-Changer)

Environment-Changer facilitates changing your environment without rebuilding APK. Specifically when you have **Development** & **Staging** environment.

This solve problem where QA need to do regression in Staging environment and you as a developer need to rebuild Staging APK.

# Usage

1. Add jitpack dependency in your project's `build.gradle` file

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. Add dependency in your module's `build.gradle` file

```groovy
implementation 'com.github.franzandel:Environment-Changer:1.0.0'
```

3. Make sure you have `dev` and `staging` build type in your module's `build.gradle` file

```groovy
buildTypes {
    dev {}
    staging {}
    ...
}
```

4. Create class that extend from `BaseEnvironmentChangerSetup` for Initial Setup and modify based on your requirements

```kotlin
class EnvironmentChangerSetup : BaseEnvironmentChangerSetup() {

    companion object {
        private const val LOGIN_ACTIVITY_CLASS_PATH =
            "com.franzandel.environmentchangersample.presentation.LoginActivity"
        const val PREF_URL_BASE_ONE = "pref_url_base_one"
        const val PREF_URL_BASE_TWO = "pref_url_base_two"
    }

    /**
     * Provide current class instance to EnvironmentChanger
     */
    override fun getEnvironmentChangerSetup(): BaseEnvironmentChangerSetup = this

    /**
     * Specify your next Activity class path after restarting app
     */
    override fun getNextFullClassName(): String = LOGIN_ACTIVITY_CLASS_PATH

    /**
     * Setup your Development Endpoint in EndpointSession
     */
    override fun setupDevelopmentEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(PREF_URL_BASE_ONE, BuildConfig.DEV_URL_BASE_ONE)
            setString(PREF_URL_BASE_TWO, BuildConfig.DEV_URL_BASE_TWO)
        }
    }

    /**
     * Setup your Staging Endpoint in EndpointSession
     */
    override fun setupStagingEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(PREF_URL_BASE_ONE, BuildConfig.STG_URL_BASE_ONE)
            setString(PREF_URL_BASE_TWO, BuildConfig.STG_URL_BASE_TWO)
        }
    }
}
```

5. Then instantiate the previous implementation class in your `SplashScreenActivity` or other Initial Activity in `onCreate` method
```kotlin
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        EnvironmentChangerSetup().init() // Call this before navigating to Environment Changer
        Intent(this, EnvironmentChangerActivity.CLASS_PATH).run {
            startActivity(this)
        }
        finish()
    }
}
```

6. Below is an example of how to use the `EndpointSession`
```kotlin
class LoginActivity : AppCompatActivity() {

    private val endpointSession by lazy {
        EndpointSession.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvLoginDescription.text = endpointSession.getString(
            EnvironmentChangerSetup.PREF_URL_BASE_ONE,
            BuildConfig.URL_BASE_ONE
        )
    }
}
```

# License
```
Copyright 2020 Franz Andel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
