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
    private static String buildMakeMessage(Object strMsg, boolean sleepCheck) {

        if (sleepCheck) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        StackTraceElement[] traceElement = Thread.currentThread().getStackTrace();

        int position = 0;
        boolean find = false;

        // 실제 내 소스가 실행되는 곳의 위치를 찾는다.
        for (int i = 0; i < traceElement.length; i++) {
            // 내위치를 찾고.
            if (traceElement[i].getClassName().equals(LogPrintUtil.class.getName())) {
                find = true;
            }
            // 내위치를 찾은 다음 위치를 정하는곳이 실제 보여지는, 동작하는 클래스이다.
            if (find && !traceElement[i].getClassName().equals(LogPrintUtil.class.getName())) {
                position = i;
                break;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("(" + traceElement[position].getFileName() + ":" + traceElement[position].getLineNumber() + ")");
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
        Log.d(TAG, buildMakeMessage(strMsg, false));
    }

    /**
     * 파란색, blue
     */
    public static void d(Object strMsg, boolean sleepCheck) {

        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.d(TAG, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 파란색, blue
     */
    public static void d(Object strMsg, String strTag) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.d(strTag, buildMakeMessage(strMsg, false));
    }

    /**
     * 파란색, blue
     */
    public static void d(Object strMsg, String strTag, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.d(strTag, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 노란색, yellow
     */
    public static void w(Object strMsg) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.w(TAG, buildMakeMessage(strMsg, false));
    }

    /**
     * 노란색, yellow
     */
    public static void w(Object strMsg, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.w(TAG, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 노란색, yellow
     */
    public static void w(Object strMsg, String strTag) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.w(strTag, buildMakeMessage(strMsg, false));
    }

    /**
     * 노란색, yellow
     */
    public static void w(Object strMsg, String strTag, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.w(strTag, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 빨간색, red
     */
    public static void e(Object strMsg) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.e(TAG, buildMakeMessage(strMsg, false));
    }

    /**
     * 빨간색, red
     */
    public static void e(Object strMsg, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.e(TAG, buildMakeMessage(strMsg, sleepCheck));
    }


    /**
     * 빨간색, red
     */
    public static void e(Object strMsg, String strTag) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.e(strTag, buildMakeMessage(strMsg, false));
    }

    /**
     * 빨간색, red
     */
    public static void e(Object strMsg, String strTag, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.e(strTag, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 녹색, green
     */
    public static void i(Object strMsg) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.i(TAG, buildMakeMessage(strMsg, false));
    }


    /**
     * 녹색, green
     */
    public static void i(Object strMsg, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.i(TAG, buildMakeMessage(strMsg, sleepCheck));
    }


    /**
     * 녹색, green
     */
    public static void i(Object strMsg, String strTag) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.i(strTag, buildMakeMessage(strMsg, false));
    }

    /**
     * 녹색, green
     */
    public static void i(Object strMsg, String strTag, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.i(strTag, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 하얀색, white
     */
    public static void v(Object strMsg) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.v(TAG, buildMakeMessage(strMsg, false));
    }

    /**
     * 하얀색, white
     */
    public static void v(Object strMsg, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.v(TAG, buildMakeMessage(strMsg, sleepCheck));
    }

    /**
     * 하얀색, white
     */
    public static void v(Object strMsg, String strTag) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.v(strTag, buildMakeMessage(strMsg, false));
    }

    /**
     * 하얀색, white
     */
    public static void v(Object strMsg, String strTag, boolean sleepCheck) {
        if ((FLAGS & Debug) != Debug) {
            return;
        }
        Log.v(strTag, buildMakeMessage(strMsg, sleepCheck));
    }
}
