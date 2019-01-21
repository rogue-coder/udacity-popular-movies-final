package com.android.popularmovies.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.popularmovies.database.FavoriteMoviesContract.*;

public class FavoriteMoviesDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "favoriteMovies";

    public FavoriteMoviesDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String FAVORITE_MOVIES_TABLE = "CREATE TABLE " +
                Favorites.TABLE_NAME + " (" +
                Favorites._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Favorites.MOVIE_ID + " INTEGER NOT NULL," +
                Favorites.MOVIE_TITLE + " TEXT NOT NULL," +
                Favorites.MOVIE_IMAGE_URL + " TEXT NOT NULL," +
                Favorites.MOVIE_RATING + " TEXT NOT NULL," +
                Favorites.MOVIE_RELEASE_DATE + " TEXT NOT NULL," +
                Favorites.MOVIE_OVERVIEW + " TEXT NOT NULL" +
                "); ";
        sqLiteDatabase.execSQL(FAVORITE_MOVIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Favorites.TABLE_NAME);
        onCreate(db);
    }
}