package com.hk.socialwalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.Fragments.CreateFragment
import com.Fragments.FeedFragment
import com.Fragments.ProfileFragment
import com.hk.socialwalk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val createFragment = CreateFragment()
    private val feedFragment = FeedFragment()
    private val profileFragemnt = ProfileFragment()

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(feedFragment)

        binding.bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.feed-> replaceFragment(feedFragment)
                R.id.create-> replaceFragment(createFragment)
                R.id.profile-> replaceFragment(profileFragemnt)
            }
            true
        }


    }


    fun replaceFragment(fragment:Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }


}