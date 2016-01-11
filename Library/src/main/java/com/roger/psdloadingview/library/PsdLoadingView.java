package com.roger.psdloadingview.library;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.roger.psdloadingview.library.animate.BaseAnimate;
import com.roger.psdloadingview.library.animate.IAnimate;
import com.roger.psdloadingview.library.animate.TranslationX2Animate;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PsdLoadingView extends EditText {

    private IAnimate mIAnimate = new TranslationX2Animate();


    public PsdLoadingView(Context context) {
        super(context);
        init(mIAnimate);
    }


    public PsdLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(mIAnimate);
    }


    public PsdLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(mIAnimate);
    }


    public void init(IAnimate mIAnimate) {
        this.mIAnimate = mIAnimate;
        this.mIAnimate.init(this);
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
