package com.example.mars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rover_mini.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val roverFragment = RoverFragment()
       // val weatherFragment = WeatherFragment()

        makeCurrentFragment(roverFragment)

       /* bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.rover -> makeCurrentFragment(roverFragment)
                R.id.weather -> makeCurrentFragment(weatherFragment)
            }
            true
        }*/


    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameView, fragment)
            commit()
        }


}
