package com.example.sherbetex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private TextView textView, textView2, textResult;
     private EditText count1, count2, count3;
     private Button button;
     private double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        textView = findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
        textResult= (TextView) findViewById(R.id.textResult);
        count1=findViewById(R.id.count1);
        count2=findViewById(R.id.count2);
        count3=findViewById(R.id.count3);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }
    private void getData(){
        double c1 = Double.parseDouble(count1.getText().toString());
        double c2 = Double.parseDouble(count2.getText().toString());
        double c3 = Double.parseDouble(count3.getText().toString());

        sum = c1 + c2 * c3;
        String sr = Double.toString(sum);
        textResult.setText(sr);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("result", textResult.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textResult.setText(savedInstanceState.getString("result"));

    }
}