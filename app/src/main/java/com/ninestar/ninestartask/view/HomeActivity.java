package com.ninestar.ninestartask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ninestar.ninestartask.R;
import com.ninestar.ninestartask.adapter.NdaAdapter;
import com.ninestar.ninestartask.model.DocsItem;
import com.ninestar.ninestartask.repository.NdaRepository;
import com.ninestar.ninestartask.viewmodel.NdaViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private RecyclerView mNdaRecyclerView;
    private ProgressBar mProgressBar;
    private LinearLayoutManager layoutManager;
    private NdaAdapter ndaAdapter;
    private ArrayList<DocsItem> ndaArrayList = new ArrayList<>();
    private NdaViewModel ndaViewModel;
    private TextView mInternetStatusTV;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialization();
        if (isConnectionAvailable(HomeActivity.this)) {
            getNdaDocList();
        } else {
            mProgressBar.setVisibility(View.GONE);
            mInternetStatusTV.setVisibility(View.VISIBLE);
        }
        ndaAdapter.setOnItemClickListener(new NdaAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v, DocsItem docsItem) {
                Intent intent = new Intent(HomeActivity.this, NDADetailActivity.class);
                intent.putExtra("doc", (Serializable) docsItem);
                startActivity(intent);
            }
        });
        test();
    }


    private void test() {
        NdaRepository testRepo = new NdaRepository();
        testRepo.getData();
    }

    private void initialization() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mNdaRecyclerView = findViewById(R.id.nda_recycler_view);
        mInternetStatusTV = findViewById(R.id.tv_internet);
        layoutManager = new LinearLayoutManager(HomeActivity.this);
        mNdaRecyclerView.setLayoutManager(layoutManager);
        mNdaRecyclerView.hasFixedSize();
        ndaAdapter = new NdaAdapter(HomeActivity.this, ndaArrayList);
        mNdaRecyclerView.setAdapter(ndaAdapter);
        ndaViewModel = new ViewModelProvider(HomeActivity.this).get(NdaViewModel.class);

    }

    private void getNdaDocList() {
        ndaViewModel.getDocItemListLiveData().observe(this, ndaResponse -> {
            if (ndaResponse != null) {
                mProgressBar.setVisibility(View.GONE);
                List<DocsItem> ndaList = ndaResponse.getDocs();
                if (ndaList != null) {
                    ndaArrayList.addAll(ndaList);
                    ndaAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isConnectionAvailable(getApplicationContext())) {
            mInternetStatusTV.setVisibility(View.GONE);
        }
    }
}