package com.johndev.neurontraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.johndev.neurontraining.Adapters.ViewDataAdapter
import com.johndev.neurontraining.DialogFragments.DialogPrintAutoFragment
import com.johndev.neurontraining.DialogFragments.DialogPrintFragment
import com.johndev.neurontraining.MainViews.*
import com.johndev.neurontraining.databinding.ActivityAutomaticChartBinding

class AutomaticChartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAutomaticChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutomaticChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureViewPager()
        binding.toolbar.title = getString(R.string.toolbar_title)

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.action_print_results -> {
                    //  Save Screen
                    val dialogDetailsAutoData = DialogPrintAutoFragment(
                        onSubmitClickListener = { quantity ->
                            Toast.makeText(applicationContext, quantity.toString(), Toast.LENGTH_SHORT).show()
                        }
                    )
                    dialogDetailsAutoData.show(supportFragmentManager, "dialog")
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
        viewDataAdapter.add(AutomaticViewFragment(), getString(R.string.title_fragment_data))
        //viewDataAdapter.add(OperationsFragment(), "Operations")
        viewDataAdapter.add(AutomaticChartFragment(), getString(R.string.title_fragment_graphics))
        // Set the adapter
        binding.viewpager.adapter = viewDataAdapter
        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }

    companion object{
        lateinit var message: String
        var paintResultsAutomatic = CalculationsAutomaticFragment.resultsAutomatic
    }

}