package com.example.android.musiclibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by payfu on 19/03/2018.
 */

public class Artist implements Parcelable {

    private String mAlbumTitle, mAlbumImage, mArtistName;
    private String[] mTracks;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mAlbumTitle);
        out.writeString(mAlbumImage);
        out.writeString(mArtistName);
        out.writeStringArray(mTracks);
    }

    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    private Artist(Parcel in) {
        mAlbumTitle = in.readString();
        mAlbumImage = in.readString();
        mArtistName = in.readString();
        mTracks = in.createStringArray();
    }

    public Artist(String artistName, String albumTitle, String albumImage, String[] tracks) {
        mAlbumTitle = albumTitle;
        mAlbumImage = albumImage;
        mArtistName = artistName;
        mTracks = tracks;
    }

    /**
     * Get the album title.
     */
    public String getAlbumTitle() { return mAlbumTitle; }

    /**
     * Get the album image.
     */
    public String getAlbumImage() { return mAlbumImage; }

    /**
     * Get the artist name.
     */
    public String getArtistName() { return mArtistName; }

    /**
     * Get the number of track.
     */
    public String[] getTracks() { return mTracks; }
}
