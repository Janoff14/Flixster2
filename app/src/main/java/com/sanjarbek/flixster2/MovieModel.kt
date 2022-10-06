package com.sanjarbek.flixster2
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel (
    val original_title: String = "TestTitle",
    val poster_path: String = "./Test",
    val overview: String = "Test"
): Parcelable