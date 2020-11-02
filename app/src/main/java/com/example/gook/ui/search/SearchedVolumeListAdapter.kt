package com.example.gook.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gook.databinding.SearchedVolumeItemBinding
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume

class SearchedVolumeListAdapter(): ListAdapter<SearchedVolume, SearchedVolumeListAdapter.VolumeViewHolder>(SearchedVolumeItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolumeViewHolder {
        return VolumeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder:VolumeViewHolder, position: Int) {

        val item = getItem(position) as SearchedVolume
        holder.bind(item)
    }

    class VolumeViewHolder private constructor(val binding:SearchedVolumeItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(searchedVolumeItem: SearchedVolume){
            binding.searchedVolumeItem = searchedVolumeItem
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): VolumeViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SearchedVolumeItemBinding.inflate(
                        layoutInflater,
                        parent,
                        false)
                return VolumeViewHolder(binding)
            }
        }
    }

}

class SearchedVolumeItemDiffCallback: DiffUtil.ItemCallback<SearchedVolume>(){
    override fun areItemsTheSame(oldItem: SearchedVolume, newItem: SearchedVolume): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchedVolume, newItem: SearchedVolume): Boolean {
        return oldItem == newItem
    }
}