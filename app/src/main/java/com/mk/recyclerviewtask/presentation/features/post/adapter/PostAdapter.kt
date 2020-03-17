package com.mk.recyclerviewtask.presentation.features.post.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.databinding.RowPostItemLayoutBinding

class PostAdapter(var postList: List<Post>, private val cListener: OnItemClickListener) :
    RecyclerView.Adapter<PostAdapter.PostHolder>() {

    lateinit var binding: RowPostItemLayoutBinding

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = RowPostItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bindPost(postList, position, cListener)

    }

    class PostHolder(itemView: RowPostItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
        var userId = itemView.tvUserId
        var id = itemView.tvId
        var title = itemView.tvTitle
        var body = itemView.tvBody


        fun bindPost(postList: List<Post>, position: Int, cListener: OnItemClickListener) {
            userId.text = postList.get(position).userId.toString()
            id.text = postList.get(position).id.toString()
            title.text = postList.get(position).title
            body.text = postList.get(position).body
            cListener.onItemClick(itemView, position)
        }
    }

}