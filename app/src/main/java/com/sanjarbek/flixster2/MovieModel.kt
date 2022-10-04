package com.sanjarbek.flixster2

data class MovieModel    (
    private var original_title: String,
    private var poster_path: String,
    private var overview: String
) {

    fun get_title(): String{
        return original_title
    }

    fun get_image(): String{
        return poster_path
    }

    fun get_description(): String{
        return overview
    }

}