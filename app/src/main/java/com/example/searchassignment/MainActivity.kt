package com.example.searchassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.cache2.Relay.Companion.edit

/**
 * 1 add libraries - build.gradle
 * 2. generate model classes: nmae, image, summary
 * 3. CREATE SERVICE
 * 4. Repository
 * 5. viewmodel
 * 6. inject into model(mainactivity):
 * Hilt
 * Inject viewmodel
 * cLL FUN FROM VM
 * 7. Create application - do manifest- internet permission
 * 8.Injection file
 * 9.Create layout
 * 10. bind layout in mainactivity
 */


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ShowsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = findViewById<EditText>(R.id.edit)

        val button = findViewById<Button>(R.id.button)

        val textView = findViewById<TextView>(R.id.textViewName)

        val image = findViewById<ImageView>(R.id.imageView)




        button.setOnClickListener() {
            var value = edit.text.toString()
            viewModel.fetchShows(value)

            viewModel.showsLiveData.observe(this) {
                Log.i("DataShow", it.name)
                textView.text = it.name

                Glide.with(this)
                    .load(it.image.original)
                    .into(image)
            }
        }
    }
}