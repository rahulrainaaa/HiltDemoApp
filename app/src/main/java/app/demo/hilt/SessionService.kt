package app.demo.hilt

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionService @Inject constructor(@ApplicationContext val applicationContext: Context)
