package aaronyang.internationalization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageUtils.saveLocale(new WeakReference<Context>(MainActivity.this), "auto");
                if (!Locale.getDefault().getLanguage().equals(getResources().getConfiguration().locale.getLanguage())) {
                    //点击自动如果和系统的语言环境不一致则更换
                    LanguageUtils.setAppLocale(new WeakReference<Context>(MainActivity.this), Locale.getDefault());
                    recreate();
                }
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageUtils.saveLocale(new WeakReference<Context>(MainActivity.this), "zh");
                LanguageUtils.setAppLocale(new WeakReference<Context>(MainActivity.this), Locale.SIMPLIFIED_CHINESE);
                recreate();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageUtils.saveLocale(new WeakReference<Context>(MainActivity.this), "en");
                LanguageUtils.setAppLocale(new WeakReference<Context>(MainActivity.this), Locale.ENGLISH);
                recreate();
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("========", "=====系统:" + LanguageUtils.getSystemLocale());
        Log.i("========", "=====language:" + LanguageUtils.getAppLocale(new WeakReference<Context>(this)).getLanguage());
        Log.i("========", "=====country:" + LanguageUtils.getAppLocale(new WeakReference<Context>(this)).getCountry());

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
}
