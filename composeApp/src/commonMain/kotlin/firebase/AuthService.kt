package firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.GoogleAuthProvider
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * Created by: Muhammad Jafar
 * At: 31.08.24
 * Find me: 131.powerfull@gmail.com
 */

interface AuthService {
    suspend fun signInGoogle(): FirebaseUser
    suspend fun signOut()
}

class AuthServiceImpl(
    private val auth: FirebaseAuth = Firebase.auth
) : AuthService {
    override suspend fun signInGoogle(): FirebaseUser =
        runCatching {
            /*val gCredential = AuthCredentials("942900341061-io6md9l77jf1eqi7aaqrkuovaodbshuj.apps.googleusercontent.com")*/
            val credential = GoogleAuthProvider.credential(idToken = "", accessToken = null)

            auth.signInWithCredential(credential).user
                ?: throw Exception("Null user")
        }.fold(
            onSuccess = { it },
            onFailure = { throw it }
        )

    override suspend fun signOut() = auth.signOut()
}