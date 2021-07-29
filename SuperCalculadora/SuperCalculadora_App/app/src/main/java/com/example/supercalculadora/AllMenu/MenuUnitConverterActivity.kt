package com.example.supercalculadora.AllMenu

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.databinding.ActivityMenuUnitConverterBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MenuUnitConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuUnitConverterBinding
    private var count = 0
    private var interstitial: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuUnitConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  Create button of return
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //  Initialize advertising
        initAds()
        initLoadAdds()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
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