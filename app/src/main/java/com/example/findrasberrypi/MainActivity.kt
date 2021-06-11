package com.example.findrasberrypi

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.net.InetAddress


class MainActivity : AppCompatActivity() {

    lateinit var ipFromSt:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findButton = findViewById<Button>(R.id.findButton)
        val listObject = findViewById<ListView>(R.id.list_of_ip)
        val settingsBnt = findViewById<Button>(R.id.SettingsBtn)






        findButton.setOnClickListener {
            val arrayOfIp = ArrayList<String>()
            var ipAddr = "192.168.1."



            val intent = intent.extras
            val strBundle = intent?.getString("EditIp")
            if (strBundle != null){
                findButton.text = "ip из настроек ${strBundle}"
                ipAddr = ParseIpAddres(strBundle)
            }







            for (i in 1..30){

                val policy = ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)

                val ipAddri = ipAddr + i
                val net = InetAddress.getByName(ipAddri)

                arrayOfIp.add((net.hostName).toString() + " / ${net.hostAddress}")






                val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayOfIp)
                listObject.adapter = arrayAdapter

            }


        }


        settingsBnt.setOnClickListener {
            startActivity(Intent(this@MainActivity,Settings::class.java))

        }


    }


    fun ParseIpAddres(ip:String) :String{

        var readyIp = ""
        val sIp = ip.split('.')

        println(sIp)


        for (i in 0..2){
            if (i <= 4) {
                readyIp += sIp[i] + "."
            }else {
                readyIp += sIp[i]
            }
        }
        println("Готовый ip")
        println(readyIp)


        return readyIp
    }






}

