/**
 * Created by: Muhammad Jafar
 * At: 26.08.24
 * Find me: 131.powerfull@gmail.com
 */

class JsPlatform : Platform {
    override val name = "Kotlin/JS for compose web"
}

actual fun getPlatform(): Platform = JsPlatform()