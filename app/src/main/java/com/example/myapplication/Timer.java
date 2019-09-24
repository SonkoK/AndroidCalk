package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends AppCompatActivity {
    private TextView txt;
    private Button btn;
    private boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        initializeView();
        btnOnClik();
        startTime();

    }

    private void btnOnClik() {
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (!flag){flag=true;}
        else flag=false;
    }
});
    }

    private void startTime() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                int i=0;
                while (flag){
                    final int txts=i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(String.valueOf(txts));
                        }
                    });
                    i++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void initializeView() {
        txt= findViewById(R.id.txtTimer);
        btn= findViewById(R.id.start_button);

    }


}
