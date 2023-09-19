package com.mouse.autotestexample

import kotlinx.coroutines.flow.flow

object LotteryManager {
    fun draw()=flow{
        (1..6).forEach {
            kotlinx.coroutines.delay(1000)
            emit(it)
        }
    }
}