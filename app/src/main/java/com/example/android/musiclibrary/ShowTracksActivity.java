
package com.example.android.musiclibrary;

/**
 * Created by payfu on 19/03/2018.
 */

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ShowTracksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

        // Action bar back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Artist value = getIntent().getParcelableExtra("key");

        String[] tracks = value.getTracks();

        // Display the artist name
        setTitle(value.getArtistName() + " (" + tracks.length + " tracks)");

        // Track ArrayList
        final ArrayList<Track> tracksArrayList = new ArrayList<>();

        for (int i = 0; i < tracks.length; i++) {
            tracksArrayList.add(new Track(i + 1, tracks[i]));
        }

        // Image Album
        String myImg = value.getAlbumImage();
        int imgId = getResources().getIdentifier("drawable/" + myImg, "id", getPackageName());
        ImageView image = findViewById(R.id.image_album);
        image.setImageResource(imgId);

        TextView albumTextView = findViewById(R.id.album_name);
        albumTextView.setText(value.getAlbumTitle());

        // Adapter
        TracksAdapter adapter = new TracksAdapter(this, tracksArrayList);

        ListView listView = findViewById(R.id.list_tracks);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
