package com.example.picsum.presentation

import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.picsum.base.activity.BaseDataBindingActivity
import com.example.picsum.feature.photolist.R
import com.example.picsum.navigation.Navigation
import com.example.picsum.navigation.ktx.animNavigate
import com.example.picsum.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseDataBindingActivity<ActivityMainBinding, MainViewModel, MainViewEffect>(
        ActivityMainBinding::inflate,
    ),
    Navigation {
    override val viewModel: MainViewModel by viewModels()

    override fun viewModelVariableId(): Int = BR.vm

    override fun initViews() = Unit

    override fun initEffectObserver(effect: MainViewEffect) = Unit

    override fun navigateToPhotoList() {
        val action = NavAppDirections.actionNavPhotoList()

        findNavController(binding.container.id).popBackStack(
            destinationId = R.id.nav_photo_list,
            inclusive = false,
        )
        findNavController(binding.container.id).animNavigate(directions = action)
    }

    override fun navigateToPhotoDetail(photoId: String) {
        val action = NavAppDirections.actionNavPhotoDetail(photoId = photoId)

        findNavController(binding.container.id).animNavigate(directions = action)
    }
}
