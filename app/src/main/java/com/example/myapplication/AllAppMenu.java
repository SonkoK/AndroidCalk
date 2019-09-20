package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

public class AllAppMenu extends AppCompatActivity {
    private Button btnCalk, btnKonv;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCalk = findViewById(R.id.calk);
        btnKonv = findViewById(R.id.konv);
        textView= findViewById(R.id.cours);
        btnStrt();
        //ArrayAdapter<String> adapter = new ArrayAdapter<>();
//        try {
//            getCurency();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


        private void btnStrt(){
        btnCalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllAppMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnKonv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllAppMenu.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }


}
