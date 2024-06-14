package com.jetbrains.kmpapp.screens

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.PermissionsController
import kotlinx.coroutines.launch

class PermissionsScreenModel(
    val permissionsController: PermissionsController
) : ScreenModel {
    
    val permissionsState = mutableStateOf(PermissionState.NotDetermined)
    private val permissionToAsk = Permission.BLUETOOTH_LE
    
    fun checkPermissions() {
        screenModelScope.launch {
            permissionsState.value = permissionsController.getPermissionState(permissionToAsk)
        }
    }
    
    fun requestPermission() {
        screenModelScope.launch {
            try {
                permissionsController.providePermission(permissionToAsk)
                // Permission has been granted successfully.
            } catch(deniedAlways: DeniedAlwaysException) {
                // Permission is always denied.
            } catch(denied: DeniedException) {
                // Permission was denied.
            }
            
            permissionsState.value = permissionsController.getPermissionState(permissionToAsk)
        }
    }
}