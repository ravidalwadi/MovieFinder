package com.example.moviefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findMovies = findViewById<Button>(R.id.find_movie)

        findMovies.setOnClickListener {
            val movieGenres = findViewById<Spinner>(R.id.movie_genre)
            val genre = movieGenres.selectedItem
            val movieList = getMovies(genre.toString())
            val descriptionList = getDescription(genre.toString())
            val reducedMoviesList = movieList.reduce {str, item -> str + '\n' + item}
            val reduceDescriptionList = descriptionList.reduce {str, item -> str}
            val movies = findViewById<TextView>(R.id.movies)
            val description = findViewById<TextView>(R.id.description)
            description.text = reduceDescriptionList
            movies.text = reducedMoviesList
        }
    }
}

fun getMovies(genre: String) : List<String> {
    return when (genre) {
        "Comedy" -> listOf("Marry Me", "johnny English", "The Bad Guys")
        "Action" -> listOf("London Has Fallen", "The Dark Knight ", "No Time To Die")
        "Biopic" -> listOf("The Wolf Of Wall Street", "The Good Nurse", "The Queen")
        else -> listOf("No Movies Available")
    }
}


fun getDescription(genre: String) : List<String> {
    return when (genre) {
        "Comedy" -> listOf("Marry Me is a 2022 American romantic comedy drama film directed by kat Coiro., johnny english is a 2003 spy comedy movie.")
        "Action" -> listOf("London Has Fallen is a 2016 American action thriller movie., The Dark Knight is a 2008 superhero film directed by Christopher Nolan.")
        "Biopic" -> listOf("The Wolf of Wall Street is a 2013 American biographical movie which is based on 2007 memoir of the same name by Jordan Belfort. , The Good Nurse is ba American biopic movie whichb is based on the 2013 book of the same name by Charles Graeber.")
        else -> listOf("No History Available")
    }
}
