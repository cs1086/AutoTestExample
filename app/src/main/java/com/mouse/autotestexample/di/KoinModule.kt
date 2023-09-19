package com.mouse.autotestexample.di

import com.mouse.autotestexample.ui.login.ILoginRepository
import com.mouse.autotestexample.ui.login.LoginViewModel
import com.mouse.autotestexample.ui.login.MockLoginRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<ILoginRepository> { MockLoginRepository() }
    viewModel { LoginViewModel(get()) }
}