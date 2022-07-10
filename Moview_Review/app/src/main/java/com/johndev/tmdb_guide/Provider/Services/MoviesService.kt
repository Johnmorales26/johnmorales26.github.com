package com.johndev.tmdb_guide.Provider.Services

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.johndev.tmdb_guide.Constans
import com.johndev.tmdb_guide.MoviePopularTheaters.CardMovieAdapter
import com.johndev.tmdb_guide.Movies.Movies
import com.johndev.tmdb_guide.PopularMovies.PagesPopularMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesService(
    val activity: FragmentActivity?,
    var context: Context?,
    var adapter: CardMovieAdapter?
) {

    suspend fun getDataMovie(url: String) = withContext(Dispatchers.IO) {
        val queue = Volley.newRequestQueue(activity)
        val gson = Gson()
        val url = Constans.URL_BASE + url + Constans.API_KEY_INDEX + Constans.API_KEY
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val testModel = gson.fromJson(response, PagesPopularMovies::class.java)
            testModel.results?.forEach { movie ->
                //moviesList.add(movie)
                if (movie != null) {
                    adapter?.add(movie)
                }
            }
        }) {
            Toast.makeText(context, "No such movies exists", Toast.LENGTH_LONG).show()
        }
        queue.add(stringRequest)
    }

    fun getDetailsMovie(url: String): Request<String>? {
        val queue = Volley.newRequestQueue(activity)
        val gson = Gson()
        val url = Constans.URL_BASE + url + Constans.API_KEY_INDEX_SEARCH + Constans.API_KEY
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val jsonString = response
            val testModel = gson.fromJson(jsonString, Movies::class.java)
        }) {
            Toast.makeText(context, "No such movies exists", Toast.LENGTH_LONG).show()
        }
        return queue.add(stringRequest)
    }

}