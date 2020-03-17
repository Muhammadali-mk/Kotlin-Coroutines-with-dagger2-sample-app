package com.mk.recyclerviewtask.presentation.features.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.android.synthetic.main.fragment_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class DetailsFragment : MvpAppCompatFragment(R.layout.fragment_details), DetailsView {

/*    @Inject
    @InjectPresenter
    lateinit var presenterProvider: Provider<DetailsPresenter>

    private val presenter by moxyPresenter {
        presenterProvider.get()
    }*/

    @Inject
    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    @ProvidePresenter
    fun providePresenter(): DetailsPresenter = presenter
        .apply { postId = fragmentArgs.postId }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        arguments?.let {
//            post_details.text =
//                presenter.getPostById(
//                    DetailsFragmentArgs.fromBundle(it)
//                        .postId
//                ).toString()
//        }

        presenter.getPostById()
    }

    override fun onPostGet(post: Post) {

    }

    private val fragmentArgs: DetailsFragmentArgs by lazy {
        navArgs<DetailsFragmentArgs>().value
    }
}
