package com.mk.recyclerviewtask.presentation.features.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.details.di.DetailsComponent
import com.mk.recyclerviewtask.presentation.features.post.di.PostComponent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        DetailsComponent.create(ApplicationComponent.get()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onLoadingPost() {
    }

    override fun onSuccessPost(post: Post) {
    }

    override fun onFailurePost(throwable: Throwable) {
    }

}
