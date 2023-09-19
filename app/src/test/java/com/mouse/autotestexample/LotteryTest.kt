package com.mouse.autotestexample

import app.cash.turbine.test
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class LotteryTest {
    @Test
    fun draw() {
        runBlocking {
            LotteryManager.draw().test {
                assertEquals(1, awaitItem())
                assertEquals(2, awaitItem())
                assertEquals(3, awaitItem())
                assertEquals(4, awaitItem())
                assertEquals(5, awaitItem())
                assertEquals(6, awaitItem())
                awaitComplete()
            }
        }

    }
}