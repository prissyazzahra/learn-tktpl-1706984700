package id.ac.ui.cs.mobileprogramming.prissy.helloworld.model

import com.google.gson.annotations.SerializedName

class WifiModel {
    @SerializedName("message")
    var message: String = ""
}

class ResponseModel {
    @SerializedName("success")
    val response: Boolean = false
}