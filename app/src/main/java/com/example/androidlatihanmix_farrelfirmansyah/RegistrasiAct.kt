package com.example.androidlatihanmix_farrelfirmansyah

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register.*

class RegistrasiAct : AppCompatActivity() {

    lateinit var fAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        fAuth = FirebaseAuth.getInstance()

        btn_regis.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            if(email.isNotEmpty() || password.isNotEmpty() ||
                !email.equals("") || !password.equals("")){
                fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            Toast.makeText(this, "REGISTRASI Berhasil",
                                Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        }else{
                            Toast.makeText(this, "REGISTRASI Gagal",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "email atau password tidak boleh kosong",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}