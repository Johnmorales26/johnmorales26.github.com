package com.johndev.neurontraining.DialogFragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.content.Intent.createChooser
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.johndev.neurontraining.R
import com.johndev.neurontraining.databinding.DialogPrintBinding
import java.io.*


class DialogPrintFragment(private val onSubmitClickListener: (Float) -> Unit): DialogFragment() {

    private lateinit var binding: DialogPrintBinding

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
                saveData()
            }
        }
    }

    private fun saveData() {
        val url = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.results)
        val IS = File(url.toString())

        Toast.makeText(requireContext(), url.toString(), Toast.LENGTH_SHORT).show()
        var i = 0
        try {
            val writter = FileWriter(IS)
            do {
                writter.append("dsfvvsv")
                writter.append(",")
                writter.append("dsfvvsv")
                writter.append(",")
                writter.append("dsfvvsv")
                writter.append(",")
                writter.append("\n")
                i++
            } while (i <= 20)
            Toast.makeText(requireContext(), "Se escribio exitosamente", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Error Al Escribir", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    private fun sendData(nameFile: String, filePath: File) {
        var sendIntent = Intent(Intent.ACTION_SEND);
        sendIntent.setType("*/*");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Photo");
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(filePath.toString()));
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Enjoy the photo");
        startActivity(createChooser(sendIntent, "Send Email"));
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