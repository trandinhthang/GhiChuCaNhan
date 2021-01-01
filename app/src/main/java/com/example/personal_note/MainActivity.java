package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;

    ArrayList<ItemMenu> arrayList;
    MenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        actionToolBar();
        actionMenu();
    }

    private void actionMenu(){
        arrayList= new ArrayList<>();
        arrayList.add(new ItemMenu("Home",R.drawable.ic_action_home));
        arrayList.add(new ItemMenu("Category",R.drawable.ic_action_category));
        arrayList.add(new ItemMenu("Priority",R.drawable.ic_action_note));
        arrayList.add(new ItemMenu("Status",R.drawable.ic_action_status));
        arrayList.add(new ItemMenu("Note",R.drawable.ic_action_note));
        arrayList.add(new ItemMenu("Account",R.drawable.ic_action_account));
        arrayList.add(new ItemMenu("Edit Profile",R.drawable.ic_action_edit));
        arrayList.add(new ItemMenu("Change Password",R.drawable.ic_action_changepass));
        adapter = new MenuAdapter(this, R.layout.dong_item,arrayList);
        listView.setAdapter(adapter);
    }

    private void actionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void anhXa(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        listView = (ListView) findViewById(R.id.lv);
    }

}