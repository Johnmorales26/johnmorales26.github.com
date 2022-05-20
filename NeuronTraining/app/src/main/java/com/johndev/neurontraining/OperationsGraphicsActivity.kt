package com.johndev.neurontraining

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.johndev.neurontraining.Adapters.ViewDataAdapter
import com.johndev.neurontraining.DialogFragments.DialogPrintFragment
import com.johndev.neurontraining.Interfaces.OnDataPass
import com.johndev.neurontraining.MainViews.CalculationsFragment.Companion.resultsPerceptron
import com.johndev.neurontraining.MainViews.DataFragment
import com.johndev.neurontraining.MainViews.GraphicsFragment
import com.johndev.neurontraining.databinding.ActivityOperationsGraphicsBinding

private lateinit var binding: ActivityOperationsGraphicsBinding

class OperationsGraphicsActivity : AppCompatActivity(), OnDataPass {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsGraphicsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureViewPager()
        binding.toolbar.title = getString(R.string.toolbar_title)
        message = intent.getStringExtra("Saludo").toString()

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.action_print_results -> {
                    //  Save Screen
                    val dialogDetailsData = DialogPrintFragment(
                        onSubmitClickListener = { quantity ->
                            Toast.makeText(applicationContext, quantity.toString(), Toast.LENGTH_SHORT).show()
                        }
                    )
                    dialogDetailsData.show(supportFragmentManager, "dialog")
                    Toast.makeText(applicationContext, getString(R.string.msj_toast_proximamente), Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_exit -> {
                    finish()
                    true
                }
                else -> {
                    super.onOptionsItemSelected(menuItem)
                }
            }
        }
    }

    private fun configureViewPager() {
        // setting up the adapter
        val viewDataAdapter = ViewDataAdapter(supportFragmentManager)
        // add the fragments
        viewDataAdapter.add(DataFragment(), getString(R.string.title_fragment_data))
        //viewDataAdapter.add(OperationsFragment(), "Operations")
        viewDataAdapter.add(GraphicsFragment(), getString(R.string.title_fragment_graphics))
        // Set the adapter
        binding.viewpager.adapter = viewDataAdapter
        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }

    companion object{
        lateinit var message: String
        var paintResults = resultsPerceptron
    }

}