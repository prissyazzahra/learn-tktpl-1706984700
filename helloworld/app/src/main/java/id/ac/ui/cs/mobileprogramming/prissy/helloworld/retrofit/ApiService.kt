package id.ac.ui.cs.mobileprogramming.prissy.helloworld.retrofit

import id.ac.ui.cs.mobileprogramming.prissy.helloworld.model.ResponseModel
import id.ac.ui.cs.mobileprogramming.prissy.helloworld.model.WifiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    suspend fun submitWifiList(@Body wifiList: List<WifiModel>): Response<ResponseModel>
}
