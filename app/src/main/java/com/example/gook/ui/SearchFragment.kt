package com.example.gook.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.gook.R
import com.example.gook.databinding.LibraryFragmentBinding
import com.example.gook.databinding.SearchFragmentBinding
import kotlinx.android.synthetic.main.search_fragment.*

class SearchFragment : Fragment() {


    private val viewModel: SearchViewModel by lazy {
        val activity = requireNotNull(this.activity){

        }
        ViewModelProvider(this,SearchViewModel.Factory(activity.application)).get(SearchViewModel::class.java)
    }
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.button.setOnClickListener {
            editSearchText?.let{
                viewModel.getSearchedVolumes(editSearchText.text.toString())
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }

}