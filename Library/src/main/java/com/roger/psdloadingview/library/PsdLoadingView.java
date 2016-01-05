package com.roger.psdloadingview.library;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PsdLoadingView extends EditText {
    public PsdLoadingView(Context context) {
        super(context);
    }


    public PsdLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }


    public PsdLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }
}
