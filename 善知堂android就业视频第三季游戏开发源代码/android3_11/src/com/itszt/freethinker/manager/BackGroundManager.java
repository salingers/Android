package com.itszt.freethinker.manager;

import com.itszt.freethinker.ui.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-3-11
 */

public class BackGroundManager {
	private Rect srcRect = null;
	private Rect desRect = null;
	private Rect desRect2 = null;
	private int dy, dy2 = -480;
	private Bitmap bitmap = null;
	public BackGroundManager(View view){
		srcRect = new Rect(0, 0, 240, 366);
		desRect = new Rect(0, dy, 320, 480);
		desRect2 = new Rect(0, dy2, 320, 0);
		bitmap = BitmapFactory.decodeResource(view.getResources(),
				R.drawable.background2);
	}
	public void drawBackGround(Canvas canvas){
		dy += 3;
		dy2 += 3;
		desRect.set(0, dy, 320, 480 + dy);
		desRect2.set(0, dy2, 320, 480 + dy2);
		canvas.drawBitmap(bitmap, srcRect, desRect, null);
		canvas.drawBitmap(bitmap, srcRect, desRect2, null);
		if (dy >= 480)
			dy = -480;
		if (dy2 >= 480)
			dy2 = -480;
	}
}
