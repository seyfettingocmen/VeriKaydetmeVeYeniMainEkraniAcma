package com.example.verikaydetme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val gelenVeri = intent.getStringExtra("kullanici")
        textView3.text = gelenVeri
    }
    fun geri(view: View){
        val gerii = Intent(applicationContext,MainActivity::class.java)
        startActivity(gerii)
    }


}