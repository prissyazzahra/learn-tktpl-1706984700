package id.ac.ui.cs.mobileprogramming.prissy.helloworld.external

import java.lang.IllegalArgumentException
import kotlin.jvm.Throws

class Sum {
    @Throws(IllegalArgumentException::class)
    external fun addSum(first: Int, second: Int): Int

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}