package com.jetbrains.kmpapp.di

import dev.icerock.moko.permissions.PermissionsController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformSpecificModule: org.koin.core.module.Module = module {
    single {
        PermissionsController(androidContext())
    }
}