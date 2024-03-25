package com.example.gdscsohag

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gdscsohag.data.SharedPrefManager
import com.example.gdscsohag.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHost: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupSplashScreen()
        setupBottomNav()
        checkIsLogin()
    }

    private fun setupSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        } else setTheme(R.style.Base_Theme_GDSCSohag)
        window.navigationBarColor = getColor(R.color.primary)
    }

    private fun setupBottomNav() {
        navHost =
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

    private fun checkIsLogin() {
        SharedPrefManager.getInit(applicationContext)
        if (SharedPrefManager.isLogin) {
            val graph = navController.navInflater.inflate(R.navigation.main_navigation)
            graph.setStartDestination(R.id.homeFragment2)
            navController.setGraph(graph, intent.extras)
        }
    }
}