package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.screens.PermissionsScreenModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

expect val platformSpecificModule: org.koin.core.module.Module

val screenModelsModule = module {
    factoryOf(::PermissionsScreenModel)
}

fun initKoin(
    preInit: KoinApplication.() -> Unit = {}
) {
    startKoin {
        preInit()
        modules(
            platformSpecificModule,
            screenModelsModule,
        )
    }
}
