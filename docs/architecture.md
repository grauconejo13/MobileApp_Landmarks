# Architecture

The app has one Android module, `app`. Its Kotlin sources live under [the app package](../app/src/main/java/com/example/comp304_lab5_torontolandmarks), with XML layouts in [res/layout](../app/src/main/res/layout).

| Screen | Responsibility |
| --- | --- |
| `MainActivity` | Shows the entry screen and opens the category list. |
| `LandmarkTypesActivity` | Displays landmark categories in a RecyclerView. The category adapter passes the selected type to the listing activity in an intent. |
| `LandmarkListingActivity` | Filters the bundled catalog by type. The listing adapter renders the results, loads photos with Picasso, and passes the selected `Landmark` to the map in an intent. |
| `MapActivity` | Reads the selected landmark, centers the map on its coordinates, and adds a marker with its name. |

`Landmark.kt` defines the serializable landmark model and the in-memory catalog. Each entry stores a name, category, address, coordinates, and an image URL. The catalog needs no backend. Photos and map tiles load over the network.

For build and Maps configuration, see the [README](../README.md).
