package com.ninestar.ninestartask.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ninestar.ninestartask.database.NdaDao;
import com.ninestar.ninestartask.database.NdaDatabase;
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


    private static class InsertDocItemAsyncTask extends AsyncTask<LiveData<List<DocsItem>>, Void, Void> {
       private NdaDao ndaDao;
       private InsertDocItemAsyncTask(NdaDao ndaDao1) {
           this.ndaDao = ndaDao1;
       }


        @Override
        protected Void doInBackground(LiveData<List<DocsItem>>... liveData) {
           ndaDao.Insert(liveData);
            return null;
        } //static : doesnt have reference to the

    }
}
