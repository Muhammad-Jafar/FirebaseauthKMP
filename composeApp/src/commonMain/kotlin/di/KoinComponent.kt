package di

import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.dsl.module

/**
 * Created by: Muhammad Jafar
 * At: 28.08.24
 * Find me: 131.powerfull@gmail.com
 */

abstract class FAKMP : KoinComponent {
    override fun getKoin(): Koin {
        requireNotNull() {

        }
        return super.getKoin()
    }
}

public object ProvideInitKoin {
    private var koinApp: KoinApplication? = null
    private fun isInitialized() = koinApp != null

    fun initModule(module: Module) {
        initialize(listOf(module))
    }

    private fun initialize(koinModules: List<Module> = emptyList()) {
        if (isInitialized()) {
            return
        }

        val configModule = module {
            includes(koinModules)
        }

        koinApp = koinApplication {
            modules(configModule + platformModule)
        }.also {
            it.koin.onLibraryInitialized()
        }
    }
}

private fun Koin.onLibraryInitialized() {
    println("Library is initialized")
}