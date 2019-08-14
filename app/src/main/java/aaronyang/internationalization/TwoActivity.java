package aaronyang.internationalization;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


/**
 * create by AaronYang on 2019-08-13.
 * email: 1390939057@qq.com
 * github: AaronYang23
 * describe:
 */
public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("========","=====系统:"+ Locale.getDefault().getLanguage());
        Log.i("========","=====language:"+getResources().getConfiguration().locale.getLanguage());
        Log.i("========","=====country:"+getResources().getConfiguration().locale.getCountry());

    }
}