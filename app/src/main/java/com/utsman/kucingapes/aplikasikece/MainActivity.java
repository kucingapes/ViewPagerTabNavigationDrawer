package com.utsman.kucingapes.aplikasikece;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.utsman.kucingapes.aplikasikece.Adapter.Dua;
import com.utsman.kucingapes.aplikasikece.Adapter.Satu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    TabLayout tabLayout;
    ImageView imgHeader;
    CollapsingToolbarLayout collapsingToolbarLayout;

    Satu adapterSatu;
    Dua adapterDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.setDrawerElevation(0f);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this,R.color.colorPrimary)
        );
        collapsingToolbarLayout.setTitle("Bagian 1");


        imgHeader = findViewById(R.id.header);
        imgHeader.setImageDrawable(getResources().getDrawable(R.drawable.imgbg));

        setupAdapter();
        setupPager();
    }

    private void setupAdapter() {
        adapterSatu = new Satu(this);
        adapterDua = new Dua(this);
    }

    private void setupPager() {
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapterSatu);

        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bag_1) {
            viewPager.setAdapter(adapterSatu);
            imgHeader.setImageDrawable(getResources().getDrawable(R.drawable.imgbg));
            collapsingToolbarLayout.setTitle("Bagian 1");
        } else if (id == R.id.nav_bag_2) {
            viewPager.setAdapter(adapterDua);
            imgHeader.setImageDrawable(getResources().getDrawable(R.drawable.wallpaper));
            collapsingToolbarLayout.setTitle("Bagian 2");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
