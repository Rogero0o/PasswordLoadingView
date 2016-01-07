package com.roger.psdloadingview.library;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PsdLoadingView2 extends EditText {

    private static char DOT = '\u2022';
    protected Paint mPaint;
    private Context mContext;
    private AttributeSet mAttrs;

    private int textLength;
    private int startY = 0;
    private float distance = 0;
    private float progress;
    private Editable text;
    private CharSequence hint;
    private boolean isLoading;

    private int duration = 500;


    public void setDuration(int duration) {
        this.duration = duration;
    }


    public PsdLoadingView2(Context context) {
        super(context);
        init();
    }


    public PsdLoadingView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;
        init();
    }


    public PsdLoadingView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        init();
    }


    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getCurrentTextColor());
        mPaint.setStyle(Paint.Style.FILL);

        setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }


    public void startLoading() {
        textLength = super.getText().length();
        startY = this.getBaseline();

        if (TextUtils.isEmpty(super.getText().toString())) {
            return;
        }

        distance = getPaint().measureText(super.getText().charAt(0) + "");
        mPaint.setTextSize(this.getTextSize());
        text = super.getText();
        hint = super.getHint();
        this.setMinWidth(getWidth());
        setText("");
        setHint("");
        setCursorVisible(false);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1)
                                                   .setDuration(duration);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setRepeatCount(Animation.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        progress = (float) animation.getAnimatedValue();
                        invalidate();
                    }
                });
        valueAnimator.start();
        isLoading = true;
    }


    public Editable getTextDuringLoading() {
        if (isLoading) {
            return text;
        }
        else {
            return super.getText();
        }
    }


    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < textLength; i++) {
            Log.i("Tag", "prgress:" + progress);
            canvas.drawText(DOT + "", 0, 1,
                    progress * (this.getWidth() - (textLength + 2) * distance) +
                            (i + 1) * distance, startY, mPaint);
        }
    }
}
