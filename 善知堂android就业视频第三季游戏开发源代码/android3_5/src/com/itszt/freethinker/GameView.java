package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker email: 1942623403@qq.com 2012-1-28
 */

public class GameView extends View {
	private Paint paint = null;
	private int x = 0;
	private boolean flag = true;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
//			if(msg.what == 1){
//				
//			}else if(msg.what == 2){
//				
//			}
			Log.i("handler", String.valueOf(Thread.currentThread().getId()));
			
			invalidate();
		};
	};
	public GameView(Context context) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.YELLOW);
		this.setFocusable(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Log.i("draw", String.valueOf(Thread.currentThread().getId()));
		canvas.drawLine(x, 0, x, 400, paint);
	}

	class MyThread extends Thread {
		@Override
		public void run() {
			while (x < 300  && flag) {
				x++;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Message message = new Message();
//				message.what = 1;
				handler.sendMessage(message);
				Log.i("other", String.valueOf(Thread.currentThread().getId()));
//				GameView.this.postInvalidate();
			}
		}
	}

	Thread t = null;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
			Log.i("keydown", String.valueOf(Thread.currentThread().getId()));
			if (t == null) {
				t = new MyThread();
				t.start();
			}
			break;
		case KeyEvent.KEYCODE_BACK:
			flag = false;
			return super.onKeyDown(keyCode, event);
		default:
			break;
		}
		
		return true;
	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		x = (int)event.getX();
//		postInvalidate();
//		return true;
//	}
}
