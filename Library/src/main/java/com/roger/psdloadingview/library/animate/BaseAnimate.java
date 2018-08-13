package com.roger.psdloadingview.library.animate;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import com.roger.psdloadingview.library.PsdLoadingView;

/**
 * Created by Roger on 2016/1/8.
 */
public class BaseAnimate implements IAnimate {

    protected static char DOT = '\u2022';
    protected PsdLoadingView mPsdLoadingView;
    protected Paint mPaint;

    protected int textLength;
    protected int startY = 0;
    protected float distance = 0;
    protected float progress;
    public Editable text;
    protected CharSequence hint;
    public boolean isLoading;
    protected boolean isStop = true;

    protected int duration = 500;
    ValueAnimator valueAnimator;


    @Override public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override public boolean isLoading() {
        return isLoading;
    }


    @Override public void init(PsdLoadingView mPsdLoadingView) {
        this.mPsdLoadingView = mPsdLoadingView;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mPsdLoadingView.getCurrentTextColor());
        mPaint.setStyle(Paint.Style.FILL);

        mPsdLoadingView.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }


    @Override public void startLoading() {

        textLength = mPsdLoadingView.getText().length();
        startY = mPsdLoadingView.getBaseline();

        if (TextUtils.isEmpty(mPsdLoadingView.getText().toString())) {
            return;
        }
        isLoading = true;
        isStop = false;
        distance = mPsdLoadingView.getPaint()
                                  .measureText(
                                          mPsdLoadingView.getText().charAt(0) +
                                                  "");
        mPaint.setTextSize(mPsdLoadingView.getTextSize());
        text = mPsdLoadingView.getText();
        hint = mPsdLoadingView.getHint();
        mPsdLoadingView.setMinWidth(mPsdLoadingView.getWidth());
        mPsdLoadingView.setText("");
        mPsdLoadingView.setHint("");
        mPsdLoadingView.setCursorVisible(false);
        valueAnimator = ValueAnimator.ofFloat(0, 1).setDuration(duration);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setRepeatCount(Animation.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        progress = (float) animation.getAnimatedValue();
                        mPsdLoadingView.invalidate();
                        if (whenStop()) {
                            valueAnimator.cancel();
                            isStop = true;
                            mPsdLoadingView.setHint(hint);
                            mPsdLoadingView.setText(text);
                            mPsdLoadingView.setCursorVisible(true);
                            mPsdLoadingView.setSelection(
                                    mPsdLoadingView.getText().length());
                        }
                    }
                });
        valueAnimator.start();
    }


    @Override public void stopLoading() {
        isLoading = false;
    }


    @Override public void onDraw(Canvas canvas) {
    }


    @Override public void onVisibilityChanged(boolean isVisibiable) {
        if (!isLoading) {
            return;
        }
        if (isVisibiable) {
            valueAnimator.resume();
        }
        else {
            valueAnimator.pause();
        }
    }


    protected boolean whenStop() {
        return (!isLoading && progress <= 0.001f);
    }
}
