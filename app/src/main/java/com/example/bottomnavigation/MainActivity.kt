package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val bottomView = findViewById<BottomNavigationView>(R.id.BottomNavigation)

        replaceWithFragment(Home())
        // By Defalt Home wala Dikna Chahiye

       bottomView.setOnItemReselectedListener {
           when(it.itemId)
           {
               R.id.item1 -> replaceWithFragment(Home())
               R.id.item2 -> replaceWithFragment(Search())
               R.id.item3 -> replaceWithFragment(Profile())
               else  ->  {
               }
           }
       }
    }

    private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager =  supportFragmentManager
        val fragmentTransection = fragmentManager.beginTransaction()
        fragmentTransection.replace(R.id.frameLayout,fragment)
        fragmentTransection.commit()
    }
}