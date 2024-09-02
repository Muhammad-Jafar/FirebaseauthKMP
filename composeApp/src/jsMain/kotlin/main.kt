import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize
import org.jetbrains.skiko.wasm.onWasmReady

/**
 * Created by: Muhammad Jafar
 * At: 26.08.24
 * Find me: 131.powerfull@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    Firebase.initialize(
        options = FirebaseOptions(
            applicationId = "1:942900341061:web:1a8f712fcd44af2895762c",
            apiKey = "AIzaSyC3wTK8oVyLWAnRHXOKbgvtwppFNk1HAtQ",
            projectId = "kmp-fba"
        )
    )

    onWasmReady {
        CanvasBasedWindow(canvasElementId = "composeTarget") {
            App()
        }
    }
}