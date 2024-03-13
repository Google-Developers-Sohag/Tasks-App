package com.example.gdscsohag

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gdscsohag.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupSplashScreen()
        setupBottomNav()
    }

    private fun setupSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        } else setTheme(R.style.Base_Theme_GDSCSohag)
        window.navigationBarColor = getColor(R.color.primary)
    }

    private fun setupBottomNav() {
        val navHost =
            supportFragmentManager.findFragmentById(binding.mainFragment.id) as NavHostFragment
        navController = navHost.navController
        binding.bottomNav.setupWithNavController(navController)
    }

    fun controlBottomNavVisibility(isShow: Boolean) {
        binding.bottomNav.visibility = when (isShow) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }
}