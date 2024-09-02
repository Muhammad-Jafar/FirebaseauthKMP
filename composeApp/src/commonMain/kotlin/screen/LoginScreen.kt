package screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import dev.gitlive.firebase.auth.FirebaseUser
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
            doLogin = { user ->
                val result = User(
                    firebaseId = user.uid,
                    displayName = user.displayName ?: "Null",
                    email = user.email ?: "Null",
                    profilePicUrl = user.photoURL ?: "Null"
                )
                updateResultState(result)
            }
        )
    }
}

@Composable
private fun SignInWithGoogle(
    doLogin: (FirebaseUser) -> Unit = {},
) {
    val scope = rememberCoroutineScope()
    val updateUserState by rememberUpdatedState(doLogin)

    SignInButton(
        onClick = {
            scope.launch {
                val user = AuthServiceImpl().signInGoogle()
                updateUserState(user)
            }
        }
    )
}