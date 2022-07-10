package com.johndev.tmdb_guide.SearchData.SearchActor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.tmdb_guide.DetailsActor.DetailsActorActivity
import com.johndev.tmdb_guide.Interfaces.OnPressedSearch
import com.johndev.tmdb_guide.R
import com.johndev.tmdb_guide.SearchData.SearchCommon.SearchAdapter
import com.johndev.tmdb_guide.SearchData.SearchCommon.SearchData
import com.johndev.tmdb_guide.SearchData.SearchCommon.SearchValues
import com.johndev.tmdb_guide.databinding.FragmentSearchActorBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class SearchActorFragment : Fragment(), OnPressedSearch {

    private var _binding: FragmentSearchActorBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SearchAdapter
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchActorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val searchActor = SearchValues(requireActivity(), requireContext())
        configureButton(searchActor)
    }

    private fun configureButton(searchActor: SearchValues) {
        binding.btnSearch.setOnClickListener {
            if (validFields()){
                adapter.deleteAll()
                val company = binding.etAutoComplete.text.toString().lowercase(Locale.ROOT).trim()
                binding.btnMore.visibility = View.VISIBLE
                searchDB(searchActor, company)
            }
        }
        binding.btnMore.setOnClickListener {
            page++
            val company = binding.etAutoComplete.text.toString().lowercase(Locale.ROOT).trim()
            searchDB(searchActor, company, page)
        }
    }

    private fun searchDB(searchActor: SearchValues, company: String, page: Int = 1) {
        lifecycleScope.launch(Dispatchers.Default) {
            searchActor.getDataActor(company, page, adapter)
        }
    }

    private fun setupRecyclerView() {
        val data: MutableList<SearchData> = mutableListOf()
        binding.let {
            adapter = SearchAdapter(data, this)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = this@SearchActorFragment.adapter
            }
        }
    }

    override fun onSearchPressed(data: SearchData) {
        val intent = Intent(context, DetailsActorActivity::class.java).apply {
            putExtra(getString(R.string.key_actor_passed), data.id.toString().trim())
        }
        startActivity(intent)
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etAutoComplete.text.isNullOrEmpty()){
            binding.tilSearch.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSearch.error = null
        }
        return isValid
    }
}