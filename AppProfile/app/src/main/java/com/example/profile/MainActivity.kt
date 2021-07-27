package com.example.profile

import android.app.SearchManager
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.edit
import androidx.core.view.updateLayoutParams
import androidx.preference.PreferenceManager
import com.example.profile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var imgUri: Uri
    private var lat: Double = 0.0
    private var long: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        //updateUI()
        getUserData()
        setupIntents()
    }

    override fun onResume() {
        super.onResume()
        refreshSettingsPreferences()
    }

    private fun refreshSettingsPreferences() {
        val isEnable = sharedPreferences.getBoolean(getString(R.string.preferences_eneable_clicks), true)
        with(binding) {
            tvName.isEnabled = isEnable
            tvEmail.isEnabled = isEnable
            tvWebsite.isEnabled = isEnable
            tvPhone.isEnabled = isEnable
            tvLocation.isEnabled = isEnable
            tvSettings.isEnabled = isEnable
        }

        val imgSize = sharedPreferences.getString(getString(R.string.preferences_key_ui_img_size), "")
        val sizeValue = when(imgSize){
            getString(R.string.preferences_img_size_small) -> {
                resources.getDimensionPixelSize(R.dimen.profile_image_size_small)
            }
            getString(R.string.preferences_img_size_medium) -> {
                resources.getDimensionPixelSize(R.dimen.profile_image_size_medium)
            }
            else ->{
                resources.getDimensionPixelSize(R.dimen.profile_image_size_large)
            }
        }
        binding.imageProfile.updateLayoutParams {
            width = sizeValue
            height = sizeValue
        }
        getUserData()
    }

    private fun setupIntents() {
        binding.tvName.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, binding.tvName.text)
            }
            launchIntent(intent)
        }

        binding.tvEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(binding.tvEmail.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, "From kotlin basic course")
                putExtra(Intent.EXTRA_TEXT, "Hi! I'm Android developer.")
            }
            launchIntent(intent)
        }

        binding.tvWebsite.setOnClickListener {
            val webPage = Uri.parse(binding.tvWebsite.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            launchIntent(intent)
        }

        binding.tvPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                val phone = (it as TextView).text
                data = Uri.parse("tel:$phone")
            }
            launchIntent(intent)
        }

        binding.tvLocation.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$lat,$long(Cursos Android ANT)")
                `package` = "com.google.android.apps.maps"
            }
            launchIntent(intent)
        }

        binding.tvSettings.setOnClickListener {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            launchIntent(intent)
        }
    }

    private fun launchIntent(intent: Intent){
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.profile_error_no_resolve), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserData(){
        imgUri = Uri.parse(sharedPreferences.getString(getString(R.string.key_image), ""))
        val name = sharedPreferences.getString(getString(R.string.key_name), null)
        val email = sharedPreferences.getString(getString(R.string.key_email), null)
        val website = sharedPreferences.getString(getString(R.string.key_website), null)
        val phone = sharedPreferences.getString(getString(R.string.key_phone), null)
        lat = sharedPreferences.getString(getString(R.string.key_latitude), "0.0")!!.toDouble()
        long = sharedPreferences.getString(getString(R.string.key_logitude), "0.0")!!.toDouble()

        updateUI(name, email, website, phone)
    }

    private fun updateUI(name: String?, email: String?, website: String?, phone: String?) {
        with(binding) {
            imageProfile.setImageURI(imgUri)
            tvName.text = name ?: "John MT"
            tvEmail.text = email ?: "johnta2610@hotmail.com"
            tvWebsite.text = website ?: "https://www.facebook.com/johnMorales/"
            tvPhone.text = phone ?: "+52 55 2025 0858"
        }
        /*lat = 37.3725
        long = -122.0820*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_edit -> {
                val intent = Intent(this, EditActivity::class.java)
                intent.putExtra(getString(R.string.key_image), imgUri.toString())
                intent.putExtra(getString(R.string.key_name), binding.tvName.text)
                intent.putExtra(getString(R.string.key_email), binding.tvEmail.text.toString())
                intent.putExtra(getString(R.string.key_website), binding.tvWebsite.text.toString())
                intent.putExtra(getString(R.string.key_phone), binding.tvPhone.text)
                intent.putExtra(getString(R.string.key_latitude), lat)
                intent.putExtra(getString(R.string.key_logitude), long)

                //startActivity(intent) <- solo lanzamiento
                startActivityForResult(intent, RC_EDIT) // <- lanzamiento y espera de respuesta
            }
            R.id.action_setings -> startActivity(Intent(this, SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK){
            if (requestCode == RC_EDIT){
                imgUri = Uri.parse(data?.getStringExtra(getString(R.string.key_image)))
                val name = data?.getStringExtra(getString(R.string.key_name))
                val email = data?.getStringExtra(getString(R.string.key_email))
                val website = data?.getStringExtra(getString(R.string.key_website))
                val phone = data?.getStringExtra(getString(R.string.key_phone))
                lat = data?.getDoubleExtra(getString(R.string.key_latitude), 0.0) ?: 0.0
                long = data?.getDoubleExtra(getString(R.string.key_logitude), 0.0) ?: 0.0

                //updateUI(name!!, email!!, website!!, phone!!)
                saveUserData(name, email, website, phone)
            }
        }
    }

    private fun saveUserData(name: String?, email: String?, website: String?, phone: String?) {
        sharedPreferences.edit {
            putString(getString(R.string.key_image), imgUri.toString())
            putString(getString(R.string.key_name), name)
            putString(getString(R.string.key_email), email)
            putString(getString(R.string.key_website), website)
            putString(getString(R.string.key_phone), phone)
            putString(getString(R.string.key_latitude), lat.toString())
            putString(getString(R.string.key_logitude), long.toString())
            apply()
        }
        updateUI(name, email, website, phone)
    }

    companion object {
        private const val RC_EDIT = 21
    }
}