package com.houldu.houldu.model;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.houldu.houldu.utility.FontCache;


/**
 * Created by Shihab on 8/22/2017.
 */

public class CDTextView extends android.support.v7.widget.AppCompatTextView {


    public CDTextView(Context context) {
        super(context);
        applyCustomFont(context);

    }

    public CDTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);

    }

    public CDTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("font/BalooBhaijaan-Regular.ttf", context);
        setTypeface(customFont);
    }

}
