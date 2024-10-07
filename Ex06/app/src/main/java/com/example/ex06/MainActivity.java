package com.example.ex06;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        //kiem tra bang cap
        String bang = "";
        group = findViewById(R.id.group);
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText()+"";

        //kiem tra so thich
        String sothich = "";
        if (chkdocbao.isChecked())
            sothich += chkdocbao.getText() + "\n";
        if (chkdocsach.isChecked())
            sothich += chkdocsach.getText() + "\n";
        if (chkdoccoding.isChecked())
            sothich += chkdoccoding.getText() + "\n";

        String bosung = editBosung.getText()+"";

        //Tao dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String msg = ten + "\n";
        msg += cmnd + "\n";
        msg += bang + "\n";
        msg += sothich;
        msg += "----------------\n";
        msg += "Thông tin bổ sung: \n";
        msg += bosung +  "\n";
        msg += "----------------\n";
        builder.setMessage(msg);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
//        b.setIcon(R.drawable.inform)
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        b.create().show();
    }
}
