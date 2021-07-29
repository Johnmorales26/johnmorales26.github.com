package com.example.supercalculadora.AllMenu

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.GeometryBodiesActivities.*
import com.example.supercalculadora.databinding.ActivityMenuGeometryBodiesBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MenuGeometryBodiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuGeometryBodiesBinding
    private var count = 0
    private var interstitial: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuGeometryBodiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  Initialize advertising
        initAds()
        initLoadAdds()

        //  Crea el boton de retroceder
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //  Botone que redirigen a sus Activity correspondiente
        binding.btnCube.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, CubeActivity::class.java)
            startActivity(intent) }
        binding.btnPrism.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, PrismActivity::class.java)
            startActivity(intent) }
        binding.btnPyramid.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, PyramidActivity::class.java)
            startActivity(intent) }
        binding.btnCone.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, ConeActivity::class.java)
            startActivity(intent) }
        binding.btnShortCone.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, ShortConeActivity::class.java)
            startActivity(intent) }
        binding.btnCylinder.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, CylinderActivity::class.java)
            startActivity(intent) }
        binding.btnSphere.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, SphereActivity::class.java)
            startActivity(intent) }
        binding.btnSphereCap.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, SphereCapActivity::class.java)
            startActivity(intent) }
        binding.btnSphereSegment.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, SphereSegmentActivity::class.java)
            startActivity(intent) }
        binding.btnEllipsod.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, EllipsoidActivity::class.java)
            startActivity(intent) }
    }

    private fun incrementAds() {
        count += 1
        checkCounter()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
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