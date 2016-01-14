package com.roger.psdloadingview.library.animate;

import android.graphics.Canvas;
import com.roger.psdloadingview.library.PsdLoadingView;
import java.util.ArrayList;

/**
 * Created by Roger on 2016/1/8.
 */
public class TranslationX2Animate extends BaseAnimate {

    ArrayList<Float> movexArray;
    boolean isBegining;
    boolean isEnding;


    @Override public void init(PsdLoadingView mPsdLoadingView) {
        super.init(mPsdLoadingView);
    }


    @Override public void startLoading() {
        super.startLoading();
        isBegining = true;
        isEnding = false;
    }


    @Override public void stopLoading() {
        super.stopLoading();
        movexArray.clear();
        isBegining = false;
        isEnding = true;
    }


    @Override public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isStop) {
            if (progress > 0.999f) {
                isBegining = false;
            }
            if (movexArray == null || movexArray.size() < textLength) {
                movexArray = new ArrayList<Float>(textLength);
                for (int i = 0; i < textLength; i++) {
                    movexArray.add(0.0f);
                }
            }
            for (int i = 0; i < textLength; i++) {
                if (isEnding || isBegining ||
                        ((float) i < progress * (float) textLength &&
                                progress * (float) textLength <
                                        ((float) i + 1f))) {
                    float temp = progress * (mPsdLoadingView.getWidth() -
                            (textLength + 2) * distance);
                    float maxtemp = ((i + 1) / (float) textLength) *
                            (mPsdLoadingView.getWidth() -
                                    (textLength + 2) * distance);
                    movexArray.set(i, Math.min(temp, maxtemp));
                }
                canvas.drawText(DOT + "", 0, 1,
                        movexArray.get(i) + (i + 1) * distance, startY, mPaint);
            }
        }
    }
}
