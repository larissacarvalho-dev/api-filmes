package com.larissa.filmesapi.di.base;

import android.app.Application;

import com.larissa.filmesapi.di.DaggerMovieComponent;
import com.larissa.filmesapi.di.MovieComponent;
import com.larissa.filmesapi.di.MovieModule;

public class BaseApplication extends Application {
    private MovieComponent movieComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        movieComponent = DaggerMovieComponent
                .builder()
                .movieModule(new MovieModule())
                .build();
    }

    public MovieComponent getRetrofitComponent(){
        return movieComponent;
    }
}
