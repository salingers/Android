package com.itszt.freethinker.entity;

import java.io.IOException;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

import com.itszt.freethinker.manager.PlayerBulletManager;
import com.itszt.freethinker.ui.GameView;
import com.itszt.freethinker.ui.R;
import com.itszt.freethinker.util.RamCheck;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-3-11
 */

public class Enemy {
	private int x;
	private int y;
	private int dx;
	private int dy;
	public boolean flag = true;
	private Bitmap enemy = null;
	private Bitmap explode = null;
	private int width;
	private int higth;
	private int enemyWidth;
	private int enemyHight;
	private GameView gameView;
	private EnemyBullet bullet;
	private MediaPlayer player = null;
	int i = 0;
	boolean isExplode = false;

	public Enemy(View view) {
		gameView = (GameView) view;
		player = MediaPlayer.create(gameView.getContext(), R.raw.ringout);
		explode = BitmapFactory.decodeResource(gameView.getResources(),
				R.drawable.explored);

		try {
			player.prepare();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = view.getWidth();
		higth = view.getHeight();
		x = new Random().nextInt(width);
		y = new Random().nextInt(50) - 50;
		dy = new Random().nextInt(5) + 1;
		enemy = BitmapFactory
				.decodeResource(view.getResources(), R.drawable.e4);
		enemyWidth = enemy.getWidth();
		enemyHight = enemy.getHeight();
	}
	int ex, ey;
	public void drawSelf(Canvas canvas) {
		if(this.flag = true)
			canvas.drawBitmap(enemy, x, y, null);
		if (isExplode) {
			for (int i = 0; i < 4; i++){
				canvas.drawBitmap(explode, ex, ey, null);
			}
			isExplode = false;
		}

	}

	public void enemyRamCheck() {
		for (PlayerBullet bullet : PlayerBulletManager.getAllBullets()) {
			if (this.flag
					&& bullet.flag
					&& RamCheck.ifRam(x, y, x + enemyWidth, y + enemyHight,
							bullet.x, bullet.y,
							bullet.x + bullet.getBulletWidth(), bullet.y
									+ bullet.getBulletHigth())) {
				player.start();
				this.flag = false;
				bullet.flag = false;
				isExplode = true;
				ex = x;
				ey = y;
				break;
			}
		}
	}

	public void move() {
		int px = gameView.getPlayerManger().getPlayer().getX();

		if (px < x)
			dx = new Random().nextInt(3) - 3;
		else if (px > x)
			dx = new Random().nextInt(3) + 1;
		else
			dx = 0;
		x += dx;
		y += dy;
		if (!this.flag || x < enemy.getWidth() * -1 || x > width || y > higth) {
			x = new Random().nextInt(width);
			y = new Random().nextInt(50) - 50;
			this.flag = true;
		}
	}

	public void fire() {
		bullet = gameView.getEnemyBulletManger().getOneBullet();
		bullet.setPosition(x + enemyWidth / 2 - bullet.getBulletWidth() / 2, y
				+ enemyHight);
		bullet.setDy(dy + 3);
	}
}
