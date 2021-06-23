package com.ninestar.ninestartask.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ninestar.ninestartask.R;
import com.ninestar.ninestartask.model.DocsItem;
import com.ninestar.ninestartask.utils.Utility;

public class NDADetailActivity extends BaseActivity {
    private DocsItem docsItem;
    private TextView mJournal, mDate_detail, mArticle_type, mAuthor, mTitle, mDescription;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_ndadetail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialization();
        fillData();
    }

    private void fillData() {
        mJournal.setText(docsItem.getJournal());
        mDate_detail.setText(Utility.getDate1(docsItem.getPublicationDate()));
        mArticle_type.setText(docsItem.getArticleType());
        mAuthor.setText(Utility.getAuthorString(docsItem.getAuthorDisplay()));
        mTitle.setText(docsItem.getTitleDisplay());
        mDescription.setText((CharSequence) docsItem.getJsonMemberAbstract());
    }

    private void initialization() {
        if (getIntent() != null) {
            docsItem = (DocsItem) getIntent().getSerializableExtra("doc");
        }
        mJournal = findViewById(R.id.tv_journal);
        mDate_detail = findViewById(R.id.tv_date_detail);
        mArticle_type = findViewById(R.id.tv_article_type);
        mAuthor = findViewById(R.id.tv_author);
        mTitle = findViewById(R.id.tv_title);
        mDescription = findViewById(R.id.tv_description);
    }
}