package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private Button btnBack2Main;
    private TextView tx_getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBack2Main = (Button) findViewById(R.id.btn_back2Main);
        tx_getData = (TextView) findViewById(R.id.tx_getData);

        btnBack2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SecondActivity.this, MainActivity.class);

                Intent myGetIntent = getIntent();
                Bundle myGetBundle = myGetIntent.getBundleExtra("myobj");
                String myGetString = myGetBundle.getString("data");

                tx_getData.setText(myGetString);
                Toast.makeText(SecondActivity.this, myGetString, Toast.LENGTH_LONG).show();
            }
        });
    }
}