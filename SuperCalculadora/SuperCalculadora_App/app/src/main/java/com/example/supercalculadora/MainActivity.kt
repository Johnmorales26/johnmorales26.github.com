 package com.example.supercalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.supercalculadora.AllMenu.*
import com.example.supercalculadora.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

 class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
     private var count = 0
     private var interstitial: InterstitialAd? = null

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
         initAds()
         initLoadAdds()

         binding.cvGeometricFigures.setOnClickListener {
             incrementAds()
             val intent: Intent = Intent(this, MenuGeometryActivity::class.java)
             startActivity(intent)
         }
         binding.cvGeometricBodies.setOnClickListener {
             incrementAds()
             val intent: Intent = Intent(this, MenuGeometryBodiesActivity::class.java)
             startActivity(intent)
         }
         binding.cvUnitConverter.setOnClickListener {
             incrementAds()
             val intent: Intent = Intent(this, MenuUnitConverterActivity::class.java)
             startActivity(intent)
         }
         binding.cvAlgebra.setOnClickListener {
             incrementAds()
             val intent: Intent = Intent(this, MenuAlgebraActivity::class.java)
             startActivity(intent)
         }
         binding.cvHealth.setOnClickListener {
             incrementAds()
             val intent: Intent = Intent(this, MenuHealthActivity::class.java)
             startActivity(intent)
         }
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

     private fun incrementAds() {
         count += 1
         checkCounter()
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
         binding.bannerMainPage.loadAd(adRequest)
     }
 }