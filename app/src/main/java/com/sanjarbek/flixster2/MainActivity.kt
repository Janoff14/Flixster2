package com.sanjarbek.flixster2

import android.content.pm.ModuleInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rcv_root)
        val arrayListActorModel = ArrayList<ActorModel>()

        val requestQueue = Volley.newRequestQueue(this)
        val url = "https://api.themoviedb.org/3/person/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1"

        val jsonObjectRequest: JsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, {response->

            try {
                val results = response.getJSONArray("results")
                for (i in 0 until results.length()){
                    val actor = results.getJSONObject(i)
                    val name = actor.getString("name")
                    val profile_path = actor.getString("profile_path")
                    val popularity = actor.getString("popularity")

                    val movieModelArrayList = ArrayList<MovieModel>()
                    val movies = actor.getJSONArray("known_for")

                    try {
                        for (j in 0 until movies.length()) {
                            val movie = movies.getJSONObject(j)
                            val overview = movie.getString("overview")
                            val image = movie.getString("poster_path")


                            val title = if (movie.getString("media_type") == "tv"){
                                movie.getString("original_name")
                            } else{
                                movie.getString("title")
                            }
                            val movieModel = MovieModel(title, image, overview)
                            movieModelArrayList.add(movieModel)
                        }
                        } catch (e: JSONException){
                            Log.d("second", "onCreate: $e")
                        }


                    val actorModel = ActorModel(name,popularity,profile_path,movieModelArrayList)
                    arrayListActorModel.add(actorModel)
                }
            } catch (e: JSONException){
                Log.d("first", "onCreate: $e")
            }
        },
            {
        })
        requestQueue.add(jsonObjectRequest)

        val adapter = ActorAdapter(this, arrayListActorModel)
        recyclerView.adapter = adapter
    }
}