package com.itszt.freethinker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker email: 1942623403@qq.com 2012-1-30
 */

public class Circle {
	public float cx, cy;
	private int radius;
	private int alpha = 255;
	private Canvas canvas = null;
	private Paint paint;

	public void drawCircle(Canvas canvas) {
	
		canvas.drawCircle(cx, cy, radius, paint);
		change();
	}

	public Circle(float cx, float cy) {
		super();
		this.cx = cx;
		this.cy = cy;
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(5);
	}

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void change() {
		radius += 3;
		paint.setAlpha(alpha);
		if (alpha > 10)
			alpha -= 10;

	}
}
