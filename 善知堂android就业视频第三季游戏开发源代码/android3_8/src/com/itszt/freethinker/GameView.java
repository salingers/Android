package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.View;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-2-17
 */

public class GameView extends View {
	private boolean isRunning = true;
	private Paint paint = null;
	private int radius = 8;
	int cx = 0;
	int cy = 50;
	int cx1 = 0;
	int cy1 = 100;
	BallThread ballThread1 = null;
	BallThread ballThread2 = null;

	public GameView(Context context) {
		super(context);
		this.setFocusable(true);
		paint = new Paint();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.BLUE);
		if (ballThread1 != null) {
			canvas.drawCircle(ballThread1.x, cy, radius, paint);
		}

		if (ballThread2 != null)
			canvas.drawCircle(ballThread2.x, cy1, radius, paint);
		super.onDraw(canvas);
	}

	class BallThread extends Thread {
		public int x;

		@Override
		public void run() {
			while (isRunning) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				x += 10;
				postInvalidate();
			}
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
			ballThread1 = new BallThread();
			ballThread1.start();
			ballThread2 = new BallThread();
			ballThread2.start();
			break;
		case KeyEvent.KEYCODE_BACK:
			isRunning = false;
			return super.onKeyDown(keyCode, event);
		default:
			break;
		}
		return true;
	}
}
