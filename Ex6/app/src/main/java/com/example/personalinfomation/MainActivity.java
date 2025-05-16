package com.example.personalinfomation;

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
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtten,editCMND,editBosung;
    CheckBox chkdocbao,chkdocsach,chkdoccode;
    Button btnsend;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtten = findViewById(R.id.editHoten);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccode = findViewById(R.id.chkdocoding);
        btnsend = findViewById(R.id.btnGuitt);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInfomation();
            }
        });

        // Đăng ký callback thay thế onBackPressed()
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Hiển thị hộp thoại xác nhận
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Question")
                        .setMessage("Are you sure you want to exit?")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("Yes", (dialog, which) -> finish())
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                        .show();
            }
        });
    }

    public void doShowInfomation() {
//        Kiểm tra tên hợp lệ
        String ten = edtten.getText().toString();
        ten = ten.trim();
        if (ten.length() < 3) {
            edtten.requestFocus();
            edtten.selectAll();
            Toast.makeText(this, "Tên phải lớn hơn hoặc bằng 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

//        Kiểm tra CMND hợp lệ
        String cmnd = editCMND.getText().toString();
        cmnd = cmnd.trim();
        if(cmnd.length() != 9)
        {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        //Kiểm tra bằng cấp
        String bang = "";
        group = findViewById(R.id.radioGroup1);
        int id = group.getCheckedRadioButtonId();// Trả về Id
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad= findViewById(id);
        bang = rad.getText()+"";

        //Kiểm tra sở thích
        String sothich = "";
        if(chkdocbao.isChecked())
            sothich += chkdocbao.getText() + "\n";
        if(chkdocsach.isChecked())
            sothich += chkdocsach.getText() + "\n";
        if(chkdoccode.isChecked())
            sothich += chkdoccode.getText() + "\n";
        String bosung = editBosung.getText() + "";

//        Tạo Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });

        //tạo nội dung
        String msg = ten + "\n";
        msg+= cmnd + "\n";
        msg+= bang + "\n";
        msg+= sothich;
        msg+= "—————————–\n";
        msg+= "Thông tin bổ sung:\n";
        msg+= bosung+ "\n";
        msg+= "—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }

}