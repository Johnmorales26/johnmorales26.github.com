package com.example.supercalculadora.AllMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.Algebra.*
import com.example.supercalculadora.Algebra.PercentOptions.PercentMenuActivity
import com.example.supercalculadora.databinding.ActivityMenuAlgebraBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MenuAlgebraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuAlgebraBinding
    private var count = 0
    private var interstitial: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuAlgebraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  Create button of return
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //  Initialize advertising
        initAds()
        initLoadAdds()
        binding.btnPercent.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, PercentMenuActivity::class.java)
            startActivity(intent) }
        binding.btnAverage.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, AverageActivity::class.java)
            startActivity(intent) }
        binding.btnProportion.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, ProportionActivity::class.java)
            startActivity(intent) }
        binding.btnEcuations.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, EcuationsActivity::class.java)
            startActivity(intent) }
        binding.btnFractions.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, FractionsActivity::class.java)
            startActivity(intent) }
        binding.btnMcdMcm.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, MCDActivity::class.java)
            startActivity(intent) }
        binding.btnCombinations.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, CombinationsActivity::class.java)
            startActivity(intent) }
        binding.btnPrimeNumbers.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, PrimeNumbersActivity::class.java)
            startActivity(intent) }
        binding.btnNumberGenerator.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, NumberGeneratorActivity::class.java)
            startActivity(intent) }
    }
    //  Method for return in main page
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