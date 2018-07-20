package kr.bearkinf.yena.log_library_java;

import android.util.Log;

/**
 * 안드로이드 스튜디오 로그켓 클래스.
 * 안드로이드 스튜디오 로그켓에서 로그켓 출력한 곳을 쉽게
 * 이동하기 위해 만듬
 */
public class LogPrintUtil {

    private static final int Debug = 0x01;
    private static final int Warn = 0x02;
    private static final int Error = 0x04;
    private static final int Info = 0x08;
    private static final int Verbose = 0x10;

    public static final int None = 0x00;
    public static final int All = Debug | Warn | Error | Info | Verbose;

    private static int FLAGS = BuildConfig.DEBUG ? All : None;

    private static String TAG = "log";

    /**
     * 디버깅 설정
     * LogPrintUtil.setDebug( BuildConfig.DEBUG ? LogPrintUtil.All : LogPrintUtil.None);
     */
    public static void setDebug(int flags) {
        FLAGS = flags;
    }

    /**
     * 테그설정
     */
    public static void setTag(String tag) {
        TAG = tag;
    }


    /**
     * 로그켓 출력 메서드
     */
    private static String buildMakeMessage(Object strMsg) {

        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("(" + ste.getFileName() + ":" + ste.getLineNumber() + ")");
        sb.append(strMsg);
        return sb.toString();

    }

    /**
     * 파란색, blue
     */
    public static void d(Object strMsg) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }

        Log.d(TAG, buildMakeMessage(strMsg));
    }

    /**
     * 파란색, blue
     */
    public static void d(String strTag, Object strMsg) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }

        Log.d(strTag, buildMakeMessage(strMsg));
    }

    /**
     * 노란색, yellow
     */
    public static void w(Object strMsg) {
        if ((FLAGS & Warn) != Warn) {
            return;
        }

        Log.w(TAG, buildMakeMessage(strMsg));
    }

    /**
     * 노란색, yellow
     */
    public static void w(String strTag, Object strMsg) {
        if ((FLAGS & Warn) != Warn) {
            return;
        }

        Log.w(strTag, buildMakeMessage(strMsg));
    }

    /**
     * 빨간색, red
     */
    public static void e(Object strMsg) {
        if ((FLAGS & Error) != Error) {
            return;
        }

        Log.e(TAG, buildMakeMessage(strMsg));
    }

    /**
     * 빨간색, red
     */
    public static void e(String strTag, Object strMsg) {
        if ((FLAGS & Error) != Error) {
            return;
        }

        Log.e(strTag, buildMakeMessage(strMsg));
    }

    /**
     * 녹색, green
     */
    public static void i(Object strMsg) {
        if ((FLAGS & Info) != Info) {
            return;
        }

        Log.i(TAG, buildMakeMessage(strMsg));
    }

    /**
     * 녹색, green
     */
    public static void i(String strTag, Object strMsg) {
        if ((FLAGS & Info) != Info) {
            return;
        }

        Log.i(strTag, buildMakeMessage(strMsg));
    }

    /**
     * 하얀색, white
     */
    public static void v(Object strMsg) {
        if ((FLAGS & Verbose) != Verbose) {
            return;
        }

        Log.v(TAG, buildMakeMessage(strMsg));
    }

    /**
     * 하얀색, white
     */
    public static void v(String strTag, Object strMsg) {
        if ((FLAGS & Verbose) != Verbose) {
            return;
        }

        Log.v(strTag, buildMakeMessage(strMsg));
    }
}
