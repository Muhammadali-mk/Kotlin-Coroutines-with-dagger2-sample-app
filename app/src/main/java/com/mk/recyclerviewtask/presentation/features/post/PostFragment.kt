package com.mk.recyclerviewtask.presentation.features.post

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.databinding.FragmentPostBinding
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.post.adapter.PostAdapter
import com.mk.recyclerviewtask.presentation.features.post.di.PostComponent
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class PostFragment : MvpAppCompatFragment(R.layout.fragment_post), PostView,
    PostAdapter.OnItemClickListener {
    /* @Inject
     @InjectPresenter
     lateinit var presenterProvider: Provider<PostPresenter>

     private val presenter by moxyPresenter { presenterProvider.get() }*/
    @Inject
    @InjectPresenter
    lateinit var presenter: PostPresenter

    lateinit var binding: FragmentPostBinding

    @ProvidePresenter
    fun provideFlowPresenter(): PostPresenter = presenter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        PostComponent.create().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostBinding.bind(view)
        presenter.getPosts()
        recyclerView = binding.recyclerView
    }

    override fun displayPosts(post: List<Post>) {
        setUpsRecyclerView(post)
    }

    private fun setUpsRecyclerView(postlist: List<Post>) {
        recyclerView.adapter = PostAdapter(postlist, this)
    }

    override fun onItemClick(view: View, position: Int) {
        view.findNavController()
            .navigate(
                PostFragmentDirections.actionPostToDetails()
                    .setPostId(position)
            )
    }
}
