package com.mouse.autotestexample.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(loginViewModel: LoginViewModel) {
    val userName by loginViewModel.userName.collectAsState()
    val password by loginViewModel.password.collectAsState()
    val isLoginSuccess by loginViewModel.isLoginSuccess.collectAsState()
    if (isLoginSuccess) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text("驗證成功", modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("帳號")
                Spacer(modifier = Modifier.width(5.dp))
                TextField(value = userName, onValueChange = {
                    loginViewModel.setUserName(it)
                })
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("密碼")
                Spacer(modifier = Modifier.width(5.dp))
                TextField(value = password, onValueChange = {
                    loginViewModel.setPassword(it)
                })
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { loginViewModel.login() }) {
                Text("登入")
            }
        }
    }
}