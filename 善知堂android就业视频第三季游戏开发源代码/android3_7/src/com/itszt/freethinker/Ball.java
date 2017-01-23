package com.itszt.freethinker;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.media.MediaPlayer;
import android.view.View;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker email: 1942623403@qq.com 2012-1-30
 */

public class Ball {
	public float cx, cy;
	private int radius;
	private Canvas canvas = null;
	private Paint paint;
	private Random random;
	private int dx, dy;
	private boolean xplus = true, yplus = true;
	private int width, hight;
	private MediaPlayer mediaPlayer = null;
	public void drawBall(Canvas canvas) {
		radius = 7;
		canvas.drawCircle(cx, cy, radius, paint);
		
		
	}

	public Ball(View view) {
		super();
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL_AND_STROKE);
		paint.setStrokeWidth(1);
		random = new Random();
		dx = random.nextInt(8) + 1;
		dy = random.nextInt(8) + 1;
		width = view.getWidth();
		hight = view.getHeight();
		mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.ringout);
	}

	public void move() {
		if(cx + radius >= width){
			xplus = false;
			mediaPlayer.start();
		}
			
		else if(cx - radius <=0 ){
			mediaPlayer.start();
			xplus = true;
		}
			
		if(cy + radius >= hight)
			yplus = false;
		else if(cy - radius <=0 )
			yplus = true;
		cx = xplus ? cx + dx : cx - dx;
		cy = yplus ? cy + dy : cy - dy;
	}
}
