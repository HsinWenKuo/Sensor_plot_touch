package com.example.sensor_plot_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometers;
    public static float valueX, valueY, valueZ;
    public static float touchX, touchY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ShapeView shapeView = new ShapeView(this);
        setContentView(shapeView);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometers = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometers, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        valueX = event.values[0];
        valueY = event.values[1];
        valueZ = event.values[2];
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        switch( event.getAction() ) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        //return super.onTouchEvent(event);
        return false;
    }
}