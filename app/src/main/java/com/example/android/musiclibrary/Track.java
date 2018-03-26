package com.example.android.musiclibrary;

/**
 * Created by payfu on 23/03/2018.
 */

public class Track {
    private int mNumber;
    private String mTrackName;


    public Track(int number, String trackName) {
        mNumber = number;
        mTrackName = trackName;
    }

    public int getTrackNumber() {
        return mNumber;
    }

    public String getTrackName() {
        return mTrackName;
    }
}
