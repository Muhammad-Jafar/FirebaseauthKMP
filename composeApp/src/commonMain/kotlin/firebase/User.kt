package firebase

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by: Muhammad Jafar
 * At: 26.08.24
 * Find me: 131.powerfull@gmail.com
 */

@Serializable
data class User(
    @SerialName("firebase-id")val firebaseId: String? = null,
    @SerialName("email")val email: String? = null,
    @SerialName("display-name")val displayName: String? = null,
    @SerialName("profile-picture")val profilePicUrl: String? = null
)