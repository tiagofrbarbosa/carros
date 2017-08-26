package br.com.livroandroid.carros.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.fragments.CarrosFragment;
import br.com.livroandroid.carros.fragments.SiteLivroFragment;

/**
 * Created by tfbarbosa on 22/08/17.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {
    protected DrawerLayout drawerLayout;

    protected void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    protected void setUpNavDrawer(){
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(navigationView != null && drawerLayout != null){
            setNavViewValues(navigationView, R.string.nav_drawer_username,R.string.nav_drawer_email,R.mipmap.ic_launcher);

            navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        onNavDrawerItemSelected(item);
                        return true;
                    }
                });
            }
        }

        static void setNavViewValues(NavigationView navView, int nome, int email, int img){
            View headerView = navView.getHeaderView(0);
            TextView tNome = (TextView) headerView.findViewById(R.id.tNome);
            TextView tEmail = (TextView) headerView.findViewById(R.id.tEmail);
            ImageView imgView = (ImageView) headerView.findViewById(R.id.img);
            tNome.setText(nome);
            tEmail.setText(email);
            imgView.setImageResource(img);}

        private void onNavDrawerItemSelected(MenuItem menuItem){
            switch (menuItem.getItemId()){
                case R.id.nav_item_carros_todos:
                    replaceFragment(CarrosFragment.newInstance(R.string.carros));
                    break;
                case R.id.nav_item_carros_classicos:
                    replaceFragment(CarrosFragment.newInstance(R.string.classicos));
                    break;
                case R.id.nav_item_carros_esportivos:
                    replaceFragment(CarrosFragment.newInstance(R.string.esportivos));
                    break;
                case R.id.nav_item_carros_luxo:
                    replaceFragment(CarrosFragment.newInstance(R.string.luxo));
                    break;
                case R.id.nav_item_site_livro:
                    replaceFragment(new SiteLivroFragment());
                    break;
                case R.id.nav_item_settings:
                    toast("clicou em configurações");
                    break;
            }
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case android.R.id.home:
                    if(drawerLayout != null){
                        openDrawer();
                        return true;
                }
            }
            return super.onOptionsItemSelected(item);
        }

        protected void openDrawer(){
            if(drawerLayout != null){drawerLayout.openDrawer(GravityCompat.START);}
        }

        protected void closeDrawer(){
            if(drawerLayout != null){drawerLayout.closeDrawer(GravityCompat.START);}
        }

        protected void replaceFragment(Fragment frag){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, frag, "TAG").commit();
        }
    }
