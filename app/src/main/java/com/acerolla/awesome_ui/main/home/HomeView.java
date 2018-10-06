package com.acerolla.awesome_ui.main.home;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;

import com.acerolla.awesome_ui.R;
import com.acerolla.awesome_ui.utils.UiUtils;

/**
 * Created by Evgeniy Solovev
 * Date: 06.10.2018
 * Email: solevur@gmail.com
 */
public class HomeView extends ConstraintLayout {

    private static final int ID_ROOT = 1;
    private static final int ID_TOOLBAR = 2;

    private Toolbar mToolbar;

    public HomeView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        setId(ID_ROOT);
        setClickable(true);
        setBackgroundColor(Color.WHITE);

        mToolbar = new Toolbar(getContext());
        mToolbar.setId(ID_TOOLBAR);
        mToolbar.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("Home Screen");
        mToolbar.setNavigationIcon(R.drawable.ic_menu);

        LayoutParams toolbarParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                UiUtils.getToolbarHeight());
        toolbarParams.topToTop = ID_ROOT;
        mToolbar.setLayoutParams(toolbarParams);
        addView(mToolbar);

        AppCompatTextView text = new AppCompatTextView(getContext());
        text.setText("Welcome to my world. The world full of AWESOME UI!!!");
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);

        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.topToBottom = ID_TOOLBAR;
        textParams.bottomToBottom = ID_ROOT;
        textParams.leftToLeft = ID_ROOT;
        textParams.rightToRight = ID_ROOT;
        textParams.verticalBias = 0.40f;
        text.setLayoutParams(textParams);
        addView(text);
    }

    public void setOnToolbarIconClickListener(OnClickListener listener) {
        mToolbar.setNavigationOnClickListener(listener);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mToolbar = null;
    }
}
