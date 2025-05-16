package com.example.convertlunaryear;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtSolar, edtLunar;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtSolar = findViewById(R.id.edtSolar);
        edtLunar = findViewById(R.id.edtLunar);
        btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bước 1: Lấy giá trị nhập từ EditText
                String s = edtSolar.getText().toString().trim();
                if (s.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập năm dương", Toast.LENGTH_SHORT).show();
                }

//                Bước 2: Ép giá trị nhập về số nguyên
                int solarYear;
                try {
                    solarYear = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Giá trị không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

//                Bước 3: Tính Can + Chi theo bảng
                String can, chi;
                switch (solarYear % 10) {
                    case 0:
                        can = "Canh";
                        break;
                    case 1:
                        can = "Tân";
                        break;
                    case 2:
                        can = "Nhâm";
                        break;
                    case 3:
                        can = "Quý";
                        break;
                    case 4:
                        can = "Giáp";
                        break;
                    case 5:
                        can = "Ất";
                        break;
                    case 6:
                        can = "Bính";
                        break;
                    case 7:
                        can = "Đinh";
                        break;
                    case 8:
                        can = "Mậu";
                        break;
                    case 9:
                        can = "Kỷ";
                        break;
                    default:
                        can = "";
                        break;
                }
                switch (solarYear % 12) {
                    case 0:
                        chi = "Thân";
                        break;
                    case 1:
                        chi = "Dậu";
                        break;
                    case 2:
                        chi = "Tuất";
                        break;
                    case 3:
                        chi = "Hợi";
                        break;
                    case 4:
                        chi = "Tý";
                        break;
                    case 5:
                        chi = "Sửu";
                        break;
                    case 6:
                        chi = "Dần";
                        break;
                    case 7:
                        chi = "Mẹo";
                        break;
                    case 8:
                        chi = "Thìn";
                        break;
                    case 9:
                        chi = "Tỵ";
                        break;
                    case 10:
                        chi = "Ngọ";
                        break;
                    case 11:
                        chi = "Mùi";
                        break;
                    default:
                        chi = "";
                        break;
                }

                String lunarYear = can + " " + chi;
                edtLunar.setText(lunarYear);
            }
        });
    }
}