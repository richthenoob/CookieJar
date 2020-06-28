package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CookieRepo {

    private CookieDAO cookieDAO;
    private LiveData<List<Cookie>> mAllCookies;
//    private Cookie curr;
//
//    public Cookie getCurr() {
//        return curr;
//    }

    CookieRepo(Application application) {
        CookieDataBase db = CookieDataBase.getDatabase(application);
        cookieDAO = db.wordDao();
        mAllCookies = cookieDAO.getAll();
//        curr = cookieDAO.getRandom();
    }

    LiveData<List<Cookie>> getAllCookies() {
        return mAllCookies;
    }

    public void insert(Cookie word) {
        new insertAsyncTask(cookieDAO).execute(word);
    }

    public void deleteAll() {
        new deleteAllAsyncTask(cookieDAO).execute();
    }

    public void delete(Cookie word) {
        new deleteAsyncTask(cookieDAO).execute(word);
    }

//    public void getRand() {
//        curr = cookieDAO.getRandom();
//    }

    private static class insertAsyncTask extends android.os.AsyncTask<Cookie, Void, Void> {

        private CookieDAO mAsyncTaskDao;

        insertAsyncTask(CookieDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Cookie... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends android.os.AsyncTask<Cookie, Void, Void> {

        private CookieDAO mAsyncTaskDao;

        deleteAsyncTask(CookieDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Cookie... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }


    private static class deleteAllAsyncTask extends AsyncTask<Cookie, Void, Void> {

        private CookieDAO mAsyncTaskDao;

        deleteAllAsyncTask(CookieDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Cookie... params) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
}


