package com.ninestar.ninestartask.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ninestar.ninestartask.model.DocsItem;

import java.util.List;

@Dao
public interface NdaDao {

    @Insert
    void Insert(LiveData<List<DocsItem>>[] docsItems);

    @Query("SELECT * FROM nda_items")
    LiveData<List<DocsItem>> getDocItemList();

}
