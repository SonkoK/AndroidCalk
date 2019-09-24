package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    private EditText editText1, editText2;
    private Spinner spinner, spinner2;
    private Currencies USD = new Currencies(), EUR = new Currencies(), RUB = new Currencies();
    private Currencies[] currencies = {USD, EUR, RUB};
    private ArrayList<Currencies> arrayList = new ArrayList<>();
    private double rate1, rate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    initializeCurrency();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        handlInitializeCurensy();
        editText1 = findViewById(R.id.text_spinner1);
        editText2 = findViewById(R.id.text_spinner2);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);

        initSpinner();

        spinnerListners();

    }

    protected void initSpinner() {
        arrayList.addAll(Arrays.asList(currencies));
        CurencyAdapter myAdapter = new CurencyAdapter(this, arrayList);
        spinner.setAdapter(myAdapter);
        spinner.setPrompt("Title");
        spinner2.setAdapter(myAdapter);
        spinner2.setPrompt("Title");// выделяем элемент
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rate1 = arrayList.get(i).getRate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rate2 = arrayList.get(i).getRate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    protected void initializeCurrency() throws Exception {
        URL myUrl = new URL("https://api.ratesapi.io/api/latest");
        HttpURLConnection myUrlConnection = (HttpURLConnection) myUrl.openConnection();
        myUrlConnection.setRequestMethod("GET");
        //////////////////////////////////////
        InputStream inputStream = myUrlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        /////////////////////////////////////
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Example example = gson.fromJson(line, Example.class);
        USD.setRate(example.getRates().getUSD().doubleValue());
        RUB.setRate(example.getRates().getRUB().doubleValue());
        EUR.setRate(1);


    }

    protected void handlInitializeCurensy() {
        RUB.setImage(R.drawable.rub);
        USD.setImage(R.drawable.dolar);

        EUR.setImage(R.drawable.eur);
        RUB.setCurensyName("Рубль");
        EUR.setCurensyName("Euro");
        USD.setCurensyName("Dollar");


    }

    protected void spinnerListners() {


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                double value1 = Double.valueOf(editText1.getText().toString());
                value1 /= rate1;
                editText2.setText(String.valueOf(value1 *= rate2));
            }
        });
//        editText2.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (!editable.toString().equals("")) {
//                    double value2 = Double.valueOf(editText2.getText().toString());
//                    double res = value2 / rate2;
//                    res = res * rate1;
//                    editText1.setText(String.valueOf(res));
//                }
//            }
//        });
    }

    void log(Object data) {
        Log.d("IJKAPP", String.valueOf(data));
    }
}
