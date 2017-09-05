package com.calldoctor.calldoctor.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;

import com.calldoctor.calldoctor.R;


/**
 * Created by Shihab on 8/23/2017.
 */

public class CDEditTextNumber extends android.support.v7.widget.AppCompatEditText {

    public CDEditTextNumber(Context context) {
        super(context);
        setNumberInputType();
    }

    public CDEditTextNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
        setNumberInputType();
    }

    public CDEditTextNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setNumberInputType();
    }

    public void setLeftIcon() {
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_manage, 0, 0, 0);
    }
    public void setNumberInputType() {
        setInputType(EditorInfo.TYPE_CLASS_NUMBER);
    }



}
