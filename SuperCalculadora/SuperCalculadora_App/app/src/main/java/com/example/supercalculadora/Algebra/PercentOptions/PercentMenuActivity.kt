
package com.example.supercalculadora.Algebra.PercentOptions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.Algebra.*
import com.example.supercalculadora.databinding.ActivityPercentMenuBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class PercentMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPercentMenuBinding
    private var count = 0
    private var interstitial: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPercentMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initAds()
        initLoadAdds()
        binding.btnDescount.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, DiscountActivity::class.java)
            startActivity(intent) }
        binding.btnIncrease.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, IncreaseActivity::class.java)
            startActivity(intent) }
        binding.btnSimplePercent.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, SimplePercentActivity::class.java)
            startActivity(intent) }
        binding.btnIncreaseDecrease.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, IncreaseDecreaseActivity::class.java)
            startActivity(intent) }
        binding.btnPercentFromAToB.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, PercentFromActivity::class.java)
            startActivity(intent) }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
    //  Methods for Ads
    private fun incrementAds() {
        count += 1
        checkCounter()
    }

    private fun initAds() {
        var adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback(){
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                interstitial = interstitialAd
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                interstitial = null
            }
        })
    }

    private fun checkCounter() {
        if (count == 5){
            showAds()
            count = 0
            initAds()
        }
    }

    fun showAds(){
        interstitial?.show(this)
    }

    private fun initLoadAdds() {
        val adRequest = AdRequest.Builder().build()
        binding.bannerMenuGeometryPage.loadAd(adRequest)
    }
}