package com.mk.recyclerviewtask.presentation.features.post

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.databinding.FragmentPostBinding
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.post.adapter.PostAdapter
import com.mk.recyclerviewtask.presentation.features.post.di.PostComponent
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class PostFragment : MvpAppCompatFragment(R.layout.fragment_post), PostView {

    @Inject
    lateinit var presenterProvider: Provider<PostPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var binding: FragmentPostBinding

    private val adapter: PostAdapter =
        PostAdapter {
            if (findNavController().currentDestination?.id == R.id.postFragment) {
                findNavController()
                    .navigate(PostFragmentDirections.actionPostToDetails().setPostId(it.userId))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        PostComponent.create(ApplicationComponent.get()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostBinding.bind(view).apply {
            recyclerView.adapter = adapter
        }
        presenter.getPosts()
    }

    override fun displayPosts(post: List<Post>) {
        adapter.setPosts(post)
    }
}
