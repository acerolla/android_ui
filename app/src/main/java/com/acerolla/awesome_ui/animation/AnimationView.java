package com.acerolla.awesome_ui.animation;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.acerolla.awesome_ui.R;
import com.acerolla.awesome_ui.utils.UiUtils;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Evgeniy Solovev
 * Date: 06.10.2018
 * Email: solevur@gmail.com
 */
public class AnimationView extends ConstraintLayout {

    private static final int ID_ROOT = 1;
    private static final int ID_TOOLBAR = 2;

    private Toolbar mToolbar;
    private AppCompatTextView mText;
    private AppCompatButton mButton;

    public AnimationView(Context context) {
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
        mToolbar.setTitle("Animation");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        LayoutParams toolbarParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                UiUtils.getToolbarHeight());
        toolbarParams.topToTop = ID_ROOT;
        mToolbar.setLayoutParams(toolbarParams);
        addView(mToolbar);

        mText = new AppCompatTextView(getContext());
        mText.setText("Hello world!");
        mText.setTextSize(24);

        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.topToBottom = ID_TOOLBAR;
        textParams.bottomToBottom = ID_ROOT;
        textParams.leftToLeft = ID_ROOT;
        textParams.rightToRight = ID_ROOT;
        textParams.verticalBias = 0.30f;
        mText.setLayoutParams(textParams);
        addView(mText);

        mButton = new AppCompatButton(getContext());
        mButton.setText("animate");
        mButton.setAllCaps(false);
        mButton.setTextSize(18);

        LayoutParams buttonParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.topToBottom = ID_TOOLBAR;
        buttonParams.bottomToBottom = ID_ROOT;
        buttonParams.leftToLeft = ID_ROOT;
        buttonParams.rightToRight = ID_ROOT;
        buttonParams.verticalBias = 0.85f;
        mButton.setLayoutParams(buttonParams);
        addView(mButton);
    }

    public void setOnToolbarIconClickListener(OnClickListener listener) {
        mToolbar.setNavigationOnClickListener(listener);
    }

    public void setOnButtonClickListener(OnClickListener listener) {
        mButton.setOnClickListener(listener);
    }

    public void animateText() {
        YoYo.with(Techniques.Shake)
                .duration(550)
                .playOn(mText);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mToolbar = null;
        mText = null;
        mButton = null;
    }
}
