package dicodingsubmissionthree.wiranata.com;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import dicodingsubmissionthree.wiranata.com.Fragment.NowPlaying;
import dicodingsubmissionthree.wiranata.com.Fragment.Upcoming;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.now_playing:
                    fragment = new NowPlaying();

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.upcoming:
                    fragment = new Upcoming();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null){
            navigation.setSelectedItemId(R.id.now_playing);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings){
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
