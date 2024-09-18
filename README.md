# entertain.er - Movie Tracking App\

Android application developed using Kotlin and Compose for UI development, Room for database technology, and follows the MVVM architecture. It serves as a movie tracking app, enabling users to log in, browse movies, add them to watchlists, mark them as watched, view movie descriptions, genres, duration, actors, and their own profiles along with stats.

## Version: 1.0
## Overview
entertain.er is an Android application developed using Kotlin and Compose for UI development, Room for database technology, and follows the MVVM architecture. It serves as a movie tracking app, enabling users to log in, browse movies, add them to watchlists, mark them as watched, view movie descriptions, genres, duration, actors, and their own profiles along with stats.

## Features
- User authentication: Sign up and log in functionalities.
- Browse Movies: Users with admin privileges can view and browse movies added to the database.
- Watchlist: Add movies to the watchlist.
- Mark as Watched: Ability to mark movies as watched.
- Movie Details: View movie descriptions, genres, duration, actors, etc.
- Profile: Users can view their profiles along with their statistics.

## Installation
1. Clone the repository.
2. Run the application on an Android device.
3. The Room database is instantiated locally on each device; it's not an online database.

## Minimum Requirements
- Android Oreo API 26 or higher.

## Dependencies
Ensure the following dependencies are added to your Gradle build file if the build fails:
```kotlin
plugins {
 id("com.android.application")
 id("org.jetbrains.kotlin.android")
 id("com.google.devtools.ksp")
}

// ROOM
val room_version = "2.6.1"
implementation("androidx.room:room-runtime:$room_version")
implementation("androidx.room:room-ktx:$room_version")
annotationProcessor("androidx.room:room-compiler:$room_version")
ksp("androidx.room:room-compiler:$room_version")

// VIEWMODEL
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

// NAVIGATION
implementation("androidx.navigation:navigation-compose:2.6.0")
```
## Languages Used
1. Kotlin as the logic and primary language
2. Jetpack Compose for UI development
3. KDOCS for inline documentation

## Project Purpose

This project was developed as part of the course IT 206 Introduction to Mobile Programming at International Burch University.
Developers / Students : Hajrudin Imamovic Emir, Sultan, Adnan Mehmedovic
