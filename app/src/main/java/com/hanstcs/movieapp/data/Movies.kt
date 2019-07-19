package com.hanstcs.movieapp.data;

import com.google.gson.annotations.SerializedName;

data class MoviesResponse(
        @SerializedName("id") val id: String,
        @SerializedName("revenue") val revenue: String,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("result") val result: List<Movies>
)

data class Movies(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("release_date") val releaseDate: String
)
