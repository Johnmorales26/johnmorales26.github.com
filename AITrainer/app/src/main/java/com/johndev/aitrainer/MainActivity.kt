package com.johndev.aitrainer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import com.johndev.aitrainer.Models.Automatic
import com.johndev.aitrainer.databinding.ActivityMainBinding
import com.johndev.aitrainer.regresion_automatic.AutomaticRegresionFragment
import com.johndev.aitrainer.regresion_manual.ManualRegresionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        printAutomatic = mutableListOf()
        setupIntroduction()
        setupActionBar()

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            binding.drawerLayout.close()
            when (menuItem.itemId) {
                R.id.action_manual_regression -> {
                    binding.mainIntroduction.visibility = GONE
                    binding.mainContainer.visibility = VISIBLE
                    binding.topAppBar.title = getString(R.string.manual_regression)
                    val fragment = ManualRegresionFragment()
                    openFragment(fragment)
                }
                R.id.action_automatic_regresion -> {
                    binding.mainIntroduction.visibility = GONE
                    binding.mainContainer.visibility = VISIBLE
                    binding.topAppBar.title = getString(R.string.automatic_regression)
                    val fragment = AutomaticRegresionFragment()
                    openFragment(fragment)
                }
            }
            true
        }
    }

    private fun setupIntroduction() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_introduction, IntroductionFragment())
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        with(binding) {
            binding.topAppBar.title = getString(R.string.app_name)
            binding.topAppBar.setNavigationOnClickListener {
                /*var modalFragment = ModalNavigationDrawerFragment()
                modalFragment.show(supportFragmentManager.beginTransaction(), ModalNavigationDrawerFragment.TAG)*/
            }
        }
    }

    companion object{
        lateinit var appContext: Context
        lateinit var printAutomatic: MutableList<Automatic>
    }

}