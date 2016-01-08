package com.roger.psdloadingview.library;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.roger.psdloadingview.library.animate.BaseAnimate;
import com.roger.psdloadingview.library.animate.IAnimate;
import com.roger.psdloadingview.library.animate.TranslationXAnimate;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PsdLoadingView extends EditText {

    private IAnimate mIAnimate;


    public PsdLoadingView(Context context) {
        super(context);
        init();
    }


    public PsdLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public PsdLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mIAnimate = new TranslationXAnimate();
        mIAnimate.init(this);
    }


    public void startLoading() {
        mIAnimate.startLoading();
    }


    public void stopLoading() {
        mIAnimate.stopLoading();
    }


    public void setDuration(int duration) {
        mIAnimate.setDuration(duration);
    }


    public Editable getTextDuringLoading() {
        BaseAnimate baseAnimate = (BaseAnimate) mIAnimate;
        if (baseAnimate.isLoading) {
            return baseAnimate.text;
        }
        else {
            return super.getText();
        }
    }


    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mIAnimate.onDraw(canvas);
    }
}
