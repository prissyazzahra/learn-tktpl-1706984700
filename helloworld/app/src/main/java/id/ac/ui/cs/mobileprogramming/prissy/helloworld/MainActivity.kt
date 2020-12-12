package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import id.ac.ui.cs.mobileprogramming.prissy.helloworld.external.Sum
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sum_numbers.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private var greetType : String = ""
    private val sumClass = Sum()
    private var results = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetme.setOnClickListener() {
            changeGreeting(greetType, name_input.text.toString())

            if (name_input.text.toString() == "") {
                greetName.text = "Tell me your name, please :("
            } else {
                greetName.text = changeGreeting(greetType, name_input.text.toString())
            }

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

        sumANumber.setOnClickListener {
            setContentView(R.layout.sum_numbers)

            sumButton.setOnClickListener {
                val first: Int = firstNum.text.toString().toInt()
                val second: Int = secondNum.text.toString().toInt()
                results = sumClass.addSum(first, second)
                result.text = results.toString()
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
