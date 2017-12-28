package com.example.user.paginationendlessscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.paginationendlessscroll.mData.Paginator;
import com.srx.widget.PullToLoadView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PullToLoadView pullToLoadView=findViewById(R.id.recyclerId);
        new Paginator(this,pullToLoadView).initializePaginator();
        
    }
}
