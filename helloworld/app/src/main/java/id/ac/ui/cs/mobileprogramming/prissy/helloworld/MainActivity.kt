package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        change.setOnClickListener {
            val color = hello.currentTextColor
            if (color == -16749881) {
                hello.setTextColor(-1199616)
            } else {
                hello.setTextColor(-16749881)
            }
        }
    }
}
