package com.example.picsum.feature.photolist

import android.view.View
import androidx.fragment.app.viewModels
import com.example.picsum.base.fragment.BaseDataBindingFragment
import com.example.picsum.feature.photolist.adapter.PhotoListAdapter
import com.example.picsum.feature.photolist.databinding.FragmentPhotoListBinding
import com.example.picsum.navigation.Navigation
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
                    val photoId = it.id
                    (requireActivity() as? Navigation)?.navigateToPhotoDetail(photoId)
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
