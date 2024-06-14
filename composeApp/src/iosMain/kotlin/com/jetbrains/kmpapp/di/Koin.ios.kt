package com.jetbrains.kmpapp.di

import dev.icerock.moko.permissions.ios.PermissionsController
import dev.icerock.moko.permissions.ios.PermissionsControllerProtocol
import org.koin.dsl.module

actual val platformSpecificModule: org.koin.core.module.Module = module {
    factory <PermissionsControllerProtocol> {
        PermissionsController()
    }
    
}

