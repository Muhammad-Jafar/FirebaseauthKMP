package screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import firebase.AuthServiceImpl
import firebase.User
import kotlinx.coroutines.launch
import widget.CardWrapper
import widget.SignInButton

/**
 * Created by: Muhammad Jafar
 * At: 26.08.24
 * Find me: 131.powerfull@gmail.com
 */

@Composable
fun LoginScreen(
    onLogin: (User) -> Unit = {}
) {
    val updateResultState by rememberUpdatedState(onLogin)

    CardWrapper {
        Text("Welcome folks :)")
        SignInWithGoogle(
            doLogin = { updateResultState(it) }
        )
    }
}

@Composable
private fun SignInWithGoogle(
    doLogin: (User) -> Unit = {},
) {
    val scope = rememberCoroutineScope()
    val updateUserState by rememberUpdatedState(doLogin)

    SignInButton(
        onClick = {
            scope.launch {
                AuthServiceImpl().signInGoogle()
                    .onSuccess { updateUserState(it) }
                    .onFailure { throw it }
            }
        }
    )
}