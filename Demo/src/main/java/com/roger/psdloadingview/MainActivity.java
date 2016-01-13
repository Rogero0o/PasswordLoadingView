package com.roger.psdloadingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.roger.psdloadingview.library.PsdLoadingView;
import com.roger.psdloadingview.library.animate.EatAnimate;
import com.roger.psdloadingview.library.animate.IAnimate;
import com.roger.psdloadingview.library.animate.TranslationX2Animate;
import com.roger.psdloadingview.library.animate.TranslationXAnimate;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PsdLoadingView psd = (PsdLoadingView) findViewById(
                R.id.psdloadingview);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] mItems = getResources().getStringArray(R.array.animate);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        String[] languages = getResources().getStringArray(
                                R.array.animate);
                        Toast.makeText(MainActivity.this,
                                "你点击的是:" + languages[pos], Toast.LENGTH_SHORT)
                             .show();
                        IAnimate iAnimate;
                        switch (pos) {
                            case 0:
                                iAnimate = new TranslationXAnimate();
                                break;
                            case 1:
                                iAnimate = new TranslationX2Animate();
                                break;
                            case 2:
                                iAnimate = new EatAnimate();
                                break;
                            default:
                                iAnimate = new TranslationXAnimate();
                        }
                        psd.init(iAnimate);
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

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
