package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG3";
    private final static int MSG_TAG = 1234;
    public final static String ACTION_ANSWER = "Service3";
    public final static String EXTRA_ANSWER = "jp.ac.titech.itpro.sdl.service3";

    public Service3() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        //ブロードキャストレシーバーに自作インテントを送信する
        Intent intent1 = new Intent();  //空のインテントを生成
        intent1.setAction(this.ACTION_ANSWER); //インテントのアクション名を設定
        intent1.putExtra(this.EXTRA_ANSWER,"Service3!!!!!!!!!!");
        sendBroadcast(intent1);         //インテントを送信
        try {
            Thread.sleep(5000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
