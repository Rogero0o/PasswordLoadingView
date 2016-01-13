package com.roger.psdloadingview.library.animate;

import android.graphics.Canvas;
import com.roger.psdloadingview.library.PsdLoadingView;

/**
 * Created by Administrator on 2016/1/8.
 */
public interface IAnimate {
    void init(PsdLoadingView mPsdLoadingView);

    void startLoading();

    void stopLoading();

    void setDuration(int duration);

    void onDraw(Canvas canvas);

    void onVisibilityChanged(boolean isVisibiable);
}
