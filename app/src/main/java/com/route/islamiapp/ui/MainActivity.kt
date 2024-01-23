package com.route.islamiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.route.islamiapp.R
import com.route.islamiapp.databinding.ActivityMainBinding
import com.route.islamiapp.databinding.ContentMainBinding
import com.route.islamiapp.ui.hadeth.HadethFragment
import com.route.islamiapp.ui.quran.QuranFragment
import com.route.islamiapp.ui.radio.RadioFragment
import com.route.islamiapp.ui.sebha.SebhaFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

    }

    private fun initView() {
        binding.content.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quran -> {
                    pushFragment(QuranFragment())
                }

                R.id.nav_hadeth -> {
                    pushFragment(HadethFragment())
                }

                R.id.nav_sebha -> {
                    pushFragment(SebhaFragment())
                }

                R.id.nav_radio -> {
                    pushFragment(RadioFragment())
                }
            }
            true
        }
        binding.content.bottomNav.selectedItemId = R.id.nav_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.content.fragmentContainer.id, fragment)
            .commit()
    }
}