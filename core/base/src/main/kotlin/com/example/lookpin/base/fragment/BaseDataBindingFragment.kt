package com.example.lookpin.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lookpin.base.effect.ViewEffect
import com.example.lookpin.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

abstract class BaseDataBindingFragment<B : ViewDataBinding, VM : BaseViewModel<E>, E : ViewEffect>(
    private val bindingInflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToParent: Boolean) -> B,
) : Fragment() {
    protected var _binding: B? = null
    protected val binding: B
        get() = requireNotNull(_binding)

    protected abstract val viewModel: VM

    protected abstract fun viewModelVariableId(): Int?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            lifecycleOwner = viewLifecycleOwner
            viewModelVariableId()?.let { id -> setVariable(id, viewModel) }
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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun bind(block: B.() -> Unit) {
        binding.run(block)
    }

    protected fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
