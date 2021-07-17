package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.profile.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  Crea el boton de retroceder en el action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //  Recibe los parametros del ActivityMain y los muestra en los componentes
        with(binding) {
            intent.extras?.let {
                etName.setText(it.getString(getString(R.string.key_name)))
                etEmail.setText(it.getString(getString(R.string.key_email)))
                etWebsite.setText(it.getString(getString(R.string.key_website)))
                etPhone.setText(it.getString(getString(R.string.key_phone)))
                etLatitude.setText(it.getDouble(getString(R.string.key_latitude)).toString())
                etLong.setText(it.getDouble(getString(R.string.key_longitude)).toString())
            }
            etEmail.setOnFocusChangeListener { _, isFocused ->
                if (isFocused){etEmail.text?.let{etEmail.setSelection(it.length)}}}
            etWebsite.setOnFocusChangeListener { _, isFocused ->
                if (isFocused){etWebsite.text?.let{etWebsite.setSelection(it.length)}}}
            etPhone.setOnFocusChangeListener{ _, isFocused ->
                if (isFocused){etPhone.text?.let{etPhone.setSelection(it.length)}}}
            etLatitude.setOnFocusChangeListener{ _, isFocused ->
                if (isFocused){etLatitude.text?.let{etLatitude.setSelection(it.length)}}}
            etLong.setOnFocusChangeListener{ _, isFocused ->
                if (isFocused){etLong.text?.let{etLong.setSelection(it.length)}}}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
            R.id.action_save -> sendData()
        }
        /*if (item.itemId == R.id.action_save){
            sendData()
        }else if (item.itemId == android.R.id.home){
            //  Esto sirve para regresar al menu principal pero no es una buena practica
            //      finish()
            //  Esta es una mejor practica
            onBackPressed()
        }*/
        return super.onOptionsItemSelected(item)
    }

    private fun sendData(){
        val intent = Intent()
        with(binding){
            intent.apply {
                putExtra(getString(R.string.key_name), etName.text.toString())
                putExtra(getString(R.string.key_email), etEmail.text.toString())
                putExtra(getString(R.string.key_website), etWebsite.text.toString())
                putExtra(getString(R.string.key_phone), etPhone.text.toString())
                putExtra(getString(R.string.key_latitude), etLatitude.text.toString().toDouble())
                putExtra(getString(R.string.key_longitude), etLong.text.toString().toDouble())
            }
        }
        /*
        intent.putExtra(getString(R.string.key_name), binding.etName.text.toString())
        intent.putExtra(getString(R.string.key_email), binding.etEmail.text.toString())
        intent.putExtra(getString(R.string.key_website), binding.etWebsite.text.toString())
        intent.putExtra(getString(R.string.key_phone), binding.etPhone.text.toString())
        intent.putExtra(getString(R.string.key_latitude), binding.etLatitude.text.toString().toDouble())
        intent.putExtra(getString(R.string.key_longitude), binding.etLong.text.toString().toDouble())
        */
        setResult(RESULT_OK, intent)
        finish()
    }
}