package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker email: 1942623403@qq.com 2012-1-28
 */

public class GameView extends View {
	private Paint paint = null;
	private int x = 0;

	public GameView(Context context) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.YELLOW);
		
		// this.setFocusable(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawLine(x, 0, x, 400, paint);
	}

	class MyThread extends Thread {
		@Override
		public void run() {
			while (x < 300) {
				x++;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GameView.this.postInvalidate();
			}
		}
	}

	Thread t = null;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_UP:

			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:

			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:

			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:

			break;
		case KeyEvent.KEYCODE_DPAD_CENTER:
			if (t == null) {
				t = new MyThread();
				t.start();
			}
			break;
		case KeyEvent.KEYCODE_BACK:

			break;

		default:
			break;
		}
		System.out.println("GameView   " + keyCode);
		
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("GameView   " + event.getX() + " " + event.getY()
				+ " " + event.getAction());
		x = (int)event.getX();
		postInvalidate();
		return super.onTouchEvent(event);
	}
}
