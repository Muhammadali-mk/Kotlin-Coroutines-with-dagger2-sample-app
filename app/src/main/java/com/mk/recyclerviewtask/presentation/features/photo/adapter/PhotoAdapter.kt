package com.mk.recyclerviewtask.presentation.features.photo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mk.recyclerviewtask.data.model.photo.Photo
import com.mk.recyclerviewtask.databinding.RowPhotoItemLayoutBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    private val list: MutableList<Photo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view: RowPhotoItemLayoutBinding =
            RowPhotoItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return PhotoHolder(view)
    }

    fun setPhotos(collection: Collection<Photo>) {
        list.apply { clear();addAll(collection) }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) =
        holder.bind(list[position])

    class PhotoHolder(
        private val binding: RowPhotoItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.apply {
                tvPhotoId.text = photo.id.toString()
                Glide.with(ivPhoto.context).load(photo.thumbnailUrl).into(ivPhoto)
            }
        }
    }
}