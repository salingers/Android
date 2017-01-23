package com.itszt.freethinker.entity;

import java.io.IOException;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

import com.itszt.freethinker.manager.ExplodeManager;
import com.itszt.freethinker.manager.PlayerBulletManager;
import com.itszt.freethinker.ui.GameView;
import com.itszt.freethinker.ui.R;
import com.itszt.freethinker.util.RamCheck;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-3-11
 */

public class Enemy extends Sprite{

	private EnemyBullet bullet;
	private MediaPlayer player = null;
	int i = 0;
	boolean isExplode = false;

	public Enemy(View view) {
		super(view, R.drawable.e4);
		player = MediaPlayer.create(gameView.getContext(), R.raw.ringout);
		x = new Random().nextInt(viewWidth);
		y = new Random().nextInt(50) - 50;
		dy = new Random().nextInt(5) + 1;
		
	}
	int ex, ey;

	public void enemyRamCheck() {
		for (PlayerBullet bullet : PlayerBulletManager.getAllBullets()) {
//			if (this.flag
//					&& bullet.flag
//					&& RamCheck.ifRam(x, y, x + spriteWidth, y + spriteHeight,
//							bullet.x, bullet.y,
//							bullet.x + bullet.spriteHeight, bullet.y
//									+ bullet.spriteWidth)) {
			if (this.flag
					&& bullet.flag
					&& RamCheck.ifRam(this, bullet)) {
				player.start();
				this.flag = false;
				bullet.flag = false;
				Explode explode = ExplodeManager.getExplode();
				explode.setPosition(x, y+this.spriteHeight/2);
				break;
			}
		}
	}

	public void move() {
		int px = gameView.getPlayerManger().getPlayer().x;

		if (px < x)
			dx = new Random().nextInt(3) - 3;
		else if (px > x)
			dx = new Random().nextInt(3) + 1;
		else
			dx = 0;
		x += dx;
		y += dy;
		if (!this.flag || x < spriteWidth * -1 || x > viewWidth || y > viewHeight) {
			x = new Random().nextInt(viewWidth);
			y = new Random().nextInt(50) - 50;
			this.flag = true;
		}
	}

	public void fire() {
		bullet = gameView.getEnemyBulletManger().getOneBullet();
		bullet.setPosition(x + spriteWidth / 2 - bullet.spriteWidth / 2, y
				+ spriteWidth);
		bullet.setDy(dy + 3);
	}
}
