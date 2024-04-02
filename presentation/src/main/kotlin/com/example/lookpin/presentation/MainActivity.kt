package com.example.lookpin.presentation

import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.lookpin.base.activity.BaseDataBindingActivity
import com.example.lookpin.navigation.Navigation
import com.example.lookpin.navigation.ktx.animNavigate
import com.example.lookpin.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseDataBindingActivity<ActivityMainBinding, MainViewModel, MainViewEffect>(
    ActivityMainBinding::inflate,
), Navigation {

    override val viewModel: MainViewModel by viewModels()

    override fun viewModelVariableId(): Int = BR.vm

    override fun initViews() = Unit

    override fun initEffectObserver(effect: MainViewEffect) = Unit

    override fun navigateToPhotoList() {
        val action = NavAppDirections.actionNavPhotoList()

        findNavController(binding.container.id).animNavigate(action)
    }
}
