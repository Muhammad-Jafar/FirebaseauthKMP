package id.arizona.fak.page

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource

import firebaseauthkmp.composeapp.generated.resources.Res
import firebaseauthkmp.composeapp.generated.resources.compose_multiplatform
import id.arizona.fuk.widget.WelcomeButton

@Composable
fun Welcome() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WelcomeButton(
                onClick = {
                    showContent = !showContent
                }
            )

            AnimatedVisibility(showContent) {
                val greeting = remember { "Hello, World! Kotlin/Wasm" }

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(Res.drawable.compose_multiplatform),
                        null
                    )
                    Text("Compose: $greeting")

                }
            }
        }
    }
}
