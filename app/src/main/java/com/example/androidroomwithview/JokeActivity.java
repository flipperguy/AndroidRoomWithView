package com.example.androidroomwithview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidroomwithview.joke.JokeResponseModel;
import com.example.androidroomwithview.joke.JokeValueModel;
import com.example.androidroomwithview.joke.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeActivity extends AppCompatActivity {

    TextView jokeContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeContent = findViewById(R.id.joke_content);

        Button jokeButton = findViewById(R.id.joke_button);
        jokeButton.setOnClickListener( view -> {
            Log.i("JokeActivity","clicked joke button");
            getNewJoke();
        });
    }

    private void getNewJoke() {
        //jokeContent.setText("This is a new joke. The text is really long and should wrap.");
        makeJokeCall();
    }

    private void makeJokeCall() {
        Call<JokeResponseModel> call = RetrofitClient.getInstance().getMyApi().getJoke();
        call.enqueue(new Callback<JokeResponseModel>() {

            @Override
            public void onResponse(Call<JokeResponseModel> call, Response<JokeResponseModel> response) {
                Log.i("JokeActivity", "Raw: " + response.raw());
                Log.i("JokeActivity", "Message: " + response.message());
                JokeResponseModel jokeResponseModel = response.body();
                JokeValueModel jokeValueModel = jokeResponseModel.getValue();
                jokeContent.setText(jokeResponseModel.getValue().getJoke());
            }

            @Override
            public void onFailure(Call<JokeResponseModel> call, Throwable t) {
                Log.e("JokeActivity", "Error: " + t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}