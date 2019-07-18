package com.example.androidlatihanmix_farrelfirmansyah

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.androidlatihanmix_farrelfirmansyah.Fragment.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navListener =
            BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
                var selectedFragment: Fragment? = null

                when (menuItem.itemId) {
                    R.id.nav_home -> selectedFragment =
                        HomeFragment()
                    R.id.nav_search -> selectedFragment =
                        SearchFragment()
                    R.id.nav_upload -> selectedFragment =
                        UploadFragment()
                    R.id.nav_favorite -> selectedFragment =
                        FavoriteFragment()
                    R.id.nav_person -> selectedFragment =
                        PersonFragment()
                }
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    selectedFragment!!
                ).commit()

                true
            }

        bottom_navigation.setOnNavigationItemSelectedListener(navListener)


    }

    lateinit var fAuth: FirebaseAuth



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        fAuth = FirebaseAuth.getInstance()
//
//    }


}
