package com.itszt.freethinker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker
 *	email: 1942623403@qq.com
 *		2012-1-30
 */

public class GameView1 extends SurfaceView{
	private Paint paint;
	private SurfaceHolder sh;
	public GameView1(Context context) {
		super(context);
		sh = this.getHolder();
		sh.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				Canvas canvas = sh.lockCanvas();
				paint = new Paint();
				paint.setColor(Color.RED);
				canvas.drawLine(0, 0, 100, 100, paint);
				sh.unlockCanvasAndPost(canvas);
				
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
	}
	
}
