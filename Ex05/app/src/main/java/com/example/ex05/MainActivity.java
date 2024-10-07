package com.example.ex05;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editnamduonglich;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button1);
        editnamduonglich = findViewById(R.id.editnamduonglich);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namduonglich = editnamduonglich.getText()+"";
                int namduong = Integer.parseInt(namduonglich);

                String can, chi;
                switch (namduong%10) {
                    case 0:
                        System.out.println("Canh");
                        break;
                    case 1:
                        System.out.println("Tân");
                        break;
                    case 2:
                        System.out.println("Nhâm");
                        break;
                    case 3:
                        System.out.println("Quý");
                        break;
                    case 4:
                        System.out.println("");
                        break;
                    case 5:
                        System.out.println("Canh");
                        break;
                    case 6:
                        System.out.println("Canh");
                        break;
                    case 7:
                        System.out.println("Canh");
                        break;
                    case 8:
                        System.out.println("Canh");
                        break;
                    case 9:
                        System.out.println("Canh");
                        break;
                }
            }
        });
    }
}