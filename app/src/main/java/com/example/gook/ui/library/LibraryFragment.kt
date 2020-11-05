package com.example.gook.ui.library

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gook.R
import com.example.gook.databinding.LibraryFragmentBinding
import com.example.gook.viewmodel.LibraryViewModel

class LibraryFragment : Fragment() {


    private val viewModel: LibraryViewModel by lazy {
        val activity = requireNotNull(this.activity){

        }

        ViewModelProvider(this, LibraryViewModel.Factory(app = activity.application)).get(
            LibraryViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: LibraryFragmentBinding = DataBindingUtil.inflate(
                        inflater,
                        R.layout.library_fragment,
                        container,
            false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        //Burada fragment ile alakali view hiyerarşi hazırlanması bittiğinde buraya gelir data observe etmeler burada yapılabilir
    }
}


