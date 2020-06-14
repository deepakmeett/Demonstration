package com.example.demonstration;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class MainActivity extends AppCompatActivity {
    Thread t;
    FirebaseAuth fba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fba = FirebaseAuth.getInstance();

        final FirebaseUser fbu = fba.getCurrentUser();
        t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (fbu==null){
//                        user not login
                        Intent in = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(in);
                    }
                    else{
//                        user login
                        Intent in = new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(in);
                    }
                    finish();
                } catch (Exception e) {
                }
            }
        };
        t.start();
    }
}