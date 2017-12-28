package com.example.user.paginationendlessscroll.mData;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.paginationendlessscroll.mRecycler.MyAdapter;
import com.srx.widget.PullCallback;
import com.srx.widget.PullToLoadView;

import java.util.ArrayList;


public class Paginator {

    Context c;
    private PullToLoadView pullToLoadView;
    RecyclerView rv;
    private MyAdapter adapter;
    private boolean isLoading=false;
    private boolean hasLoadAll=false;
    private int nextPage;
    private ArrayList<Spaceship>spaceships=new ArrayList<>();

    public Paginator(Context c, PullToLoadView pullToLoadView) {
        this.c = c;
        this.pullToLoadView = pullToLoadView;
        rv=pullToLoadView.getRecyclerView();
        rv.setLayoutManager(new LinearLayoutManager(c,LinearLayoutManager.VERTICAL,false));
        adapter=new MyAdapter(c,new ArrayList<Spaceship>());
        rv.setAdapter(adapter);
        initializePaginator();
    }

    public void initializePaginator(){
        pullToLoadView.isLoadMoreEnabled(true);
        pullToLoadView.setPullCallback(new PullCallback() {
            @Override
            public void onLoadMore() {
                loadData(nextPage);
            }

            @Override
            public void onRefresh() {
                adapter.clear();
                hasLoadAll=false;
                loadData(1);
            }

            @Override
            public boolean isLoading() {
                return isLoading;

            }

            @Override
            public boolean hasLoadedAllItems() {
                return hasLoadAll;
            }
        });
        pullToLoadView.initLoad();
    }

    public void loadData(final int page){

        isLoading=true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=5;i++){
                    adapter.add(new Spaceship("spaceship : "+ String.valueOf(i) +" In page : "+ String.valueOf(page)));
                }
                pullToLoadView.setComplete();
                isLoading=false;
                nextPage=page+1;

            }
        },3000);
    }
}
