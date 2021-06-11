package com.example.findrasberrypi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.log

class Settings : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val MainPageAct = findViewById<Button>(R.id.MainPageBtn)
        val ApplyBtn = findViewById<Button>(R.id.ApplySettingsBtn)
        val EditIp = findViewById<EditText>(R.id.EditIp)




        MainPageAct.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("EditIp", EditIp.text.toString())

            startActivity(Intent(this@Settings,MainActivity::class.java).putExtras(bundle))
        }

        ApplyBtn.setOnClickListener {

            Toast.makeText(this, EditIp.text, Toast.LENGTH_SHORT).show()
            Intent(this@Settings,MainActivity::class.java).putExtra("EditIp",EditIp.text)

        }




    }




}