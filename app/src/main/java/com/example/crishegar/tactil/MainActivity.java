package com.example.crishegar.tactil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void oneTouch(View view){
        Intent intent = new Intent(this, OneTouch.class);
        startActivity(intent);
    }

    public void multiTouch(View view){
        Intent intent = new Intent(this, MultiTouch.class);
        startActivity(intent);
    }
}
