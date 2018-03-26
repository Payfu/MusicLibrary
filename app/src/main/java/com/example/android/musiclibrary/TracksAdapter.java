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
 * Created by payfu on 23/03/2018.
 */

public class TracksAdapter extends ArrayAdapter<Track> {

    public TracksAdapter(Activity context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listTracksView = convertView;
        if (listTracksView == null) {
            listTracksView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Track currentTrack = getItem(position);

        // Track number
        TextView trackIdTextView = listTracksView.findViewById(R.id.track_id);
        trackIdTextView.setText(String.valueOf(currentTrack.getTrackNumber()));

        // Track name
        TextView trackNameTextView = listTracksView.findViewById(R.id.track_name);
        trackNameTextView.setText(currentTrack.getTrackName());

        return listTracksView;
    }
}
