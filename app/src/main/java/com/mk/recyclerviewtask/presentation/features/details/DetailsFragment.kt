package com.mk.recyclerviewtask.presentation.features.details

import android.os.Bundle
import android.view.View
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.databinding.FragmentDetailsBinding
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.details.di.DetailsComponent
import kotlinx.android.synthetic.main.fragment_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class DetailsFragment : MvpAppCompatFragment(R.layout.fragment_details), DetailsView {

    @Inject
    lateinit var presenterProvider: Provider<DetailsPresenter>

    private val presenter by moxyPresenter {
        presenterProvider.get().also {
            it.id = DetailsFragmentArgs.fromBundle(checkNotNull(arguments)).postId
        }
    }

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DetailsComponent.create(ApplicationComponent.get()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailsBinding.bind(view)
    }

    override fun onFailurePost(throwable: Throwable) {

    }

    override fun onLoadingPost() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onSuccessPost(post: Post) {
        with(binding){
            progressBar.visibility = View.GONE
            post_details.text = post.toString()
        }
    }

}
