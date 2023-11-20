package com.example.comp304_lab5_torontolandmarks

import java.io.Serializable

data class Landmark(
    val name: String,
    val type: String,
    val address: String,
    val lat: Double,
    val long: Double,
    val image: String):Serializable

object Landmarks {
    val LANDMARKS = listOf(
        Landmark(
            name = "Casa Loma",
            type = "Old Building",
            address = "1 Austin Terrace, Toronto, ON M5R 1M7",
            lat = 43.67821,
            long = -79.40945,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/3a/0a/7b/casa-loma-gardens.jpg?w=2000&h=-1&s=1"
        ),
        Landmark(
            name = "CN Tower",
            type = "Attractions",
            address = "301 Front St W, Toronto, ON M5V 3L9",
            lat = 43.64271,
            long = -79.38707,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/daodao/photo-o/10/9d/ed/bb/caption.jpg?w=1600&h=-1&s=1"
        ),
        Landmark(
            name = "Royal Ontario Museum",
            type = "Museum",
            address = "100 Queen's Park, Toronto, ON M5S 2C6",
            lat = 43.66790,
            long = -79.39480,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/d1/cc/b1/canada-s-most-visited.jpg?w=1400&h=-1&s=1"
        ),
        Landmark(
            name = "Art Gallery of Ontario",
            type = "Museum",
            address = "317 Dundas St W, Toronto, ON M5T 1G4",
            lat = 43.65371,
            long = -79.39246,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/33/2a/71/fb-img-1551884149578.jpg?w=1000&h=-1&s=1"
        ),
        Landmark(
            name = "Ripley's Aquarium of Canada",
            type = "Attractions",
            address = "288 Bremner Blvd, Toronto, ON M5V 3L9",
            lat = 43.64282,
            long = -79.38606,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/37/cb/b2/dive-show.jpg?w=1200&h=-1&s=1"
        ),
        Landmark(
            name = "St. Lawrence Market",
            type = "Old Building",
            address = "Toronto, ON M5E 1C3",
            lat = 43.64876,
            long = -79.37155,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/55/de/c5/outside-shot-of-st-lawrence.jpg?w=2000&h=-1&s=1"
        ),
        Landmark(
            name = "Ontario Science Centre",
            type = "Museum",
            address = "770 Don Mills Rd., North York, ON M3C 1T3",
            lat = 43.71715,
            long = -79.33894,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/8e/1d/23/front-amphitheatre-steps.jpg?w=1400&h=-1&s=1"
        ),
        Landmark(
            name = "Distillery Historic District",
            type = "Old Building",
            address = "55 Mill St, Toronto, ON M5A 3C4",
            lat = 43.65045,
            long = -79.35908,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/1d/6a/db/distillery-historic-district.jpg?w=2000&h=-1&s=1"
        ),
        Landmark(
            name = "Rogers Centre",
            type = "Stadium",
            address = "1 Blue Jays Way, Toronto, ON M5V 1J1, Canada",
            lat = 43.64194,
            long = -79.38918,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0c/5a/b8/cd/blue-jays-game-at-the.jpg?w=2200&h=-1&s=1"
        ),
        Landmark(
            name = "Scotiabank Arena",
            type = "Stadium",
            address = "40 Bay St., Toronto, ON M5J 2X2",
            lat = 43.64361,
            long = -79.37907,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/13/a8/d4/1c/raptors.jpg?w=1400&h=-1&s=1"
        ),
        Landmark(
            name = "Canada's Wonderland",
            type = "Attractions",
            address = "Vaughan, ON L6A 1S6",
            lat = 43.84304,
            long = -79.54129,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/02/c0/ab/d6/canada-s-wonderland.jpg?w=2000&h=-1&s=1"
        ),
        Landmark(
            name = "Toronto Zoo",
            type = "Attractions",
            address = "2000 Meadowvale Rd, Toronto, ON M1B 5K7",
            lat = 43.82080,
            long = -79.18142,
            image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/ac/67/6c/toronto-zoo.jpg?w=1100&h=-1&s=1"
        ),
    )
}





