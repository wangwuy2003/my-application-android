package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    TextView tvHelloWorld;

    Button btncong, btnClickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btncong = findViewById(R.id.btntong);

        btncong.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                int a = Integer.parseInt(edtA.getText().toString());
//                int b = Integer.parseInt(edtB.getText().toString());
//                int c = a + b;
//                edtKQ.setText(c+"");
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);

                Bundle myObject = new Bundle();
                myObject.putString("data", "xin chao second");

                myIntent.putExtra("myobj", myObject);

                startActivity(myIntent);
            }
        });

//        btnClickMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvHelloWorld.setText("welcome!");
//            }
//        });
    }
}