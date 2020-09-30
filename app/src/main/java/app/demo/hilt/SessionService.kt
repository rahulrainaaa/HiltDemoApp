package app.demo.hilt

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionService @Inject constructor() {

    var username: String? = null
}