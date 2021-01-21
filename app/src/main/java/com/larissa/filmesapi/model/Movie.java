package com.larissa.filmesapi.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("original_title")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("original_language")
    private String genre;

    @SerializedName("vote_average")
    private String votes;

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
