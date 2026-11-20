# Toronto Landmarks

A native Kotlin Android app built for COMP304 and refreshed as a portfolio demo. Browse Toronto-area landmarks by category, then open a landmark to see its location on Google Maps.

The app uses Android XML layouts, RecyclerView, and the Maps SDK for Android. The landmark catalog is bundled with the app. Photos load from external URLs, so some original photos may be unavailable. The catalog is a snapshot from the course project. Verify addresses before using it to plan a visit.

## Run locally

1. Open the repository root in Android Studio. Set the Gradle JDK to JDK 17 and install Android SDK Platform 34 and Android SDK Build-Tools 34.0.0 through SDK Manager.
2. Sync Gradle. To run the app, choose an Android 12 (API 31) or newer device with Google Play services, or an emulator with a Google Play image.
3. To load the map, enable Maps SDK for Android in a Google Cloud project and add your key to the root `local.properties` file alongside the SDK path. Restrict the key to Maps SDK for Android and to the app ID `com.example.comp304_lab5_torontolandmarks` with your debug signing certificate's SHA-1. The `signingReport` Gradle task prints that fingerprint.

   ```properties
   MAPS_API_KEY=your_key_here
   ```

   Git ignores `local.properties`. You can build and browse the catalog without a key. Map tiles require a valid key and an internet connection.

From the repo root, build the debug APK and run the local catalog regression tests:

```sh
./gradlew :app:assembleDebug :app:testDebugUnitTest
```

On Windows, use `gradlew.bat` in place of `./gradlew`.

## Try the demo

Open the app, choose **Attractions**, and tap **CN Tower**. Confirm that the map loads and the marker identifies the CN Tower. Press Back to return to the landmark list.

See [Architecture](docs/architecture.md) for the screen flow and source locations. The unit tests also guard the bundled catalog against duplicate landmark names, invalid coordinates, missing required fields, non-HTTPS image URLs, category/navigation drift, empty category screens, and accidental breakage of the documented CN Tower demo path.
