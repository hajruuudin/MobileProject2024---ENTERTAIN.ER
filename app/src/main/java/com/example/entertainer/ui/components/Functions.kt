package com.example.entertainer.ui.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream

fun convertToByteArray(bitmap: Bitmap) : ByteArray{
    val byteArrayOutputStream = ByteArrayOutputStream()
    bitmap.compress(
        Bitmap.CompressFormat.PNG,
        80,
        byteArrayOutputStream
    )
    return byteArrayOutputStream.toByteArray()
}

fun convertToBitMap(byteArray: ByteArray) : Bitmap {
    return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
}