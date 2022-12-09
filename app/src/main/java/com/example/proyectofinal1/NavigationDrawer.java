package com.example.proyectofinal1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //ui
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        //setup toolbar
        setSupportActionBar(toolbar);

        //MostrarPrimerFragmentPredeterminado
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        setTitle("Home");


        toggle = new ActionBarDrawerToggle(NavigationDrawer.this,
                drawerLayout,
                toolbar,
                R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return false;
    }

    private void selectItemNav(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_home:
                ft.replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_perfil:
                ft.replace(R.id.fragment_container, new PerfilFragment()).commit();
                break;
            case R.id.nav_quiz:
                break;
            case R.id.nav_bar:
                ft.replace(R.id.fragment_container, new BarFragment()).commit();
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(NavigationDrawer.this,LoginFragment.class);
                startActivity(intent);


        }
        //mostrarNombreItem
        setTitle(item.getTitle());
        //ocultarNavigecionDrawer
        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}