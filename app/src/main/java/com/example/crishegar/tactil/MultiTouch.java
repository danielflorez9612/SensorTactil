package com.example.crishegar.tactil;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import static android.view.MotionEvent.ACTION_POINTER_DOWN;

public class MultiTouch extends AppCompatActivity {
    private Float[][] pos = new Float[2][2];
    String acciones[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL","ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP" };
    private final String X_1 = "POS1 x = ";
    private final String X_2 = "POS2 x = ";
    private final String Y_1 = "POS1 y = ";
    private final String Y_2 = "POS2 y = ";

    private TextView txtPos1X;

    private TextView txtPos1Y;

    private TextView txtPos2X;

    private TextView txtPos2Y;
    private TextView tvSalida;


    String salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch);
        boolean multiTouch = getPackageManager().hasSystemFeature( PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH);
        this.txtPos1X = findViewById(R.id.txt1x);
        this.txtPos1Y = findViewById(R.id.txt1y);
        this.txtPos2X = findViewById(R.id.txt2x);
        this.txtPos2Y = findViewById(R.id.txt2y);
        this.tvSalida = findViewById(R.id.tvSalida);
        salida = "";
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int accion = event.getAction();
        int codigoAccion = accion & MotionEvent.ACTION_MASK;
        salida+=(acciones[codigoAccion]);
        for (int i = 0; i < event.getPointerCount(); i++) {
            salida+=("|| puntero:" + event.getPointerId(i) +
                    " x:" + event.getX(i) + " y:" + event.getY(i));
            try{
                pos[i][0] = event.getX(i);
                pos[i][1] = event.getY(i);
            }catch (Exception e){
                Log.d("Error", "Aun no hay para "+i+" punteros");
            }
        }
        this.ShowResult();
        salida = "";
        return true;
    }

    public void ShowResult() {
        this.txtPos1X.setText(X_1 + String.valueOf(pos[0][0]));
        this.txtPos1Y.setText(Y_1 + String.valueOf(pos[0][1]));
        this.txtPos2X.setText(X_2 + String.valueOf(pos[1][0]));
        this.txtPos2Y.setText(Y_2 + String.valueOf(pos[1][1]));
        this.tvSalida.setText(salida);
        Log.d("salida",salida);
    }
}
