package com.example.gook.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gook.databinding.SearchFragmentBinding
import com.example.gook.ui.SearchViewModel
import kotlinx.android.synthetic.main.search_fragment.*

class SearchFragment : Fragment() {


    private val viewModel: SearchViewModel by lazy {
        val activity = requireNotNull(this.activity){

        }
        ViewModelProvider(this, SearchViewModel.Factory(activity.application)).get(SearchViewModel::class.java)
    }
    private lateinit var binding: SearchFragmentBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var searchedVolumeListAdapter: SearchedVolumeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SearchFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        searchedVolumeListAdapter = SearchedVolumeListAdapter()

        binding.searchedVolumesRV.adapter = searchedVolumeListAdapter

        binding.button.setOnClickListener {
            editSearchText?.let{
                viewModel.getSearchedVolumes(editSearchText.text.toString())
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.searchedVolumeList.observe(viewLifecycleOwner, Observer {
            it?.let {
                searchedVolumeListAdapter.submitList(it)
            }
        })


    }

}