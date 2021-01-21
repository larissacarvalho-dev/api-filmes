package com.larissa.filmesapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.larissa.filmesapi.R;
import com.larissa.filmesapi.adapter.MovieAdapter;
import com.larissa.filmesapi.di.base.BaseApplication;
import com.larissa.filmesapi.model.Data;
import com.larissa.filmesapi.model.Movie;
import com.larissa.filmesapi.rest.MovieAPI;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Movie> movies;


    @Inject
    MovieAPI movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setUpDagger();
        control();
        setUpView();

    }
    private void setUpDagger(){
        ((BaseApplication)getApplication()).getRetrofitComponent().inject(this);
    }

    // verifico se estou recebendo esses dados ou não
    //em alguns casos pode ser que caia a rede ou a conexao com o servidor, utilizo a ferramenta logginInterceptor para este controle. .
    private void control(){

            Call<Data> call = movie.getPopularMovies("79f8b957bb486d552d9488b517d90783");
              call.enqueue(new Callback<Data>() {
                   @Override
                   public void onResponse(Call<Data> call, Response<Data> response) {
                       adapter.setData(response.body().getResults());
                   }

                   @Override
                   public void onFailure(Call<Data> call, Throwable t) {
                       Log.d("TAG1", "Error: "+ t.getMessage());
                   }
               });
    }

    private void setUpView(){
        movies = new ArrayList<>();
        adapter = new MovieAdapter(movies, getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                lim.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }
}