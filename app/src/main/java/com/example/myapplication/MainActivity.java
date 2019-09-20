package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnRes, btnPlus, btnM, btnC, btnDiv, btnDob;
    private TextView textView;
    private String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
        initBtnListener();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1){
//            int b = data.getIntExtra("valueResult", -1);
//        }
//    }

    void goNewWind(int result) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("value", result);
        startActivityForResult(intent, 1);
    }

    public void initializeButtons() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnC = findViewById(R.id.btn_c);
        btnDiv = findViewById(R.id.btn_div);
        btnDob = findViewById(R.id.btn_db);
        btnM = findViewById(R.id.btn_m);
        btnPlus = findViewById(R.id.btn_plus);
        textView = findViewById(R.id.text_res);
        btnRes = findViewById(R.id.btn_res);
    }

    private void initBtnListener() {
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "0";
                textView.setText(temp);


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "1";
                textView.setText(temp);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "2";
                textView.setText(temp);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "3";
                textView.setText(temp);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "4";
                textView.setText(temp);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "5";
                textView.setText(temp);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "6";
                textView.setText(temp);

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "7";
                textView.setText(temp);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "8";
                textView.setText(temp);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "9";
                textView.setText(temp);

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "+";
                textView.setText(temp);

            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "-";
                textView.setText(temp);

            }
        });
        btnDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "*";
                textView.setText(temp);

            }
        });

        /////
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp += "/";
                textView.setText(temp);

            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                temp = "";
                textView.setText(temp);

            }
        });
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String[] templA = temp.split("\\+|-|\\*|/");

                if (temp.indexOf('*') != -1) {
                    temp = String.valueOf(Integer.valueOf(templA[0]) * Integer.valueOf(templA[1]));
                } else if (temp.indexOf('/') != -1) {
                    temp = String.valueOf(Integer.valueOf(templA[0]) / Integer.valueOf(templA[1]));
                } else if (temp.indexOf('-') != -1) {
                    temp = String.valueOf(Integer.valueOf(templA[0]) - Integer.valueOf(templA[1]));
                } else if (temp.indexOf('+') != -1) {
                    temp = String.valueOf(Integer.valueOf(templA[0]) + Integer.valueOf(templA[1]));
                }
                textView.setText(temp);

            }
        });
    }

}
