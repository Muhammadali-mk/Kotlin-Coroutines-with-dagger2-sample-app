package com.mk.recyclerviewtask.presentation.features.photo

import android.os.Bundle
import android.view.View
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.photo.Photo
import com.mk.recyclerviewtask.databinding.FragmentPhotoBinding
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.photo.adapter.PhotoAdapter
import com.mk.recyclerviewtask.presentation.features.photo.di.PhotoComponent
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class PhotoFragment : MvpAppCompatFragment(R.layout.fragment_photo), PhotoView {

    @Inject
    lateinit var presenterProvider: Provider<PhotoPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    lateinit var binding: FragmentPhotoBinding

    private val adapter: PhotoAdapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        PhotoComponent.create(ApplicationComponent.get()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoBinding.bind(view).apply {
            recyclerView.adapter = adapter
        }
    }

    override fun displayPhotos(photo: List<Photo>) {
        binding.progressBar.visibility = View.GONE
        adapter.setPhotos(photo)
    }

    override fun onLoadingPhotos() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onFailurePhotos(throwable: Throwable) {

    }
}
