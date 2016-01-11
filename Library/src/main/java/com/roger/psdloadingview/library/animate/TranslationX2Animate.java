package com.roger.psdloadingview.library.animate;

import android.graphics.Canvas;
import com.roger.psdloadingview.library.PsdLoadingView;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/8.
 */
public class TranslationX2Animate extends BaseAnimate {

    ArrayList<Float> movexArray;


    @Override public void init(PsdLoadingView mPsdLoadingView) {
        super.init(mPsdLoadingView);
    }


    @Override public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isStop) {
            if (movexArray == null || movexArray.size() < textLength) {
                movexArray = new ArrayList<Float>(textLength);
                for (int i = 0; i < textLength; i++) {
                    movexArray.add(0.0f);
                }
            }
            for (int i = 0; i < textLength; i++) {
                if ((float) i < progress * (float) textLength &&
                        progress * (float) textLength < ((float) i + 1f)) {
                    movexArray.set(i, progress * (mPsdLoadingView.getWidth() -
                            (textLength + 2) * distance));
                }
                canvas.drawText(DOT + "", 0, 1,
                        movexArray.get(i) + (i + 1) * distance, startY, mPaint);
            }
        }
    }
}
