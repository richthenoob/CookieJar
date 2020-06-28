package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Cookie.class}, version = 1, exportSchema = false)
public abstract class CookieDataBase extends RoomDatabase {
    public abstract CookieDAO wordDao();
    private static CookieDataBase INSTANCE;

    static CookieDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CookieDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CookieDataBase.class, "cookie_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
//                    new PopulateDbAsync(INSTANCE).execute();
                }

    };

//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final CookieDAO mDao;
//        String[] words = {"Taught myself to waveboard in 1 night", "Picked up cooking in London", "Studied hard and did well for STEP"};
//
//        PopulateDbAsync(CookieDataBase db) {
//            mDao = db.wordDao();
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            mDao.deleteAll();
//            for (int i = 0; i <= words.length - 1; i++) {
//                Cookie word = new Cookie(words[i]);
//                mDao.insert(word);
//            }
//            return null;
//        }
//    }
}
