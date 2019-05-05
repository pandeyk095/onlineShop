package com.example.clothshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.clothshopapp.adapter.ItemsAdapter;
import com.example.clothshopapp.model.Items;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Items> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recyclerView);
        listItems = new ArrayList<>();
        readFromFile();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), AddItemActivity.class);
                startActivity(intent);
            }
        });
        ItemsAdapter itemsAdapter=new ItemsAdapter(this, listItems);
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
    private void readFromFile(){
        try{
            FileInputStream fos=openFileInput("item.txt");
            InputStreamReader isr=new InputStreamReader(fos);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                String[] parts=line.split("->");
                Items items = new Items();
                items.setItemName(parts[0]);
                items.setItemPrice(parts[1]);

                int image=getResources().getIdentifier(parts[2],"drawable",getPackageName());

                //items.setItemImage(Integer.parseInt(parts[2]));
                items.setItemImage(Integer.toString(image));
                items.setItemDesc(parts[3]);

                listItems.add(items);

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
