package com.cursosant.android.mdpostres

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.cursosant.android.mdpostres.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
/****
 * Project: MD Postres
 * From: com.cursosant.android.mdpostres
 * Created by Alain Nicolás Tello on 01/01/21 at 14:06
 * Course: Professional Material Desing/Theming for Android, UX/UI.
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * All rights reserved 2021.
 *
 * Others:
 * Android con Kotlin intensivo y práctico desde cero.
 * https://www.udemy.com/course/kotlin-intensivo/?referralCode=93D5D2FA6EF503FD0A6B
 */

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private var mBottomSheetBehavior: BottomSheetBehavior<*>? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration.Builder(navController!!.graph)
                .build()
        NavigationUI.setupWithNavController(binding.toolbar, navController!!, appBarConfiguration)
        navController!!.addOnDestinationChangedListener { controller: NavController?, destination: NavDestination, arguments: Bundle? ->
            binding.toolbar.title = destination.label
            binding.toolbar.navigationIcon = null
        }

        binding.bottomSheetContainer.btnClose.setOnClickListener { view: View? -> mBottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_HIDDEN) }
        binding.bottomSheetContainer.btnExit.setOnClickListener { view: View? -> finish() }
        mBottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetContainer.bottomSheet)
        mBottomSheetBehavior?.setState(BottomSheetBehavior.STATE_HIDDEN)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*if (item.getItemId() == R.id.action_confirmation){
            navController!!.navigate(R.id.action_global_confirmation);
        }
        return super.onOptionsItemSelected(item)*/
        return NavigationUI.onNavDestinationSelected(item, navController!!) ||
                super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        mBottomSheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
    }
}