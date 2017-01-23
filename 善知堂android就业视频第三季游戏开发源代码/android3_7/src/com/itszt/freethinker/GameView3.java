package com.itszt.freethinker;

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

public class GameView3 extends SurfaceView implements SurfaceHolder.Callback,
		Runnable {
	private Paint paint;
	private SurfaceHolder sh;
	private boolean isRunning = true;
	private Canvas canvas;
	private Path path;

	public GameView3(Context context) {
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

	int x = 0;

	private void drawView() {
		try {
			if (sh != null) {
				canvas = sh.lockCanvas();
				canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
				paint.setColor(Color.RED);
				paint.setStyle(Style.STROKE);
				paint.setStrokeWidth(5);
				// canvas.drawCircle(200, 200, x++, paint);
				canvas.drawPath(path, paint);
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
			path.moveTo(event.getX(), event.getY());
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(event.getX(), event.getY());
			break;

		default:
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
