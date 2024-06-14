# Showcase - moko-permissions issue with requesting BLE permissions 

This example is based on basic Kotlin Multiplatform app template for Android and iOS, that includes shared business logic and data handling, and a shared UI implementation using Compose Multiplatform.

At this point there are several issues with the permission request logic.

### Andoid Specific issues
Environment: Pixel 6, running Vanilla Ice Cream, Build number AP31.240426.023.B4, Android Studio Koala [2024.1.1 Beta 2] / Fleet 1.36.103, Kotlin 2.0.0, Moko Resources 0.18.0  

1. When requesting Permission.BLUETOOTH_LE, it always returns Denied, even if it's allowed from the app settings. Although when requesting Permission.BLUETOOTH_SCAN, everything works as expected

### iOS specific issues
Environment: iPhone 12 Pro, running iOS 17.5.1, Xcode Version 15.4 (15F31d) / Fleet 1.36.103, Kotlin 2.0.0, Moko Resources 0.18.0

1. When requesting any of Permission.BLUETOOTH_LE / Permission.BLUETOOTH_SCAN / Permission.BLUETOOTH_CONNECT, moko-permissions always returns NotDetermined. After digging a bit deeper, it seems like CBManager().state always returns CBManagerState.unknown. The system dialog appears on the first check and the permissiong is displayed under system settings (Settings -> Privacy & Security -> Bluetooth -> KMP App is Enabled)

### App Dependencies
The app uses the following multiplatform dependencies in its implementation:

- [Compose Multiplatform](https://jb.gg/compose) for UI
- [Moko Permissions](https://github.com/icerockdev/moko-permissions) for permissions request management
- [Koin](https://github.com/InsertKoinIO/koin) for dependency injection
- [Voyager](https://github.com/adrielcafe/voyager) for navigation and screen models
