package com.calldoctor.calldoctor.model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.calldoctor.calldoctor.utility.FontCache;


/**
 * Created by Shihab on 8/22/2017.
 */

public class CDButton extends AppCompatButton {


    public CDButton(Context context) {
        super(context);
//        init();
        applyCustomFont(context);
    }

    public CDButton(Context context, AttributeSet attrs) {

        super(context, attrs);
        applyCustomFont(context);
    }

    public CDButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
//        init();
        applyCustomFont(context);

    }

    private void init() {
        Typeface font_type = Typeface.createFromAsset(getContext().getAssets(), "font/BalooBhaijaan-Regular.ttf");
        setTypeface(font_type);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("font/BalooBhaijaan-Regular.ttf", context);
        setTypeface(customFont);
    }

}