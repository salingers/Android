package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Button;

public class MyButton extends Button{
	//父类没有不带参数的构造器
	public MyButton(Context context) {
		super(context);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
//		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		canvas.drawLine(0, 0, 100, 100, paint);
//		paint.setColor(Color.YELLOW);
//		canvas.drawCircle(30, 30, 30, paint);
	}

}
