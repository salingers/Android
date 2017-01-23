package com.itszt.freethinker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.view.View;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker email: 1942623403@qq.com 2012-1-29
 */

public class GameView extends View {
	private Paint paint;
	private Bitmap bitmap;
	private Matrix matrix;

	public GameView(Context context) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.RED);
		bitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.joystick);
		System.out.println(this.getWidth()+"   "+this.getHeight());
		Activity activity = (Activity)context; 
		System.out.println(activity.getWindowManager().getDefaultDisplay().getHeight());
		System.out.println(activity.getWindowManager().getDefaultDisplay().getWidth());
		matrix = new Matrix();
		this.setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		// paint.setAntiAlias(true);
		canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG
				| Paint.FILTER_BITMAP_FLAG));
		canvas.drawLine(0, 0, this.getWidth(), this.getHeight(), paint);
		System.out.println(this.getWidth()+"   "+this.getHeight());
		matrix.setRotate(85);
		matrix.postTranslate(200, 50);
		canvas.drawBitmap(bitmap, matrix, null);
	}
}
