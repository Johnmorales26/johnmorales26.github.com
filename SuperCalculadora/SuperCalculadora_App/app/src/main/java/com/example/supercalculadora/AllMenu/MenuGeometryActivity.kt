package com.example.supercalculadora.AllMenu

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.*
import com.example.supercalculadora.GeometryFigures.*
import com.example.supercalculadora.databinding.ActivityMenuGeometryBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MenuGeometryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuGeometryBinding
    private var count = 0
    private var interstitial: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuGeometryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  Initialize advertising
        initAds()
        initLoadAdds()
        //  Crea el boton de retroceder
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //  Botone que redirigen a sus Activity correspondiente
        binding.btnTriangle.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, TriangleActivity::class.java)
            startActivity(intent) }
        binding.btnTriangleRectangle.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, TriangleRectangleActivity::class.java)
            startActivity(intent) }
        binding.btnSquare.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, SquareActivity::class.java)
            startActivity(intent) }
        binding.btnRectangle.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, RectangleActivity::class.java)
            startActivity(intent) }
        binding.btnTrapezoid.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, TrapezoidActivity::class.java)
            startActivity(intent) }
        binding.btnRhomb.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, RhombActivity::class.java)
            startActivity(intent) }
        binding.btnPentagon.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, PentagonActivity::class.java)
            startActivity(intent) }
        binding.btnHexagon.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, HexagonActivity::class.java)
            startActivity(intent) }
        binding.btnCircle.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, CircleActivity::class.java)
            startActivity(intent) }
        binding.btnCircularArc.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, CircularArcActivity::class.java)
            startActivity(intent) }
        binding.btnOval.setOnClickListener {
            incrementAds()
            val intent: Intent = Intent(this, OvalActivity::class.java)
            startActivity(intent) }
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
