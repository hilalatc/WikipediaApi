package com.example.Software;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Thread hazirlaniyor
        Thread thread = new Thread() {

            @Override
            public void run() {

                try {
                    synchronized (this) {
                        // Uygulama 4 saniye ayni ekranda bekliyor
                        wait(1000);
                    }
                } catch (InterruptedException e) {

                    // Hata yonetimi

                } finally {

                    finish();

                    // Yeni acılmak istenen Intent
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), ListeEkran.class);
                    startActivity(intent);

                }

            }
        };

        // Thread ba�lat�l�yor
        thread.start();
    }
}
