package com.example.androidroomwithview.joke;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeApi {

    String BASE_URL = "http://api.icndb.com/jokes/";

    @GET("random?limitTo=[nerdy]")
    Call<JokeResponseModel> getJoke();

    @GET("list/randon?")
    Call<List<JokeValueModel>> getManyJokes();
}
