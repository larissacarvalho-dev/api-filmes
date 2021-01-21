package com.larissa.filmesapi.rest;

import com.larissa.filmesapi.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {

    @GET("movie/popular")
    Call<Data> getPopularMovies(@Query("api_key") String chaveApi);
}
