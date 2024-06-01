package com.example.entertainer.ui.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.example.entertainer.data.Movie
import com.example.entertainer.ui.theme.Light
import java.io.ByteArrayOutputStream
import java.util.Random

/* Functions used across the application */

/**
 * Converts a [Bitmap] to a [ByteArray].
 *
 * @param bitmap The bitmap to be converted.
 * @return The converted byte array.
 */
fun convertToByteArray(bitmap: Bitmap) : ByteArray{
    val byteArrayOutputStream = ByteArrayOutputStream()
    var quality = 80
    var compressed: ByteArray
    val maxSizeKB = 500

    do {
        byteArrayOutputStream.reset()
        bitmap.compress(
            Bitmap.CompressFormat.JPEG,
            quality,
            byteArrayOutputStream
        )
        compressed = byteArrayOutputStream.toByteArray()
        quality -= 10
    } while (compressed.size / 1024 > maxSizeKB && quality > 10)

    return compressed
}

/**
 * Converts a [ByteArray] to an [ImageBitmap].
 *
 * @param byteArray The byte array to be converted.
 * @return The converted image bitmap.
 */
fun convertToImageBitmap(byteArray: ByteArray): ImageBitmap {
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    return bitmap.asImageBitmap()
}

/**
 * Calculates the total watched hours from a list of movies.
 *
 * @param movies The list of movies to calculate watched hours from.
 * @return The total watched hours as a double.
 */
fun calculateWatchedHours(movies: List<Movie>) : Double{
    var counter = 0.0;

    for(movie in movies){
        counter += movie.duration
    }

    return counter
}