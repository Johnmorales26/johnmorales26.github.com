package com.johndev.neurontraining.DialogFragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.google.gson.Gson
import com.johndev.neurontraining.BottomOptions.BottomOptionsFragment
import com.johndev.neurontraining.Models.ResultsJSON
import com.johndev.neurontraining.OperationsGraphicsActivity.Companion.paintResults
import com.johndev.neurontraining.R
import com.johndev.neurontraining.databinding.DialogPrintBinding
import java.io.*


class DialogPrintFragment(private val onSubmitClickListener: (Float) -> Unit): DialogFragment() {

    private lateinit var binding: DialogPrintBinding
    private val CODE_PERMISSION_STORAGE = 3
    private lateinit var nameFile: String
    private lateinit var extensionFile: String

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogPrintBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        val dialog = builder.create()
        val nightModeFlags = requireContext().resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK
        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_YES -> {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
        configureButtons()
        return dialog
    }

    private fun configureButtons() {
        binding.btnSave.setOnClickListener {
            if (validFields()){
                nameFile = binding.etNameFile.text.toString().trim()
                extensionFile = binding.btnExtension.text.toString().trim()
                checkStoragePermission()
                ordenateAnswer()
            }
        }
        binding.btnExtension.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnExtension.text = data.name.toString().trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", "Extension")
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
    }

    private fun ordenateAnswer() {
        val resultList: MutableList<ResultsJSON> = ArrayList()
        var i = 0
        while (i < paintResults.size){
            resultList.add(ResultsJSON(paintResults[i].id, paintResults[i].valueW, paintResults[i].valueJW))
            i++
        }
        when (binding.btnExtension.text) {
            getString(R.string.file_extension_json) -> { createJSON(resultList) }
            getString(R.string.file_extension_csv) -> { createCSV(resultList) }
            getString(R.string.file_extension_txt) -> { createTXT(resultList) }
        }
    }

    private fun createJSON(resultList: MutableList<ResultsJSON>) {
        val gson = Gson()
        val exportJSON = gson.toJson(resultList)
        Log.i("JSON EXPORT", exportJSON.toString())
        writeToFile(exportJSON)
    }

    private fun createTXT(resultList: MutableList<ResultsJSON>) {
        var exportTXT = ""
        resultList.forEach {
            exportTXT += "Iteraciones: ${it.id} ---------- W: ${it.w} ---------- JW: ${it.jw}\n"
        }
        Toast.makeText(context, exportTXT, Toast.LENGTH_LONG).show()
        writeToFile(exportTXT)
    }

    private fun createCSV(resultList: MutableList<ResultsJSON>) {

    }

    private fun writeToFile(exportFile: String?) {
        val filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        Toast.makeText(context, "Guardando en $filePath", Toast.LENGTH_LONG).show()
        val file = File(filePath, "$nameFile$extensionFile".trim())
        if (!file.exists()){
            file.createNewFile()
        }
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(exportFile)
        bufferedWriter.close()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isEmpty()){
            return
        }
        if (requestCode == CODE_PERMISSION_STORAGE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //  Aqui se ha concedido el permiso
            } else {
                Toast.makeText(context, "Permiso de almacenamiento requerido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkStoragePermission(){
        val permissionState = context?.let { ContextCompat.checkSelfPermission(it, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) }
        if (permissionState == PackageManager.PERMISSION_GRANTED){
            //  Aqui se ha concedido el permiso
        } else {
            //  Si no, pedimos permisos.
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    CODE_PERMISSION_STORAGE
                )
            }
        }
    }

    private fun validFields(): Boolean {
        var isValid = true
        //  Evaluando value A
        if (binding.etNameFile.text.isNullOrEmpty()) {
            binding.tilNameFile.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilNameFile.error = null
        }
        return isValid
    }

}