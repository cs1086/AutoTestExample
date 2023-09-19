package com.mouse.autotestexample

import com.mouse.autotestexample.ui.login.ILoginRepository
import com.mouse.autotestexample.ui.login.MockLoginRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthManagerTest {
    lateinit var authManager:AuthManager

    @Test
    fun verify() {

        authManager.apply {
            userName="mouse"
            password="abc123"
        }
        Assert.assertTrue(authManager.verify())
        authManager.apply {
            userName=""
            password=""
        }
        Assert.assertFalse(authManager.verify())
    }

//    @MockK
//    lateinit var iLoginRepository:ILoginRepository
    @SpyK
    val iLoginRepository=MockLoginRepository()
    @Before
    fun setUp() {
        authManager=AuthManager()
        MockKAnnotations.init(this)
    }
    @Test
    fun login() {
        coEvery { iLoginRepository.login(any(),any()) }.returns(true)
        authManager.apply {
            userName="mouse"
            password="abc123"
        }

        runBlocking {
            Assert.assertTrue(authManager.login(iLoginRepository))
        }
        coEvery { iLoginRepository.login(any(),any()) }.returns(false)
        authManager.apply {
            userName="mouse1"
            password="abc1234"
        }
        runBlocking {
            Assert.assertFalse(authManager.login(iLoginRepository))
        }
    }
}