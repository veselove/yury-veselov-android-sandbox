package com.veselove.myapplication211021.ex_001_flow

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.veselove.myapplication211021.R
import com.veselove.myapplication211021.databinding.Ex001FlowBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity()  {

    private lateinit var binding: Ex001FlowBinding

    @ExperimentalCoroutinesApi
    private val viewModel: FlowMainViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = Ex001FlowBinding.inflate(layoutInflater)
        setContentView(binding.root)  //R.layout.ex_001_flow

        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString()
            )
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                when(it) {
                    is FlowMainViewModel.LoginUiState.Success -> {
                        Snackbar.make(
                            binding.root,
                            "Successfully logged in",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    is FlowMainViewModel.LoginUiState.Error -> {
                        Snackbar.make(
                            binding.root,
                            it.message,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    is FlowMainViewModel.LoginUiState.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    else -> Unit
                }
            }
        }
    }

}