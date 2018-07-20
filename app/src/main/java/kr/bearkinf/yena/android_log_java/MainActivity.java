package kr.bearkinf.yena.android_log_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kr.bearkinf.yena.log_library_java.BuildConfig;
import kr.bearkinf.yena.log_library_java.LogPrintUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        LogPrintUtil.setDebug(BuildConfig.DEBUG ? LogPrintUtil.All : LogPrintUtil.None);
        LogPrintUtil.setTag("Log");

        LogPrintUtil.e("MainActivity_e");

        LogPrintUtil.v("MainActivity_v");

        LogPrintUtil.i("MainActivity_i");

        LogPrintUtil.w("MainActivity_w");

        LogPrintUtil.d("MainActivity_d");
    }
}
