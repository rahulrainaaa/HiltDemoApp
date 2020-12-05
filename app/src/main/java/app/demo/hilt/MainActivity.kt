package app.demo.hilt

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var myDependency: MyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            myDependency.toast()
        }
    }
}

@ActivityScoped
class MyDependency @Inject constructor(@ApplicationContext val applicationContext: Context, private val someDependency: SomeDependency) {

    private fun getString() = someDependency.provideData()

    fun toast() = Toast.makeText(applicationContext, getString(), Toast.LENGTH_SHORT).show()
}

@Module
@InstallIn(ActivityComponent::class)
class SomeDependency @Inject constructor() {

//    @ActivityScoped
//    @Provides
    fun provideData(): String {
        return "Some data provided here..."
    }
}