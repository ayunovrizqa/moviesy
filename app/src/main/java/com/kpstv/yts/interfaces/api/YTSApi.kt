package com.kpstv.yts.interfaces.api

import com.kpstv.yts.data.models.response.Model
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface YTSApi {

    /** Get movie details by passing certain queries build using
     *  YTSQuery.MovieBuilder class*/

    @GET("movie_details.json")
    suspend fun getMovie(@QueryMap params: Map<String, String>): Model.response_movie?

    /** List movies by passing certain queries build using
     *  YTSQuery.ListMovieBuilder class*/

    @GET("list_movies.json")
    fun listMovies(@QueryMap params: Map<String, String>): Call<Model.response_movie>

    /** A special callback for CustomMovieLayout
     */
    @GET("list_movies.json")
    fun listMovies(@QueryMap params: Map<String, String>, @Query("page") page: Int): Call<Model.response_movie>
}