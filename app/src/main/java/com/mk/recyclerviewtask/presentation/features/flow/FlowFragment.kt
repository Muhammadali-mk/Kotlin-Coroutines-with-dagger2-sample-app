package com.mk.recyclerviewtask.presentation.features.flow

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.mk.recyclerviewtask.R
import kotlinx.android.synthetic.main.fragment_flow.*
import moxy.MvpAppCompatFragment

class FlowFragment : MvpAppCompatFragment(R.layout.fragment_flow), FlowView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_one.setOnClickListener { findNavController().navigate(R.id.postFragment) }
        btn_two.setOnClickListener { findNavController().navigate(R.id.photoFragment) }
    }
}
