package com.johndev.tmdb_guide.Interfaces

import com.johndev.tmdb_guide.Actors.KnownFor
import com.johndev.tmdb_guide.PopularMovies.MoviePopular

interface OnPressedMovie {

    fun OnMoviePressed(movie: MoviePopular)
    fun OnMovieKnowPressed(movie: KnownFor)

}