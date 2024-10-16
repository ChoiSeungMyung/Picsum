package com.example.picsum.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.picsum.base.effect.ViewEffect
import com.example.picsum.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

abstract class BaseDataBindingActivity<B : ViewDataBinding, VM : BaseViewModel<E>, E : ViewEffect>(
    private val bindingInflater: (layoutInflater: LayoutInflater) -> B,
) : AppCompatActivity() {
    protected lateinit var binding: B
        private set

    protected abstract val viewModel: VM

    protected abstract fun viewModelVariableId(): Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)

        bind {
            lifecycleOwner = this@BaseDataBindingActivity
            viewModelVariableId()?.let { variableId ->
                setVariable(variableId, viewModel)
            }
        }

        initViews()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    it?.let { initEffectObserver(it) }
                    viewModel.clearEffect()
                }
            }
        }
    }

    protected abstract fun initViews()

    protected abstract fun initEffectObserver(effect: E)

    protected fun bind(block: B.() -> Unit) {
        binding.run(block)
    }
}
