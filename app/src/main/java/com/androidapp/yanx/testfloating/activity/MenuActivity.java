package com.androidapp.yanx.testfloating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.adapter.MenuAdapter;
import com.androidapp.yanx.testfloating.adapter.MyBaseAdapter;
import com.androidapp.yanx.testfloating.entity.MenuListItemMdl;
import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

import java.util.ArrayList;

/**
 * com.androidapp.yanx.testfloating
 * Created by yanx on 11/1/15 1:49 PM.
 * Description ${TODO}
 */
public class MenuActivity extends AppCompatActivity {

    RecyclerViewHeader header_2;
    private RecyclerView recycleView;
//    private View floatingView;
    private ArrayList<MenuListItemMdl> entrances = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recycleView = (RecyclerView) findViewById(R.id.list_view);
//        floatingView = findViewById(R.id.view_header);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) ;

        recycleView.setLayoutManager(mLayoutManager);
        RecyclerViewHeader header_1 = RecyclerViewHeader.fromXml(this, R.layout.layout_banner);
        header_2 = RecyclerViewHeader.fromXml(this, R.layout.layout_header);
//        header_1.attachTo(recycleView);
//        header_2.attachTo(recycleView);


        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                if (header_2.getHeight() <= dy) {
//                    floatingView.setVisibility(View.VISIBLE);
//                } else {
//                    floatingView.setVisibility(View.GONE);
//                }
            }

        });

        entrances.add(new MenuListItemMdl(PictureListActivity.class,"PictureListDemo")) ;

        MenuAdapter adapter = new MenuAdapter(this, entrances);

        recycleView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        adapter.setOnItemClickListener(new MyBaseAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View itemView) {
                MenuListItemMdl itemMdl = (MenuListItemMdl) itemView.getTag();
                Toast.makeText(getApplicationContext(),itemMdl.displayName,Toast.LENGTH_SHORT).show() ;
                startActivity(new Intent(getApplicationContext(), itemMdl.activity));
            }
        });



    }
}
