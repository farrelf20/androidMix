package com.example.androidlatihanmix_farrelfirmansyah

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        Handler().postDelayed({
            startActivity(Intent(this, LoginAct::class.java))

            finish()
        }, SPLASH_TIME_OUT)
    }
}