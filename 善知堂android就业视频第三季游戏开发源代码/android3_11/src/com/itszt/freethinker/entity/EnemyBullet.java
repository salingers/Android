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

public class EnemyBullet extends Sprite{
	public EnemyBullet(View view) {
		super(view, R.drawable.bullet3);
	}
	public void move() {
		y += dy;
		if (y > gameView.getHeight()) {
			flag = false;
		}
	}
}
