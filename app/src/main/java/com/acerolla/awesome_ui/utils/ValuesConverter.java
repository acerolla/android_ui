package com.acerolla.awesome_ui.utils;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.util.TypedValue;

/**
 * Created by Evgeniy Solovev
 * Date: 06.10.2018
 * Email: solevur@gmail.com
 */
public class ValuesConverter {

    public static final int DP_1 = 1;
    public static final int DP_2 = 2;
    public static final int DP_3 = 3;
    public static final int DP_4 = 4;
    public static final int DP_5 = 5;
    public static final int DP_6 = 6;
    public static final int DP_7 = 7;
    public static final int DP_10 = 10;
    public static final int DP_13 = 13;
    public static final int DP_15 = 15;
    public static final int DP_16 = 16;
    public static final int DP_20 = 20;
    public static final int DP_22 = 22;
    public static final int DP_23 = 23;
    public static final int DP_25 = 25;
    public static final int DP_30 = 30;
    public static final int DP_35 = 35;
    public static final int DP_40 = 40;
    public static final int DP_45 = 45;
    public static final int DP_48 = 48;
    public static final int DP_50 = 50;
    public static final int DP_56 = 56;
    public static final int DP_60 = 60;
    public static final int DP_63 = 63;
    public static final int DP_64 = 64;
    public static final int DP_65 = 65;
    public static final int DP_70 = 70;
    public static final int DP_80 = 80;
    public static final int DP_90 = 90;
    public static final int DP_100 = 100;
    public static final int DP_110 = 110;
    public static final int DP_120 = 120;
    public static final int DP_130 = 130;
    public static final int DP_170 = 170;
    public static final int DP_200 = 200;

    private static final SparseIntArray CONVERTED_VALUES = new SparseIntArray();

    public static int dp2px(final int dp) {
        Integer value = CONVERTED_VALUES.get(dp);
        if (value == 0) {
            value = (int) (dp * Resources.getSystem().getDisplayMetrics().density);
            CONVERTED_VALUES.put(dp, value);
        }
        return value;
    }

    public static int spToPx(final int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sp, Resources.getSystem().getDisplayMetrics());
    }

    public static int pxToDp(final int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
