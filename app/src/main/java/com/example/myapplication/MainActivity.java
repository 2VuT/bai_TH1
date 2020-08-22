package com.example.myapplication;

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
    double a,b,kq = 0.0;
    EditText txtA,txtB;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cong = (Button) findViewById(R.id.cong);
        Button tru = (Button) findViewById(R.id.tru);
        Button nhan = (Button) findViewById(R.id.nhan);
        Button chia = (Button) findViewById(R.id.chia);
        txtA = (EditText) findViewById(R.id.first_number);
        txtB = (EditText) findViewById(R.id.second_number);
        result = (TextView) findViewById(R.id.result);

        cong.setOnClickListener(this);
        tru.setOnClickListener(this);
        nhan.setOnClickListener(this);
        chia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        a = Double.parseDouble(txtA.getText().toString());
        b = Double.parseDouble(txtB.getText().toString());

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
    }
}
