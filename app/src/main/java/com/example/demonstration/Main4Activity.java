package com.example.demonstration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView tv4, tv5, tv6, tv7;
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setTitle("Registration Details Verification");
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
        tv6 = findViewById(R.id.textView6);
        tv7 = findViewById(R.id.textView7);
        b4 = findViewById(R.id.backbtn);

        Intent in = getIntent();

        String s2, s3, s4, s5;

        s2 = in.getStringExtra("ed2");
        s3 = in.getStringExtra("ed3");
        s4 = in.getStringExtra("ed4");
        s5 = in.getStringExtra("ed5");

        tv4.setText(s2);
        tv5.setText(s3);
        tv6.setText(s4);
        tv7.setText(s5);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Main4Activity.this,Main3Activity.class);
                startActivity(back);
            }
        });
    }
}