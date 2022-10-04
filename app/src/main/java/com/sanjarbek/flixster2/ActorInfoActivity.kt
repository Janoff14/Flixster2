package com.sanjarbek.flixster2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ActorInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_info)

        val bundle = intent.extras
        val profile_url = bundle?.get("image")
        val name = bundle?.get("name")

        val image = findViewById<ImageView>(R.id.img_actor)
        val txt_name = findViewById<TextView>(R.id.txt_name)

        txt_name.text = name.toString()
        Glide.with(this)
            .load(profile_url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)
    }
}