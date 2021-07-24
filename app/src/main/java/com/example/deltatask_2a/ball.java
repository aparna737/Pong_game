package com.example.deltatask_2a;


import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

import static androidx.core.content.ContextCompat.getMainExecutor;
import static androidx.core.content.ContextCompat.startActivity;


public class ball extends View{
    Paint red_fill;
    Paint blue_fill;
    int cx, cy;
    int x_dir, y_dir;
    private Bitmap slider;
    int x,y;
    int canvas_height;
    int canvas_width;
    int gameScore = 0;
    int n1;
    int n2;



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        red_fill = new Paint(Paint.ANTI_ALIAS_FLAG);
        red_fill.setColor(Color.RED);
        red_fill.setStyle(Paint.Style.FILL);
        red_fill.setTextSize(100);
        blue_fill = new Paint(Paint.ANTI_ALIAS_FLAG);
        blue_fill.setColor(Color.BLUE);
        blue_fill.setStyle(Paint.Style.FILL);
        blue_fill.setTextSize(100);
        Rect rect = new Rect();
        cx = cx + x_dir;
        cy = cy + y_dir;
        if (cx>= canvas.getWidth()){
            x_dir = -15;
        }
        if (cx<= 0){
            x_dir = 15;
        }
        if((cy + 50 >= canvas_height-slider.getHeight()) && (cx>=x && cx<= x+slider.getWidth()) && (cy<=canvas_height-slider.getHeight()+1)){
            y_dir = -15;
            gameScore = gameScore + 5;



        }
        if(cy>=canvas.getHeight()+50) {
            y_dir=0;
            x_dir=0;

            Intent resultIntent = new Intent(getContext(),result.class);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            resultIntent.putExtra("score",gameScore);
            getContext().startActivity(resultIntent);



        }
        if (cy<= 100){
            y_dir = 15;
        }

        canvas.drawCircle(cx, cy, 50, red_fill);
        invalidate();
        canvas_height = canvas.getHeight();
        canvas_width = canvas.getWidth();
        y = canvas_height - slider.getHeight();
        canvas.drawBitmap(slider,x,y,null);
        canvas.drawText("SCORE: " + Integer.toString(gameScore),0,100,blue_fill);


    }


    public boolean onTouchEvent(MotionEvent event)
        {

            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN: {

                }
                break;

                case MotionEvent.ACTION_MOVE:
                {
                    if((int)event.getX()>(canvas_width-slider.getWidth())){
                        x =(int)event.getX()-slider.getWidth();
                    }
                    else {

                    x=(int)event.getX();}


                    invalidate();
                }

                break;
                case MotionEvent.ACTION_UP:


                    x=(int)event.getX();


                    invalidate();
                    break;
            }
            return true;
        }



    public ball(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg1);
        slider = BitmapFactory.decodeResource(getResources(),R.drawable.slider);
        cx = 100;
        cy = 100;
        Random num = new Random();
        n1 = 10 + num.nextInt(6);
        n2 = 10 + num.nextInt(6);
        x_dir = n1;
        y_dir = n2;
        y = 550;

    }




}























