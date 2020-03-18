package com.mk.recyclerviewtask.presentation.features.post.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.databinding.RowPostItemLayoutBinding

class PostAdapter(private val listener: (Post) -> Unit) :
    RecyclerView.Adapter<PostAdapter.PostHolder>() {
    private val list: MutableList<Post> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view: RowPostItemLayoutBinding =
            RowPostItemLayoutBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostHolder(view)
    }

    fun setPosts(collection: Collection<Post>) {
        list.apply { clear(); addAll(collection) }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class PostHolder(
        private val binding: RowPostItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.apply {
                tvUserId.text = post.userId.toString()
                tvId.text = post.id.toString()
                tvTitle.text = post.title
                tvBody.text = post.body
                root.setOnClickListener { listener(post) }
            }
        }
    }
}