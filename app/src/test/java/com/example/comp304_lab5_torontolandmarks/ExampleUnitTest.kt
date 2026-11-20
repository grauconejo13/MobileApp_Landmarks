package com.example.comp304_lab5_torontolandmarks

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LandmarkCatalogTest {

    @Test
    fun catalog_hasUniqueNamesAndValidCoordinates() {
        val landmarks = Landmarks.LANDMARKS

        assertTrue("Catalog should not be empty", landmarks.isNotEmpty())
        assertEquals(
            "Landmark names should be unique",
            landmarks.size,
            landmarks.map { it.name }.distinct().size
        )

        landmarks.forEach { landmark ->
            assertTrue("${landmark.name} latitude is out of range", landmark.lat in -90.0..90.0)
            assertTrue("${landmark.name} longitude is out of range", landmark.long in -180.0..180.0)
        }
    }

    @Test
    fun catalog_entriesHaveRequiredPortfolioFields() {
        Landmarks.LANDMARKS.forEach { landmark ->
            assertTrue("${landmark.name} needs a type", landmark.type.isNotBlank())
            assertTrue("${landmark.name} needs an address", landmark.address.isNotBlank())
            assertTrue(
                "${landmark.name} image should use HTTPS",
                landmark.image.startsWith("https://")
            )
        }
    }

    @Test
    fun navigationCategories_matchCatalogAndRemainPopulated() {
        val categories = Landmarks.TYPES
        val catalogTypes = Landmarks.LANDMARKS.map { it.type }.toSet()

        assertTrue("Navigation categories should not be empty", categories.isNotEmpty())
        assertEquals(
            "Navigation categories should be unique",
            categories.size,
            categories.distinct().size
        )
        assertEquals(
            "Every catalog type should be reachable from the category screen",
            catalogTypes,
            categories.toSet()
        )

        categories.forEach { category ->
            assertTrue(
                "$category should open a non-empty landmark list",
                Landmarks.LANDMARKS.any { it.type == category }
            )
        }
    }

    @Test
    fun demoPath_containsCnTowerInAttractions() {
        val attractions = Landmarks.LANDMARKS.filter { it.type == "Attractions" }

        assertTrue(
            "README demo path expects CN Tower in Attractions",
            attractions.any { it.name == "CN Tower" }
        )
    }
}
