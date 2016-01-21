package com.roger.psdloadingview.library.animate;

import android.graphics.Canvas;

/**
 * Created by Roger on 2016/1/8.
 */
public class TranslationXAnimate extends BaseAnimate {
    @Override public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isStop) {
            for (int i = 0; i < textLength; i++) {
                canvas.drawText(String.valueOf(DOT), 0, 1, progress *
                        (mPsdLoadingView.getWidth() -
                                (textLength + 2) * distance) +
                        (i + 1) * distance, startY, mPaint);
            }
        }
    }
}
