package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var greetType : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetme.setOnClickListener() {
            changeGreeting(greetType, name_input.text.toString())
            greetName.text = changeGreeting(greetType, name_input.text.toString())

        }

        choose_greeting.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio.text) {
                "Basic Greeting" -> {
                    greetType = "basic"
                }
                "Fancy Greeting" -> {
                    greetType = "fancy"
                }
                "Dandy Greeting" -> {
                    greetType = "dandy"
                }
            }
        }
    }

    fun changeGreeting(type : String, name : String): String {
        return when(type) {
            "basic" ->
                "Hello there, $name!"
            "fancy" ->
                "Salutations, $name!"
            "dandy" ->
                "Tally ho, $name!"
            else -> {
                "It's $name."
            }
        }
    }
}
