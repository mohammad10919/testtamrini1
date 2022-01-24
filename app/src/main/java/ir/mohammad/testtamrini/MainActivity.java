package ir.mohammad.testtamrini;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,new HomeFragment()).commit();
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.e(TAG, "onNavigationItemSelected: " );
        if (item.getItemId() ==R.id.homejson) {
            Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
            openFragment(new HomeFragment());
            return true;
            }else if (item.getItemId()== R.id.chat){
            Toast.makeText(MainActivity.this, "chat", Toast.LENGTH_SHORT).show();
            openFragment(new ChatFragment());
            return true;
        }else if (item.getItemId()== R.id.tablighat){
            Toast.makeText(MainActivity.this, "tablighat", Toast.LENGTH_SHORT).show();
            openFragment(new TablighFragment());
            return true;
        }else if (item.getItemId()== R.id.Profile){
            Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();
            openFragment(new TablighFragment());
            return true;
        }else if (item.getItemId()== R.id.setting){
            Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();
            openFragment(new TablighFragment());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout,fragment);
        transaction.commit();


    }

}