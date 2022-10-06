package com.sanjarbek.flixster2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ActorInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_info)

        val actor = intent.extras?.get("actor") as ActorModel

        val name = actor.name
        val profile_url = actor.profilePath

        val image = findViewById<ImageView>(R.id.img_actor)
        val txt_name = findViewById<TextView>(R.id.txt_name)

        val image_url = "https://image.tmdb.org/t/p/w500/" + profile_url
        txt_name.text = name

        Glide.with(this)
            .load(image_url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)

        Log.d("TAG", "onCreate: ${actor.name}")
        for (x in actor.movieModelArrayList){
            Log.d("TAG", "onCreate: ${x.original_title}")
        }
        val recyclerView = findViewById<RecyclerView>(R.id.rcv_actor)
        val adapter = MovieAdapter(this, actor.movieModelArrayList as ArrayList<MovieModel>)
        recyclerView.adapter = adapter

    }
}