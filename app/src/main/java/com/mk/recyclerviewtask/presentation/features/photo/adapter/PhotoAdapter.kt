package com.mk.recyclerviewtask.presentation.features.photo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mk.recyclerviewtask.data.model.Photo
import com.mk.recyclerviewtask.databinding.RowPhotoItemLayoutBinding

class PhotoAdapter(var photoList: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val binding = RowPhotoItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context))
        context = parent.context
        return PhotoHolder(binding)
    }


    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bindPost(photoList, position)
    }

    class PhotoHolder(private val binding: RowPhotoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindPost(postList: List<Photo>, position: Int) {
            with(binding) {
                tvPhotoId.text = postList.get(position).id.toString()
                Glide.with(ivPhoto.context).load(postList.get(position).thumbnailUrl).into(ivPhoto)
            }

        }
    }


}