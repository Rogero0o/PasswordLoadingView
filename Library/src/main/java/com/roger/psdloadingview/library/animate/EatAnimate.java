package com.roger.psdloadingview.library.animate;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import com.roger.psdloadingview.library.PsdLoadingView;

public class EatAnimate extends BaseAnimate {

    private Paint mEyePaint;
    private float eyeProgress;
    private boolean isBegining = false;
    private boolean isLeftTurn = true;

    float radius, left, right, top, bottom, centerX, centerY, eyeX, eyeY;
    float startAngle, sweepAngle;


    @Override public void init(PsdLoadingView mPsdLoadingView) {
        super.init(mPsdLoadingView);
        mEyePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mEyePaint.setColor(Color.WHITE);
        mEyePaint.setStyle(Paint.Style.FILL);
        setDuration(duration * 6);
    }


    @Override public void startLoading() {
        super.startLoading();
        isBegining = true;
        radius = mPsdLoadingView.getHeight() / 8.0f;
        centerY = (mPsdLoadingView.getHeight()) / 2.0f;
        top = centerY - radius;
        bottom = centerY + radius;

        ValueAnimator eyeAnimator = ValueAnimator.ofFloat(0, 1)
                                                 .setDuration(100L);
        eyeAnimator.setInterpolator(new AccelerateInterpolator());
        eyeAnimator.setRepeatCount(Animation.INFINITE);
        eyeAnimator.setRepeatMode(ValueAnimator.REVERSE);
        eyeAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        eyeProgress = (float) animation.getAnimatedValue();
                    }
                });
        eyeAnimator.start();
    }


    @Override public void stopLoading() {
        super.stopLoading();
    }


    @Override public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isStop) {

            if (progress > 0.999f) {
                isLeftTurn = false;
            }
            else if (progress < 0.001f) {
                isLeftTurn = true;
            }

            if (progress > 0.999f) {
                isBegining = false;
            }

            drawEater(canvas);

            if (isBegining) {
                for (int i = 0; i < textLength; i++) {
                    float moveX = (i + 1) * distance;
                    if (moveX < centerX) {
                        canvas.drawText(DOT + "", 0, 1, moveX, startY, mPaint);
                    }
                }
            }
            else {
                float moveX;
                if (isLeftTurn) {
                    moveX = centerX - radius - distance / 2.0f;
                }
                else {
                    moveX = centerX + radius;
                }
                canvas.drawText(DOT + "", 0, 1, moveX, startY, mPaint);
            }
        }
    }


    private void drawEater(Canvas canvas) {
        centerX = (mPsdLoadingView.getWidth() * 1.4f * (1.0f - progress)) -
                mPsdLoadingView.getWidth() * 0.2f;
        left = centerX - radius;
        right = centerX + radius;
        RectF oval2 = new RectF(left, top, right, bottom);

        startAngle = 225f - eyeProgress * 30.0f;
        sweepAngle = 270f + eyeProgress * 60.0f;

        eyeX = centerX + radius / 2.0f;
        eyeY = centerY - radius / 2.0f;
        if (!isLeftTurn) {
            startAngle = 225f - 180f - eyeProgress * 25.0f;
            eyeX = centerX - radius / 2.0f;
        }
        canvas.drawArc(oval2, startAngle, sweepAngle, true, mPaint);
        canvas.drawCircle(eyeX, eyeY, radius / 5.0f, mEyePaint);
    }


    @Override protected boolean whenStop() {
        return (!isLoading && (progress <= 0.001f || progress >= 0.999f));
    }
}
