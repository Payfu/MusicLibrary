package com.example.android.musiclibrary;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by payfu on 19/03/2018.
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listArtistView = convertView;
        if (listArtistView == null) {
            listArtistView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist, parent, false);
        }

        // Get the {@link artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Image Album + image description
        String myImg = currentArtist.getAlbumImage();
        int imgId = getContext().getResources().getIdentifier("drawable/" + myImg, "id", getContext().getPackageName());
        ImageView image = listArtistView.findViewById(R.id.image_album);
        image.setImageResource(imgId);
        image.setContentDescription(currentArtist.getArtistName() + "\"" + currentArtist.getAlbumTitle() + "\"");

        // Artist
        TextView artistTextView = listArtistView.findViewById(R.id.artist);
        artistTextView.setText(currentArtist.getArtistName());

        // Album
        TextView albumTextView = listArtistView.findViewById(R.id.album);
        albumTextView.setText(currentArtist.getAlbumTitle());

        // Nb tracks
        TextView nbTracksTextView = listArtistView.findViewById(R.id.nb_tracks);
        String[] tracks = currentArtist.getTracks();

        int nbTracks = tracks.length;
        String strTracks = getContext().getString(R.string.nb_tracks);

        nbTracksTextView.setText(nbTracks + " " + strTracks);

        return listArtistView;
    }
}