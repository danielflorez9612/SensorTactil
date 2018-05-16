package com.example.crishegar.tactil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class OneTouch extends AppCompatActivity {

    private float posX;

    private float posY;

    private TextView txtPosX;

    private TextView txtPosY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_touch);
        txtPosX = (TextView) findViewById(R.id.txtPosX);
        txtPosY = (TextView) findViewById(R.id.txtPosY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.posX = event.getX();
        this.posY = event.getY();
        this.ShowResult();
        return true;
    }

    public void ShowResult() {
        this.txtPosY.setText(String.valueOf(posY));
        this.txtPosX.setText(String.valueOf(posX));
    }
}
