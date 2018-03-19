package com.example.raymond.mvpdemo.searchbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.raymond.mvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchViewBActivity extends AppCompatActivity {
    @BindView(R.id.hello_searchbar)
    Toolbar helloSearchbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_b);
        ButterKnife.bind(this);

        setSupportActionBar(helloSearchbar);

    }
}
