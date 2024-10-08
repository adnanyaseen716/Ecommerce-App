package pk.org.cas.EcommerceApp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import pk.org.cas.EcommerceApp.Cart.CartFragment;
import pk.org.cas.EcommerceApp.Favourite.FavouriteFragment;
import pk.org.cas.EcommerceApp.Home.HomeFragment;
import pk.org.cas.EcommerceApp.Profile.ProfileFragment;

// This is the Home page of our app.
public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

// When app is run for the first time, home fragment will be loaded automatically.
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if(itemId == R.id.home){
                    loadFragment(new HomeFragment());
                }
                if(itemId == R.id.cart){
                    loadFragment(new CartFragment());
                }
                if(itemId == R.id.favourite){
                    loadFragment(new FavouriteFragment());
                }
                if(itemId == R.id.profile){
                    loadFragment(new ProfileFragment());
                }

                return true;
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}

