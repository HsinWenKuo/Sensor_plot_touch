package com.example.sensor_plot_touch;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class ShapeView extends View {
    public ShapeView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint a ring
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawCircle( canvas.getWidth()/2, canvas.getHeight()/2, 100, paint);
        canvas.drawCircle( canvas.getWidth()/2, canvas.getHeight()/2, 170, paint);

        //paint a circle
        paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle( -50*MainActivity.valueX +canvas.getWidth()/2, 50*MainActivity.valueY+canvas.getHeight()/2, 5* MainActivity.valueZ, paint);

        //paint a circle
        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(  MainActivity.touchX,   MainActivity.touchY-70, 3* MainActivity.valueZ, paint);

        //paint string
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);
        canvas.drawText("forward",canvas.getWidth()/2-30,25,paint);
        canvas.drawText("backward",canvas.getWidth()/2-30,canvas.getHeight(),paint);
        canvas.drawText("left",0,canvas.getHeight()/2+30,paint);
        canvas.drawText("right",canvas.getWidth()-45,canvas.getHeight()/2+30,paint);

        //draw line
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawLine(0,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight()/2,paint);
        canvas.drawLine(canvas.getWidth()/2,30,canvas.getWidth()/2,canvas.getHeight()-30,paint);

        invalidate();
    }
}
