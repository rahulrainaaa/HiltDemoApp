package app.demo.hilt

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LoggerService @Inject constructor() {

    private val TAG = "LoggerService"

    fun log(msg: String) = Log.d(TAG, msg)

    fun logMillis() = Log.d(TAG, System.currentTimeMillis().toString())
}