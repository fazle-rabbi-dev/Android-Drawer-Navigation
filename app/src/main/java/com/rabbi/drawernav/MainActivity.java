package com.rabbi.drawernav;

import android.annotation.NonNull;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.Toast;
import android.view.Gravity;
import android.support.v4.view.GravityCompat;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
   private DrawerLayout drawer;
   private ActionBarDrawerToggle toggle;
   private NavigationView navView;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		    
      
        
		    Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		    setSupportActionBar(toolbar);
        
        
       drawer = findViewById(R.id.drawerId);
       toggle = new ActionBarDrawerToggle(this,drawer,R.string.nav_open,R.string.nav_close);
       drawer.addDrawerListener(toggle);
       toggle.syncState();

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       
       
       navView = findViewById(R.id.nav_view);       
       
       if (savedInstanceState == null) {
          getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,
               new FragmentOne()).commit();
          navView.setCheckedItem(R.id.homeId);
       }
       
       navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
             
             @Override
             public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId() == R.id.homeId){
                   //Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                   drawer.closeDrawer(GravityCompat.START);
                   navView.setCheckedItem(R.id.homeId);
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,
                        new FragmentOne()).commit();
                }
                if(item.getItemId() == R.id.aboutId){
                   drawer.closeDrawer(GravityCompat.START);
                   navView.setCheckedItem(R.id.aboutId);
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,
                        new AboutFragment()).commit();
                   
                   /*FragmentManager fm = getFragmentManager();
                   FragmentTransaction ft = fm.beginTransaction();
                   ft.replace(R.id.fragment_id);
                   ft.commit();*/
                }
                return false;
             }
                       
       });
        
        
    }
    
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if(toggle.onOptionsItemSelected(item)){
         return true;
      }

      return super.onOptionsItemSelected(item);
   }
    
}

