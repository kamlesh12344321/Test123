package com.ninestar.ninestartask.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ninestar.ninestartask.model.DocsItem;

import java.util.List;

public class NdaRoomRepo {
    private LiveData<List<DocsItem>> allDocItems;

    public NdaRoomRepo(){
        
    }
    public void insert(LiveData<List<DocsItem>> allDocItems) {

    }

    public LiveData<List<DocsItem>> getAllNotes() {
        return allDocItems;
    }

}
