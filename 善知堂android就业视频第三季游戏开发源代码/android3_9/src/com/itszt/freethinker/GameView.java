package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-2-22
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback,
		Runnable {
	private SurfaceHolder sh = null;
	private Paint paint = null;
	private Bitmap bitmap = null;
	private Bitmap player = null;
	private Rect srcRect = null;
	private Rect desRect = null;
	private Rect desRect2 = null;
	private int dy, dy2 = -480;
	private boolean isRuning = true;
	private Canvas c = null;
	private int playerX, playerY;

	public GameView(Context context) {
		super(context);
		this.setFocusable(true);
		sh = this.getHolder();
		sh.addCallback(this);
		paint = new Paint();
		srcRect = new Rect(0, 0, 240, 366);
		desRect = new Rect(0, dy, 320, 480);
		desRect2 = new Rect(0, dy2, 320, 0);
		bitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.background2);
		player =  BitmapFactory.decodeResource(this.getResources(),
				R.drawable.player1);
	}

	@Override
	public void run() {
		while (isRuning) {
			drawView();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void drawView() {
		try {
			if (sh != null) {
				c = sh.lockCanvas();
				c.drawColor(Color.BLACK);
				paint.setColor(Color.RED);
				dy += 3;
				dy2 += 3;
				desRect.set(0, dy, 320, 480 + dy);
				desRect2.set(0, dy2, 320, 480 + dy2);
				c.drawBitmap(bitmap, srcRect, desRect, null);
				c.drawBitmap(bitmap, srcRect, desRect2, null);
				if (dy >= 480)
					dy = -480;
				if (dy2 >= 480)
					dy2 = -480;
				c.drawBitmap(player, playerX, playerY, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				sh.unlockCanvasAndPost(c);
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		new Thread(this).start();
		isRuning = true;
		playerX = (this.getWidth()-player.getWidth())/2;
		playerY = this.getHeight() - player.getHeight();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		isRuning = false;

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
			isRuning = false;
		return super.onKeyDown(keyCode, event);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		playerX = (int)event.getX() - player.getWidth()/2;
		playerY = (int)event.getY() - player.getHeight();
		return super.onTouchEvent(event);
	}
}
