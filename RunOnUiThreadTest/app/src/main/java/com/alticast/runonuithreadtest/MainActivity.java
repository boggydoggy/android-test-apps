package com.alticast.runonuithreadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int mainValue = 0;
    int backValue = 0;
    TextView mainText;
    TextView backText;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainvalue);
        backText = (TextView) findViewById(R.id.backvalue);

        BackThread thread = new BackThread();
        thread.setDaemon(true);
        thread.start();

    }

    public void mOnClick(View v){
        mainValue++;
        mainText.setText("MainValue:" + mainValue);
    }

    class BackThread extends Thread{
        @Override
        public void run() {
            while(true){
                backValue++;

                //메인 스레드에 Runnable 동작을 전송
                handler.post(new Runnable(){
                    @Override
                    public void run() {  // UI 접근
                        backText.setText("BackValue: " + backValue);
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


