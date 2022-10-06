package com.sanjarbek.flixster2
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActorModel (
    val name: String,
    val popularity: String,
    val profilePath: String,
    var movieModelArrayList: MutableList<MovieModel> = mutableListOf()): Parcelable {

    override fun toString(): String {
        return "ActorModel(name=$name, popularity=$popularity, profilePath=$profilePath)\n" +
                "movieModelArrayList=$movieModelArrayList"
    }
}