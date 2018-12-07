package com.kurosaki.android.popularmoviesstage2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDb extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PopularMovies.db";
    private static final int DB_VERSION = 5;

    public MovieDb(Context context){
        super(context,DATABASE_NAME,null,DB_VERSION);
    }

    //Database needed for bookmarked movies
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_QUERY =
                "CREATE TABLE " + MovieContract.MovieEntry.TABLE_NAME + "(" +
                        MovieContract.MovieEntry.MOVIE_ID + " INTEGER PRIMARY KEY, " +
                        MovieContract.MovieEntry.MOVIE_TITLE + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_OVERVIEW + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_POSTER + " BLOB NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_POSTER_PATH + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_AVG + " REAL NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_VOTES + " INTEGER NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_RELEASE_DATE + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_TRAILERS + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.MOVIE_REVIEWS + " TEXT NOT NULL" +
                        ")";

        db.execSQL(SQL_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieContract.MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}