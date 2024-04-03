package com.example.lookpin.feature.photolist

import android.view.View
import androidx.fragment.app.viewModels
import com.example.lookpin.base.fragment.BaseDataBindingFragment
import com.example.lookpin.feature.photolist.adapter.PhotoListAdapter
import com.example.lookpin.feature.photolist.databinding.FragmentPhotoListBinding
import com.example.lookpin.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListFragment : BaseDataBindingFragment<FragmentPhotoListBinding, PhotoListViewModel, PhotoListViewEffect>(
    FragmentPhotoListBinding::inflate,
) {

    override val viewModel: PhotoListViewModel by viewModels()

    override fun viewModelVariableId(): Int = BR.vm

    override fun initViews() {
        binding.photoList.adapter =
            PhotoListAdapter(
                onClick = {
            }
                },
                onChecked = {
                    viewModel.checkedPhoto(it)
                },
            )
    }

    override fun initEffectObserver(effect: PhotoListViewEffect) {
        when (effect) {
            is PhotoListViewEffect.Error -> {
                binding.successGroup.visibility = View.GONE
                binding.failureGroup.visibility = View.VISIBLE
            }

            PhotoListViewEffect.Success -> {
                binding.successGroup.visibility = View.VISIBLE
                binding.failureGroup.visibility = View.GONE
            }
        }
    }
}
