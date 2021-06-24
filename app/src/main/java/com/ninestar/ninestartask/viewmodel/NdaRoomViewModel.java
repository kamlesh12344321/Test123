package com.ninestar.ninestartask.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ninestar.ninestartask.model.DocsItem;
import com.ninestar.ninestartask.repository.NdaRoomRepo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NdaRoomViewModel  extends AndroidViewModel {
    private NdaRoomRepo ndaRoomRepo;
    private LiveData<List<DocsItem>> allDocItems;
    public NdaRoomViewModel(@NonNull @NotNull Application application) {
        super(application);
        ndaRoomRepo = new NdaRoomRepo(application);
        allDocItems = ndaRoomRepo.getAllNotes();
    }

    public void insert(LiveData<List<DocsItem>> docItems){
        ndaRoomRepo.insert(docItems);
    }
    public LiveData<List<DocsItem>> getAllDocItemFromRoom(){
        return allDocItems;
    }
}
