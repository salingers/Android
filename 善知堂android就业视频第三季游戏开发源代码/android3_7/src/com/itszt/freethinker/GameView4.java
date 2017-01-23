package com.itszt.freethinker;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker email: 1942623403@qq.com 2012-1-30
 */

public class GameView4 extends SurfaceView implements SurfaceHolder.Callback,
		Runnable {
	private Paint paint;
	private SurfaceHolder sh;
	private boolean isRunning = true;
	private Canvas canvas;
	private Path path;
	private float x, y , r;
	private boolean flag = false;
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	public GameView4(Context context) {
		super(context);
		paint = new Paint();
		path = new Path();
		sh = this.getHolder();
		sh.addCallback(this);
		this.setFocusable(true);

	}

	@Override
	public void run() {
		while (isRunning) {
			drawView();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void drawView() {
		try {
			if (sh != null) {
				canvas = sh.lockCanvas();
				canvas.drawColor(Color.BLUE);
				canvas.setDrawFilter(new PaintFlagsDrawFilter(0,
						Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
				
				for(Circle circle : circles){
					circle.drawCircle(canvas);
				}
				
//				if(flag){
//					r += 3;
//					canvas.drawCircle(x, y, r, paint);
//				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (canvas != null)
				sh.unlockCanvasAndPost(canvas);
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Circle circle = new Circle(event.getX(), event.getY());
			circles.add(circle);
//			flag = true;
			break;
		}
		return true;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		new Thread(this).start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.i("surface", "change");

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		isRunning = false;
		// try {
		// Thread.sleep(300);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	// if(keyCode == KeyEvent.KEYCODE_BACK){
	// isRunning = false;
	// }
	// return super.onKeyDown(keyCode, event);
	// }
}
