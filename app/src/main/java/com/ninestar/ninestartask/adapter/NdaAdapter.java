package com.ninestar.ninestartask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ninestar.ninestartask.R;
import com.ninestar.ninestartask.model.DocsItem;
import com.ninestar.ninestartask.utils.Utility;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NdaAdapter extends RecyclerView.Adapter<NdaAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<DocsItem> ndaList;

    public NdaAdapter(Context mContext, ArrayList<DocsItem> ndaList) {
        this.mContext = mContext;
        this.ndaList = ndaList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nda, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NdaAdapter.ViewHolder holder, int position) {
        DocsItem docsItem = ndaList.get(position);
        holder.journal.setText(docsItem.getJournal());
        holder.journal_date.setText(Utility.dateFormating(docsItem.getPublicationDate()));
        holder.journal_title.setText(docsItem.getTitleDisplay());
        holder.article_type.setText(docsItem.getArticleType());
    }

    @Override
    public int getItemCount() {
        return ndaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView journal;
        private TextView journal_date;
        private TextView journal_title;
        private TextView article_type;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            journal = itemView.findViewById(R.id.tv_journal);
            journal_date = itemView.findViewById(R.id.date);
            journal_title = itemView.findViewById(R.id.title_display);
            article_type = itemView.findViewById(R.id.article_type);
        }
    }
}
