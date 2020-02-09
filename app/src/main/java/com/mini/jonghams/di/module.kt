package com.mini.jonghams.di


import com.mini.jonghams.viewModel.CommentViewModel
import com.mini.jonghams.viewModel.ProductViewModel
import com.mini.jonghams.viewModel.SlideViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    viewModel { ProductViewModel() }

    viewModel { CommentViewModel() }

    viewModel { SlideViewModel() }

}
val myAppModule = listOf(dataModule)