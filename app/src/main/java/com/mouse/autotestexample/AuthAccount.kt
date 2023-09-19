package com.mouse.autotestexample

import com.mouse.autotestexample.ui.login.ILoginRepository
class AuthManager {
    var userName = ""
    var password = ""

    //驗證帳密是否符合格式
    fun verify(): Boolean = userName.isNotBlank() && password.isNotBlank()
    suspend fun login(iLoginRepository: ILoginRepository) :Boolean{
        if (!verify()) return false
        return iLoginRepository.login(userName, password)
    }
}