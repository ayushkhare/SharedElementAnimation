package com.example.ayush.sharedelementanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ayush.sharedelementanimation.adapter.MovieAdapter;
import com.example.ayush.sharedelementanimation.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> mMovieList = new ArrayList<>();
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //Defining the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //Initialising the adapter
        mAdapter = new MovieAdapter(mMovieList, this);

        //Setting the adapter
        recyclerView.setAdapter(mAdapter);

        //Prepare data for recycler view
        prepareData();
    }

    private void prepareData() {
        Movie movie = new Movie("https://goo.gl/fZXUTO", "Inception",
                "Dom Cobb (Leonardo DiCaprio) is a thief with the rare ability to enter people's dreams and " +
                        "steal their secrets from their subconscious.", "Fantasy & Mystery", "2010");
        mMovieList.add(movie);

        movie = new Movie("https://goo.gl/67ZzBc", "Interstellar", "In Earth's future, a global crop blight " +
                "and second Dust Bowl are slowly rendering the planet uninhabitable.","Mystery & Science Fiction", "2014");
        mMovieList.add(movie);

        movie = new Movie("https://goo.gl/fmJUyF", "The Dark Knight", "With the help of allies Lt. Jim Gordon (Gary Oldman) " +
                "and DA Harvey Dent (Aaron Eckhart), Batman (Christian Bale) has been able to keep a tight lid on crime in " +
                "Gotham City.","Crime & Drama", "2008");
        mMovieList.add(movie);

        movie = new Movie("https://goo.gl/OYSkrl", "The Shawshank Redemption", "Andy Dufresne (Tim Robbins) is sentenced to " +
                "two consecutive life terms in prison for the murders of his wife and her lover and is sentenced to a tough" +
                " prison.","Drama & Thriller", "1994");
        mMovieList.add(movie);

        //Notify adapter
        mAdapter.notifyDataSetChanged();
    }
}
