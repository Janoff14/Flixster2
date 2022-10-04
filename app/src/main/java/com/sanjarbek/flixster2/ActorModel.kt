package com.sanjarbek.flixster2

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.Serializable

@kotlinx.serialization.Serializable
data class ActorModel(
    private val name: String,
    private val popularity: String,
    private val profile_path: String,
    private val movieModelArrayList: ArrayList<MovieModel>): Serializable {

    fun main(): String {
        val json = Json.encodeToString(ActorModel(name, popularity, profile_path, movieModelArrayList))
        return json
    }

    fun get_name(): String{
        return this.name
    }

    fun get_popularity(): String{
        return this.popularity
    }

    fun get_profile_path(): String{
        return this.profile_path
    }

    fun get_movie_list(): ArrayList<MovieModel>{
        return this.movieModelArrayList
    }
}