package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //  Creacion he inicializacion de variables
    private lateinit var binding: ActivityMainBinding
    private var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  Aisgna el valor de la variable count en el contador
        binding.tcCount.text = count.toString()
        setCount()
        binding.btnSum.setOnClickListener {
            count++
            setCount()
        }
        binding.btnSum.setOnLongClickListener{
            count = 0
            setCount()
            true
        }
    }
    //  Refresca los valores
    private fun setCount() {
        binding.tcCount.text = count.toString()
    }
    //  Guarda el valor para que despues pueda ser restaurado
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run{
            putInt(PARAM_COUNT, count)
        }
        super.onSaveInstanceState(outState)
    }
    //  Restaura el valor para cuando cambia algo en la app
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(PARAM_COUNT)
        setCount()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val PARAM_COUNT:String = "parar_count"
    }

    //  Methods for lifeCycle
    override fun onStart() {
        super.onStart()
        Log.i("LifeCicle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCicle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCicle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCicle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCicle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCicle", "onDestroy")
        Toast.makeText(this, "App Life Cycle ha finalizado...", Toast.LENGTH_SHORT).show()
    }
}