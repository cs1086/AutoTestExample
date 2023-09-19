package com.mouse.autotestexample

import android.app.Application
import com.mouse.autotestexample.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // 使用 androidContext() 函数傳遞 Android 上下文
            androidContext(this@MyApplication)
            // 指定 Koin 模块
            modules(mainModule)
        }
    }
}