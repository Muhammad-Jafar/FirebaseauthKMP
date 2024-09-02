package id.arizona.fuk.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import firebaseauthkmp.composeapp.generated.resources.Res
import firebaseauthkmp.composeapp.generated.resources.google_icon
import org.jetbrains.compose.resources.painterResource

/**
 * Created by: Muhammad Jafar
 * At: 23.08.24
 * Find me: 131.powerfull@gmail.com
 */

@Composable
fun WelcomeButton(
    onClick: () -> Unit = {}
) {
    Button(
        modifier = Modifier.wrapContentSize(),
        onClick = { onClick.invoke() }
    ) {
        Image(
            painter = painterResource(Res.drawable.google_icon),
            contentDescription = "icon logo",
            modifier = Modifier.size(16.dp)
        )
        Spacer(Modifier.size(4.dp))
        Text(text = "Continue with google")
    }
}