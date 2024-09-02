package firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.GoogleAuthProvider
import dev.gitlive.firebase.auth.auth

/**
 * Created by: Muhammad Jafar
 * At: 31.08.24
 * Find me: 131.powerfull@gmail.com
 */

interface AuthService {
    suspend fun signInGoogle(): Result<User>
    suspend fun signOut()
}

class AuthServiceImpl(
    private val auth: FirebaseAuth = Firebase.auth,
) : AuthService {
    override suspend fun signInGoogle(): Result<User> =
        runCatching {
            val credential = ""
            val googleIdToken = ""
            val googleCredential = GoogleAuthProvider.credential(googleIdToken, null)
            val user = auth.signInWithCredential(googleCredential)
                .user ?: throw Exception("Null user")

            User(
                firebaseId = user.uid,
                email = user.email,
                displayName = user.displayName,
                profilePicUrl = user.photoURL,
            )
        }

    override suspend fun signOut() = auth.signOut()
}