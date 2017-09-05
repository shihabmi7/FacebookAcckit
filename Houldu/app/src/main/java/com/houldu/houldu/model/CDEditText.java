package com.houldu.houldu.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;

import com.houldu.houldu.R;


/**
 * Created by Shihab on 8/23/2017.
 */

public class CDEditText extends android.support.v7.widget.AppCompatEditText {

    public CDEditText(Context context) {
        super(context);
        setNumberInputType();
    }

    public CDEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setNumberInputType();
    }

    public CDEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setNumberInputType();
    }

    public void setLeftIcon() {
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_manage, 0, 0, 0);
    }

    public void setNumberInputType() {
        setInputType(EditorInfo.TYPE_CLASS_TEXT);
    }


}
