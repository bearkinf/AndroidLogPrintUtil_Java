# AndroidLogLibJava
Android logcat go to Line

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LogPrintUtil.setDebug( BuildConfig.DEBUG ? LogPrintUtil.All : LogPrintUtil.None);

        LogPrintUtil.e("MainActivity_e");

        LogPrintUtil.v("MainActivity_v");

        LogPrintUtil.i("MainActivity_i");

        LogPrintUtil.w("MainActivity_w");

        LogPrintUtil.d("MainActivity_d");
    }
}

