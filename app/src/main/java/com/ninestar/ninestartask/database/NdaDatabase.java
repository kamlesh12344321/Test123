package com.ninestar.ninestartask.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import org.jetbrains.annotations.NotNull;

public abstract class NdaDatabase extends RoomDatabase {

    private static NdaDatabase instance;
     public abstract NdaDatabase NdaDao();

     public static synchronized NdaDatabase getInstance(Context context){
         if (instance == null){
             instance = Room.databaseBuilder(context.getApplicationContext(),
                     NdaDatabase.class,"nda_database").fallbackToDestructiveMigration()
                     .addCallback(roomCallback)
                     .build();
         }
         return instance;
     }

     public static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
         @Override
         public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
             super.onCreate(db);
         }
     };
}
