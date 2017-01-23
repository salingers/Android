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

public class EnemyBullet {
	private int x;
	private int y;
	private int dx;
	private int dy;
	public boolean flag = false;
	private Bitmap bullet = null;

	private int width;
	private int higth;
	private GameView gameView;

	public int getBulletWidth() {
		return bullet.getWidth();
	}

	public int getBulletHigth() {
		return bullet.getHeight();
	}

	public EnemyBullet(View view) {
		gameView = (GameView) view;
		width = view.getWidth();
		higth = view.getHeight();

		bullet = BitmapFactory.decodeResource(view.getResources(),
				R.drawable.bullet3);
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawSelf(Canvas canvas) {
		if (flag)
			canvas.drawBitmap(bullet, x, y, null);
	}

	public void move() {
		y += dy;
		if (y > gameView.getHeight()) {
			flag = false;
		}
	}
}
