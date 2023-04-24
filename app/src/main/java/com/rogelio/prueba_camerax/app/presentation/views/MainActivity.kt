package com.rogelio.prueba_camerax.app.presentation.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.rogelio.prueba_camerax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val fragmentManager = supportFragmentManager
        goToSeeUsersBotton(fragmentManager)
        goToCreateUserBotton(fragmentManager)
    }

    fun goToSeeUsersBotton(fragmentManager: FragmentManager) {
        binding.seeUserDataBotton.setOnClickListener {
            val seeUserFragment = SeeUsersFragment()
            val nagivateTo = fragmentManager.beginTransaction()
            nagivateTo.replace(binding.fragmentUsersContainer.id, seeUserFragment)
            nagivateTo.commit()
        }
    }

    fun goToCreateUserBotton(fragmentManager: FragmentManager) {
        binding.createUserBotton.setOnClickListener {
            val createUserFragment = CreateUserFragment()
            val nagivateTo = fragmentManager.beginTransaction()
            nagivateTo.replace(binding.fragmentUsersContainer.id, createUserFragment)
            nagivateTo.commit()
        }
    }




}
