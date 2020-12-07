package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import id.ac.ui.cs.mobileprogramming.prissy.helloworld.model.ResponseModel
import id.ac.ui.cs.mobileprogramming.prissy.helloworld.model.WifiModel
import id.ac.ui.cs.mobileprogramming.prissy.helloworld.retrofit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var wifiManager: WifiManager
    private lateinit var retrofit: ApiService
    private lateinit var wifiList: List<ScanResult>
    private lateinit var deviceList: ArrayList<String>
    private val responseList = mutableListOf<WifiModel>()
    private val MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1

    private val wr = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action: String? = intent.action

            if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION == action) {
                wifiList = wifiManager.scanResults
                deviceList = ArrayList()

                for (scanResult in wifiList) {
                    val model = WifiModel()
                    model.message = scanResult.SSID
                    deviceList.add(model.message)
                    responseList.add(model)
                }

                val arrayAdapter: ArrayAdapter<*> = ArrayAdapter(
                    context,
                    android.R.layout.simple_list_item_1,
                    arrayOf(deviceList)
                )
                devices.adapter = arrayAdapter
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit = RetrofitClient.RETROFIT_SERVICE
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        scanBtn.setOnClickListener{
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
            } else {
                Toast.makeText(this, "Scanning...", Toast.LENGTH_SHORT).show()
                wifiManager.startScan();
            }
        }

        sendList.setOnClickListener {
            GlobalScope.launch(Main) {
                val response: Response<ResponseModel> = retrofit.submitWifiList(responseList)
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Wifi list submitted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Wifi list submit failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        registerReceiver(wr, intentFilter)
        getWifi()
    }

    private fun getWifi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
            } else {
                Toast.makeText(this, "Scanning...", Toast.LENGTH_SHORT).show()
                wifiManager.startScan();
            }
        } else {
            Toast.makeText(this, "Scanning...", Toast.LENGTH_SHORT).show()
            wifiManager.startScan();
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(wr)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_ACCESS_COARSE_LOCATION ->
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    wifiManager.startScan();
                } else {
                    return;
                }
        }
    }
}
