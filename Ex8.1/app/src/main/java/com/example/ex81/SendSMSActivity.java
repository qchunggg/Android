package com.example.ex81;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SendSMSActivity extends AppCompatActivity {
    EditText edtsms;
    Button btnback2;
    ImageButton btnsendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendsms);
        edtsms = (EditText) findViewById(R.id.edtsms);
        btnback2 = (Button) findViewById(R.id.btnback2);
        btnsendsms = (ImageButton) findViewById(R.id.btnsms);
        btnsendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("smsto:"+edtsms.getText().toString()));
                startActivity(callintent);
            }
        });
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}