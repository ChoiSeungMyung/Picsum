package com.example.lookpin.feature.photolist

import androidx.fragment.app.viewModels
import com.example.lookpin.base.fragment.BaseDataBindingFragment
import com.example.lookpin.feature.photolist.adapter.PhotoListAdapter
import com.example.lookpin.feature.photolist.databinding.FragmentPhotoListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListFragment : BaseDataBindingFragment<FragmentPhotoListBinding, PhotoListViewModel, PhotoListViewEffect>(
    FragmentPhotoListBinding::inflate,
) {

    override val viewModel: PhotoListViewModel by viewModels()

    override fun viewModelVariableId(): Int = BR.vm

    override fun initViews() {
        binding.photoList.adapter =
            PhotoListAdapter {

            }
    }

    override fun initEffectObserver(effect: PhotoListViewEffect) {
        when (effect) {

            else -> {}
        }
    }
}
