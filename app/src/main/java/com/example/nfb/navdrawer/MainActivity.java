package com.example.nfb.navdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String [] titulo = {"Alojamiento", "Comida", "Emergencia", "Fallas", "Monumentos", "Ocio", "Salud", "Transporte"};

    private int [] icon = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    private boolean drawerOpen = false;

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private ActionBarDrawerToggle toggle;

    private DrawerLayout drawerLayout;
    NavDrawerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new NavDrawerAdapter(icon, titulo);

        recyclerView.setAdapter(adapter);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        toggle = new CustomToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.action_setting){

            return true;
        }

        if(item.getItemId() == android.R.id.home) {


            if (drawerOpen) {
                drawerLayout.closeDrawers();

            }else{
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    class CustomToggle extends ActionBarDrawerToggle{

        public CustomToggle(Activity activity, DrawerLayout drawerLayout, int openDrawerContentDescRes, int closeDrawerContentDescRes){
            super (activity, drawerLayout, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        public void onDrawerOpened (View drawerView){
            super.onDrawerOpened(drawerView);

            drawerOpen = true;
        }

        public void onDrawerClosed (View drawerView){
            super.onDrawerClosed(drawerView);

            drawerOpen = false;
        }
    }
}
