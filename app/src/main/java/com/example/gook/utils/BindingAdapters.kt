package com.example.gook.utils

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gook.R
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume


@BindingAdapter("imgUrl")
fun setUrltoImage(imageView: ImageView, url: String?){
    url?.let {

        val imgUrl = url.toUri().buildUpon().scheme("https").build()

        Glide.with(imageView.context)
                .load(imgUrl)
                .apply(RequestOptions()
                        .error(R.drawable.ic_connection_error)
                        .placeholder(R.drawable.loading_animation))
                .into(imageView)
    }
}