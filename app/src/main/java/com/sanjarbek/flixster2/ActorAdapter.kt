package com.sanjarbek.flixster2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.Serializable

class ActorAdapter(val context: Context, val arrayListActorModel: ArrayList<ActorModel>): RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.actor_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = arrayListActorModel.get(position)
        holder.name.text = model.get_name()
        holder.popularity.text = model.get_popularity()

        val image_url = "https://image.tmdb.org/t/p/w500/" + model.get_profile_path()

        Glide.with(context)
            .load(image_url)
            .override(300, 200)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image)

        holder.image.setOnClickListener {
            val intent = Intent(context, ActorInfoActivity::class.java)
            intent.putExtra("image", image_url)
            intent.putExtra("name", model.get_name())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayListActorModel.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.image_aal)
        val name = itemView.findViewById<TextView>(R.id.name_aal)
        val popularity = itemView.findViewById<TextView>(R.id.popularity_aal)

    }
}