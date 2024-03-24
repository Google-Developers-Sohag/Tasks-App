package com.example.gdscsohag.ui.home

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.fragment.app.viewModels
import com.example.gdscsohag.MainActivity
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentHomeBinding
import com.example.gdscsohag.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutId = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewAppearance()
        viewModel.onClickTryAgain()
    }

    private fun setupViewAppearance() {
        (activity as MainActivity).apply {
            window.statusBarColor = getColor(R.color.background_color)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            }
            controlBottomNavVisibility(true)
        }
    }

}