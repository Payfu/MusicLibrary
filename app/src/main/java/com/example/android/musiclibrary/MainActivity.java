package com.example.android.musiclibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String[] album;
    private String[] artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Artist> artists = new ArrayList<>();

        /*
        Just for this exemple, I repeat this code twice to get more artists to display
         */
        for (int j = 0; j <= 1; j++) {

            /*
             Get data from artists_array.xml
            */
            int i = 0;
            while (true) {
                int id_artist = getResources().getIdentifier("artist_" + i, "array", getPackageName());
                int id_album = getResources().getIdentifier("artist_album_" + i, "array", getPackageName());
                if (id_artist != 0) {
                    artist = getResources().getStringArray(id_artist);
                    album = getResources().getStringArray(id_album);
                    artists.add(new Artist(artist[0], artist[1], artist[2], album));
                } else {
                    break;
                }
                i++;
            }
        }

        /*
         Adapter
         */
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        GridView gridView = findViewById(R.id.gridview);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Artist artist = artists.get(position);

                Intent showTrackIntent = new Intent(MainActivity.this, ShowTracksActivity.class);

                showTrackIntent.putExtra("key", artist);

                startActivity(showTrackIntent);
            }
        });
    }
}
