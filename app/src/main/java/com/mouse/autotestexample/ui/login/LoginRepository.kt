package com.mouse.autotestexample.ui.login

interface ILoginRepository {
    suspend fun login(userName: String, password: String): Boolean
}

class MockLoginRepository : ILoginRepository {
    override suspend fun login(userName: String, password: String) =
        (userName == "mouse" && password == "abc123")
}
