# Environment-Changer
Environment-Changer facilitates changing your environment without rebuilding APK. Specifically when you have **Development** & **Staging** environment.

This solve problem where QA need to do regression in Staging environment and you as a developer need to rebuild Staging APK.

# Usage
1. Add dependency in your `build.gradle` file

```groovy
implementation 'com.franzandel:environment-changer:1.0.0'
```

2. Make sure you have `dev` and `staging` build type in your `build.gradle` file

```groovy
buildTypes {
    dev {}
    staging {}
}
```

3. Create implementation class of `EnvironmentChangerSetup` for Initial Setup

```kotlin
class EnvironmentChangerSetup : BaseEnvironmentChangerSetup() {

    companion object {
        private const val loginActivityClass =
            "com.franzandel.environmentchangersample.presentation.LoginActivity"
    }

    /**
     * Provide current class instance to EnvironmentChanger
     */
    override fun getEnvironmentChangerSetup(): BaseEnvironmentChangerSetup = this

    /**
     * Specify your next Activity class path after restarting app
     */
    override fun getNextFullClassName(): String = loginActivityClass

    /**
     * Setup your Development Endpoint
     */
    override fun setupDevelopmentEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(
                EndpointConstants.PREF_URL_BASE_ONE,
                BuildConfig.DEV_URL_BASE_ONE
            )
            setString(
                EndpointConstants.PREF_URL_BASE_TWO,
                BuildConfig.DEV_URL_BASE_TWO
            )
        }
    }

    /**
     * Setup your Staging Endpoint
     */
    override fun setupStagingEnvironment(endpointSession: EndpointSession) {
        // Change this based on your requirements
        endpointSession.apply {
            setString(
                EndpointConstants.PREF_URL_BASE_ONE,
                BuildConfig.STG_URL_BASE_ONE
            )
            setString(
                EndpointConstants.PREF_URL_BASE_TWO,
                BuildConfig.STG_URL_BASE_TWO
            )
        }
    }
}
```

4. Then instantiate the previous implementation class in your `SplashScreenActivity` or other Initial Activity in `onCreate` method
```kotlin
     EnvironmentChangerSetup().init()  // Call this before navigating to Environment Changer
     Intent(this, EnvironmentChangerActivity.CLASS_PATH).run {
         startActivity(this)
     }
     finish()
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
