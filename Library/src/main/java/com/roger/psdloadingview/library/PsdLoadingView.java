package com.roger.psdloadingview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PsdLoadingView extends RelativeLayout {

    private Context mContext;
    private AttributeSet mAttrs;


    public PsdLoadingView(Context context) {
        super(context);
    }


    public PsdLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;
        init();
    }


    public PsdLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        init();
    }


    private void init() {
        EditText ed = new EditText(mContext);
        ed.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
        LayoutParams lp = new LayoutParams(mContext, mAttrs);
        ed.setLayoutParams(lp);

        TypedArray a = mContext.obtainStyledAttributes(mAttrs,
                R.styleable.psdloadView);

        ed.setText(a.getString(R.styleable.psdloadView_text));
        ed.setHint(a.getString(R.styleable.psdloadView_hint));
        ed.setTextColor(
                a.getColor(R.styleable.psdloadView_textColor, Color.BLACK));

        float scale = getResources().getDisplayMetrics().density;
        float dips = ed.getTextSize() / scale;
        ed.setTextSize(a.getDimension(R.styleable.psdloadView_textSize, dips));
        a.recycle();
        this.addView(ed);
    }
}
