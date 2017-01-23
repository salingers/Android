package com.itszt.freethinker.entity;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.itszt.freethinker.ui.GameView;
import com.itszt.freethinker.ui.R;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-3-11
 */

public class PlayerBullet {
	public int x;
	public int y;
	private int dx;
	private int dy;
	public boolean flag = false;
	private Bitmap bullet = null;

	private int width;
	private int higth;
	private GameView gameView;
	public int getBulletWidth(){
		return bullet.getWidth();
	}
	public int getBulletHigth(){
		return bullet.getHeight();
	}
	public PlayerBullet(View view) {
		gameView = (GameView) view;
		width = view.getWidth();
		higth = view.getHeight();
		
		dy = 5;
		bullet = BitmapFactory
				.decodeResource(view.getResources(), R.drawable.bullet1);
	}
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void drawSelf(Canvas canvas) {
		canvas.drawBitmap(bullet, x, y, null);
	}

	public void move() {
		y -= dy;
		if (y < 0 - bullet.getHeight()) {
			flag = false;
		}
	}
}
