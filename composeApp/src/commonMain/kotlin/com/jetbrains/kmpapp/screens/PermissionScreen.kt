package com.jetbrains.kmpapp.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.jetbrains.kmpapp.screens.PermissionsScreenModel
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.compose.BindEffect

data object PermissionScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<PermissionsScreenModel>()

        // Binds the permissions controller to the LocalLifecycleOwner lifecycle.
        BindEffect(viewModel.permissionsController)

        val blePermissionState = remember { viewModel.permissionsState }


        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 8.dp),
                onClick = {
                    viewModel.checkPermissions()
                }
            ) {
                Text(text = "check permissions")
            }

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 8.dp),
                onClick = {
                    viewModel.requestPermission()
                }
            ) {
                Text(text = "give permissions")
            }

            Text(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                textAlign = TextAlign.Center,
                text = "Bluetooth permission state - ${blePermissionState.value}"
            )
        }
    }
}
