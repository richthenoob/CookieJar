package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.LinkedList;
import java.util.List;

public class CookieViewModel extends AndroidViewModel {

    private CookieRepo mRepository;

    private LiveData<List<Cookie>> mAllCookies;


    public CookieViewModel(Application application) {
        super(application);
        mRepository = new CookieRepo(application);
        mAllCookies = mRepository.getAllCookies();
    }

    LiveData<List<Cookie>> getAllWords() {
        return mAllCookies;
    }

    public void insert(Cookie word) {
        mRepository.insert(word);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void delete(Cookie word) {
        mRepository.delete(word);
    }

//    LiveData<List<Cookie>> getRand() {
//        LiveData<List<Cookie>> list = new MutableLiveData<List<Cookie>>;
//        mRepository.getCurr();
//    }

}
