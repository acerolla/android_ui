package com.acerolla.awesome_ui.main.container;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.acerolla.awesome_ui.animation.AnimationFragment;
import com.acerolla.awesome_ui.main.home.HomeFragment;

/**
 * Created by Evgeniy Solovev
 * Date: 06.10.2018
 * Email: solevur@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    private MainView mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mView = new MainView(this);
        setContentView(mView);

        setListeners();
    }

    private void setListeners() {
        mView.setNavigationItemSelectedListener(menuItem -> {
            mView.closeDrawer(Gravity.START);
            switch (menuItem.getItemId()) {
                case MainView.MENU_ITEM_ANIMATION:
                    addFragment(new AnimationFragment());
                    return true;
            }
            return false;
        });
    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(fragment.getClass().getName())
                .add(MainView.ID_CONTENT_FRAME, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showFirstFragment();
    }

    private void showFirstFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(MainView.ID_CONTENT_FRAME, new HomeFragment())
                .commit();
    }

    public void openDrawer() {
        mView.openDrawer(Gravity.START);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mView = null;
    }
}
