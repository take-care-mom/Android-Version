package com.example.takecaremom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView=findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.button_bookmarks-> {
                    replaceFragment(BookmarksFragment())
                    true
                }
                R.id.button_home-> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.button_profile-> {
                    replaceFragment(ProfileFragment())
                    true
                }
                R.id.button_discover-> {
                    replaceFragment(DiscoverFragment())
                    true
                }
                else->false
        }
        }
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}