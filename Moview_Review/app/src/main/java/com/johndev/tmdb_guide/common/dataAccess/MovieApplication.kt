package com.johndev.tmdb_guide.common.dataAccess

import android.app.Application
import androidx.room.Room

class MovieApplication : Application() {

    companion object {
        lateinit var database: MovieDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, MovieDatabase::class.java, "MovieDatabase").build()
    }

}