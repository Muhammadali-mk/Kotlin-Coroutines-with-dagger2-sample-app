package com.mk.recyclerviewtask.presentation.features.photo

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mk.recyclerviewtask.R
import com.mk.recyclerviewtask.data.model.Photo
import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.photo.adapter.PhotoAdapter
import com.mk.recyclerviewtask.presentation.features.photo.di.PhotoComponent
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class PhotoFragment : MvpAppCompatFragment(R.layout.fragment_photo), PhotoView {

    @Inject
    @InjectPresenter
    lateinit var presenter: PhotoPresenter

    @ProvidePresenter
    fun providePhotoPresenter(): PhotoPresenter = presenter

    lateinit var recyclerView: RecyclerView

    override fun displayPhotos(photo: List<Photo>) {
        setUpRecyclerView(photo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        PhotoComponent.create(
            ApplicationComponent.createOrGet()
        ).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getPhotos()
        recyclerView = view.findViewById(R.id.recycler_view)
    }

    private fun setUpRecyclerView(photoList: List<Photo>) {
        recyclerView.adapter = PhotoAdapter(photoList)
    }
}
