package com.roger.psdloadingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.roger.psdloadingview.library.PsdLoadingView;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PsdLoadingView psd = (PsdLoadingView) findViewById(
                R.id.psdloadingview);

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        psd.startLoading();
                    }
                });

        findViewById(R.id.success).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        psd.stopLoading();
                    }
                });
    }
}
