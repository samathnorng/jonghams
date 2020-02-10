package com.mini.jonghams.di


import com.mini.jonghams.viewModel.CommentViewModel
import com.mini.jonghams.viewModel.FoodSlideViewModel
import com.mini.jonghams.viewModel.FoodViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    viewModel { FoodViewModel() }

    viewModel { CommentViewModel() }

    viewModel { FoodSlideViewModel() }

}
val myAppModule = listOf(dataModule)