package com.itszt.freethinker.entity;

import com.itszt.freethinker.ui.GameView;
import com.itszt.freethinker.ui.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-4-23
 */

public abstract class Sprite {
	public int x;
	public int y;
	protected Bitmap sprite = null;
	protected int viewWidth;
	protected int viewHeight;
	public int spriteWidth;
	public int spriteHeight;
	protected int dx;
	protected int dy;
	public boolean flag = false;
	protected GameView gameView;
	public Sprite(View view, int imageId){
		gameView = (GameView) view;
		viewWidth = view.getWidth();
		viewHeight = view.getHeight();

		sprite = BitmapFactory.decodeResource(view.getResources(),
				imageId);
		spriteWidth = sprite.getWidth();
		spriteHeight = sprite.getHeight();
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public void drawSelf(Canvas canvas) {
		canvas.drawBitmap(sprite, x, y, null);
//		Sprint sprint = new EnemyBullet(view);
//		sprint.move();
	}

	public abstract void move();
}
