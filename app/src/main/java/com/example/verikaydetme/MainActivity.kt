package com.example.verikaydetme

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var gelenVeri : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("seyfettingocmen", MODE_PRIVATE)
        gelenVeri = sharedPreferences.getString("kullanici","")
        if (gelenVeri != null){
            textView.text = "Kullanıcı Adı: ${gelenVeri}"
        }
    }
    fun kaydet(view: View) {
        gelenVeri = editText.text.toString()
        if (gelenVeri == ""){
            var uyari = AlertDialog.Builder(this@MainActivity)
            uyari.setTitle("Giriş Hatası")
            uyari.setMessage("Lütfen Gerekli Veriyi Giriniz!")
            uyari.setPositiveButton("TAMAM",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Tekrar Deniyorsun!",Toast.LENGTH_SHORT).show()
            })
            uyari.show()
        }
        else {
            gelenVeri = editText.toString()
            sharedPreferences.edit().putString("kullanici",gelenVeri).apply()
            textView.text = "Kullanıcı Adı: ${gelenVeri}"

        }
    }
    fun sil (view: View){
        gelenVeri = editText.text.toString()
        sharedPreferences.edit().remove("kullanici").apply()
        textView.text = "Kullanıcı Adı: "
        }
    fun giris(view: View){
        gelenVeri = editText.text.toString()
        val intent = Intent(applicationContext,MainActivity2::class.java)
        intent.putExtra("kullanici",gelenVeri)
        startActivity(intent)
    }
    fun cikis (view: View){
        finish()

    }



}