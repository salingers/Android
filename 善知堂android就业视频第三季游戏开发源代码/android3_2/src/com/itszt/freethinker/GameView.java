package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class GameView extends View{
	private Paint paint = null;
	private Bitmap bitmap = null;
	private Matrix matrix = null;
	public GameView(Context context) {
		super(context);
		paint = new Paint();
//		bitmap = ((BitmapDrawable)this.getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
		bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher);
		matrix = new Matrix();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setColor(Color.RED);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(5);
		canvas.drawLine(0, 0, 100, 100, paint);
		canvas.drawCircle(40, 40, 30, paint);
		canvas.drawRect(30, 30, 100, 100, paint);
		Rect rect = new Rect(150, 150, 200, 300);
		paint.setColor(Color.YELLOW);
//		canvas.drawRect(rect, paint);
		RectF rectF = new RectF(rect);
		canvas.drawRoundRect(rectF, 20, 10, paint);
		canvas.drawOval(rectF, paint);
		paint.setColor(Color.RED);
		canvas.drawArc(rectF, 90, 45, true, paint);
		Path path = new Path();
		path.moveTo(110, 110);
		path.lineTo(300, 110);
		path.lineTo(180, 400);
		path.close();
//		canvas.drawPath(path, paint);
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(1);
		canvas.drawText("FreeThinker", 0, 60, paint);
		
		canvas.drawTextOnPath("12345678901234567890123456789012345678901234567890", path, 10, 10, paint);
//		canvas.drawBitmap(bitmap, 0, 0, paint);
		
		Rect src = new Rect(24, 24, 48, 48);
		Rect dst = new Rect(200, 200, 300, 300);
		canvas.drawRect(dst, paint);
//		canvas.drawBitmap(bitmap, src, dst, paint);
		
//		matrix.setTranslate(100, 0);
//		matrix.setRotate(30);
//		matrix.setRotate(30, 24, 24);
//		matrix.setScale(1, 3 , 48,48);
		matrix.setSkew(0.5f, 0.5f , 24 , 24);
		matrix.postTranslate(100, 0);
		matrix.preScale(2, 2 , 24,24);
		canvas.drawBitmap(bitmap, matrix, paint);
	}

}
