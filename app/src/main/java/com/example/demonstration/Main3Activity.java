package com.example.demonstration;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    TextView tv1;
    EditText ed2, ed3, ed4, ed5, ed6;
    Button b3, lgot;
    Validations vali = new Validations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setTitle("Registration Details");

        tv1 = findViewById(R.id.textView3);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        ed4 = findViewById(R.id.editText4);
        ed5 = findViewById(R.id.editText5);
        ed6 = findViewById(R.id.editText6);
        b3 = findViewById(R.id.nxtbtn);
        lgot = findViewById(R.id.lgot);

        lgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent in = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(in);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2, s3, s4, s5, s6;
                s2 = ed2.getText().toString();
                s3 = ed3.getText().toString();
                s4 = ed4.getText().toString();
                s5 = ed5.getText().toString();
                s6 = ed6.getText().toString();

                if (s2.isEmpty()) {
                    ed2.setError("Please enter your name");
                } else if (s3.isEmpty()) {
                    ed3.setError("Please enter your city name");
                } else if (!vali.email_validate(s4)) {
                    ed4.setError("Please enter your Email ID");
                } else if (s5.isEmpty()) {
                    ed5.setError("Please enter your Password");
                } else if (s5.length() < 8) {
                    ed5.setError("Please enter atleast 8 digits");
                } else if (s6.isEmpty()) {
                    ed6.setError("Please Re-enter your Password");
                } else if (!s5.equals(s6)) {
                    ed5.setError("Please confirm your Password");
                } else {
                    Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                    i.putExtra("ed2", s2);
                    i.putExtra("ed3", s3);
                    i.putExtra("ed4", s4);
                    i.putExtra("ed5", s5);
                    i.putExtra("ed6", s6);
                    startActivity(i);
                }

            }
        });

    }
}
