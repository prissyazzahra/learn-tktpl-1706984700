package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var greet = ""

        greetme.setOnClickListener() {
            greet = "Hello there, " + name_input.text.toString() + "!"
            greetName.text = greet

        }
    }
}
