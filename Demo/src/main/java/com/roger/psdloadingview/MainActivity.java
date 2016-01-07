package com.roger.psdloadingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.roger.psdloadingview.library.PsdLoadingView;
import com.roger.psdloadingview.library.PsdLoadingView2;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PsdLoadingView psd = (PsdLoadingView) findViewById(
                R.id.psdloadingview);

        final PsdLoadingView2 psd2 = (PsdLoadingView2) findViewById(
                R.id.psdloadingview2);
        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        psd.startLoading();
                        psd2.startLoading();
                    }
                });
    }
}
