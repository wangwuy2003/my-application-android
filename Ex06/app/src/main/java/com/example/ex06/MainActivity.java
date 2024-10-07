package com.example.ex06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editHoten, editCMND, editBosung;
    Button btnguitt;
    CheckBox chkdocbao, chkdocsach, chkdoccoding;
    RadioGroup group;
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

        editHoten = findViewById(R.id.editHoten);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBosung);

        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccoding = findViewById(R.id.chkdoccoding);

        btnguitt = findViewById(R.id.btnguitt);
        btnguitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doShowInformation();
            }
        });
    }

    public void doShowInformation() {
        //kiem tra ten hop le
        String ten = editHoten.getText().toString();
        ten = ten.trim();
        if (ten.length() < 3) {
            editHoten.requestFocus();
            editHoten.selectAll();
            Toast.makeText(this, "Tên phải > 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        //kiem tra cmnd hop le
        String cmnd = editCMND.getText().toString();
        cmnd = cmnd.trim();
        if (cmnd.length() != 9) {
            editCMND.
        }
    }
}