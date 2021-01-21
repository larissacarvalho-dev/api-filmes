package com.larissa.filmesapi.di;

import com.larissa.filmesapi.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MovieModule.class)
public interface MovieComponent {
    void inject(MainActivity mainActivity);
}
