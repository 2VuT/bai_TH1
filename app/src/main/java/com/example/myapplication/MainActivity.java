package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    float a,b,kq;
    EditText num1,num2;
    TextView result;
    SharedPreferences spr;

    public static final String mypreference = "mypref";
    public static final String Number1 = "numberKey1";
    public static final String Number2 = "numberKey2";
    public static final String Result = "resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cong = (Button) findViewById(R.id.cong);
        Button tru = (Button) findViewById(R.id.tru);
        Button nhan = (Button) findViewById(R.id.nhan);
        Button chia = (Button) findViewById(R.id.chia);
        num1 = (EditText) findViewById(R.id.first_number);
        num2 = (EditText) findViewById(R.id.second_number);
        result = (TextView) findViewById(R.id.result);

        spr = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if(spr.contains(Number1)) {
            num1.setText(spr.getString(Number1, ""));
        }
        if(spr.contains(Number2)) {
            num2.setText(spr.getString(Number2, ""));
        }
        if(spr.contains(Result)) {
            result.setText(spr.getString(Result, ""));
        }

        cong.setOnClickListener(this);
        tru.setOnClickListener(this);
        nhan.setOnClickListener(this);
        chia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        a = Float.parseFloat(num1.getText().toString());
        b = Float.parseFloat(num2.getText().toString());

        switch(v.getId())
        {
            case R.id.cong:
                kq = a + b;
                result.setText(String.valueOf(kq));
                break;

            case R.id.tru:
                kq = a - b;
                result.setText(String.valueOf(kq));
                break;

            case R.id.chia:
                if(b == 0)
                {
                    result.setText("match error");
                }
                else
                {
                    kq = a / b;
                    result.setText(String.valueOf(kq));
                }
                break;

            case R.id.nhan:
                kq = a * b;
                result.setText(String.valueOf(kq));
                break;

        }
        String number1 = num1.getText().toString();
        String number2 = num2.getText().toString();
        String kq = result.getText().toString();
        save(number1, number2, kq);
    }

    public void save(String a, String b, String c) {
        SharedPreferences.Editor editor = spr.edit();
        editor.putString(Number1, a);
        editor.putString(Number2, b);
        editor.putString(Result, c);
        editor.commit();
    }
}
