package com.ebac.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ebac.jokenpo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    lateinit var navController : NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LifeCycle","onCreate")

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.playerFragment,R.id.resultFragment), drawer)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.homeFragment -> bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawer.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LifeCycle", "onSaveInstance")
    }

    override fun onResume() {
        super.onResume()

        Log.d("LifeCycle", "onResume")
    }

    override fun onStop() {
        super.onStop()

        Log.d("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Lifecycle", "onDestroy")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}