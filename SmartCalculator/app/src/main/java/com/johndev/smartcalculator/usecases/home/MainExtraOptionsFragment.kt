package com.johndev.smartcalculator.usecases.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMainExtraOptionsBinding
import com.johndev.smartcalculator.usecases.Adapters.ExtraOptionsAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListenerExtraOptions
import com.johndev.smartcalculator.usecases.base.ExtraOptions
import com.johndev.smartcalculator.usecases.common.OperationHistoryActivity

class MainExtraOptionsFragment : Fragment(), OnClickListenerExtraOptions {

    private var _binding: FragmentMainExtraOptionsBinding? = null
    private val binding get() = _binding!!
    private lateinit var extraOptionsAdapter: ExtraOptionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainExtraOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = data("Algebra")
        extraOptionsAdapter = ExtraOptionsAdapter(data, this)
        binding.rvExtraOptions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = extraOptionsAdapter
        }

    }

    override fun onClick(functionalities: ExtraOptions, imgPhoto: View, tvNombre: View) {
        val intent = Intent(context, OperationHistoryActivity::class.java)
        /*ities.img.toString())
            putExtra(getString(R.string.key_function_name), functionalities.Nombre)
        }
        val imgPair: Pair<View, String> = Pair.create(imgPhoto, imgPhoto.transitionName.toString())
        val namePair: Pair<View, String> = Pair.create(tvNombre, tvNombre.transitionName)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(
                activity,
                imgPair, namePair
            )
            .toBundle()
        startActivity(intent, options)*/
        startActivity(intent)
    }

    private fun data(typeData: String): MutableList<ExtraOptions> {
        val data: MutableList<ExtraOptions> = mutableListOf(
                ExtraOptions(R.drawable.history, getString(R.string.title_history_operations))
            );
        return data
    }
}