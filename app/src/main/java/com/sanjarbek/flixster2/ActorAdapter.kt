package com.sanjarbek.flixster2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.os.Bundle

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ActorAdapter(val context: Context, val arrayListActorModel: ArrayList<ActorModel>): RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.actor_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actorModel = arrayListActorModel.get(position)
        holder.name.text = actorModel.name
        holder.popularity.text = actorModel.popularity

        val image_url = "https://image.tmdb.org/t/p/w500/" + actorModel.profilePath

        Glide.with(context)
            .load(image_url)
            .override(300, 200)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image)

        holder.image.setOnClickListener {
            val intent = Intent(context, ActorInfoActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable("actor", actorModel)
            intent.putExtras(bundle)

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