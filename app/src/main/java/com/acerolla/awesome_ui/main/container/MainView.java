package com.acerolla.awesome_ui.main.container;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.acerolla.awesome_ui.R;

/**
 * Created by Evgeniy Solovev
 * Date: 06.10.2018
 * Email: solevur@gmail.com
 */
public class MainView extends DrawerLayout {

    public static final int ID_CONTENT_FRAME = 1;
    public static final int MENU_ITEM_ANIMATION = 2;

    private FrameLayout mContentFrame;
    private NavigationView mNavigationView;

    public MainView(@NonNull Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        setFitsSystemWindows(true);

        mContentFrame = new FrameLayout(getContext());
        mContentFrame.setId(ID_CONTENT_FRAME);
        mContentFrame.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        addView(mContentFrame);

        mNavigationView = new NavigationView(getContext());
        mNavigationView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        mNavigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
        mNavigationView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.START));
        addView(mNavigationView);

        initializeMenu();
    }

    private void initializeMenu() {
        Menu menu = mNavigationView.getMenu();
        menu.setGroupCheckable(Menu.NONE, true, true);

        menu.add(Menu.NONE, MENU_ITEM_ANIMATION, MENU_ITEM_ANIMATION, "1) Animation");
    }

    public void setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener listener) {
        mNavigationView.setNavigationItemSelectedListener(listener);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mContentFrame = null;
        mNavigationView = null;
    }
}
