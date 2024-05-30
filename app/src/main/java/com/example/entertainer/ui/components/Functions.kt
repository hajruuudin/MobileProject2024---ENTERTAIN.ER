package com.example.entertainer.ui.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.example.entertainer.ui.theme.Light
import java.io.ByteArrayOutputStream

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

fun convertToImageBitmap(byteArray: ByteArray): ImageBitmap {
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    return bitmap.asImageBitmap()
}

