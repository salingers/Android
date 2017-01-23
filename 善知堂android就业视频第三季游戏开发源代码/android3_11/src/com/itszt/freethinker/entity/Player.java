package com.itszt.freethinker.entity;

import com.itszt.freethinker.manager.PlayerBulletManager;
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
 *		2012-3-11
 */

public class Player extends Sprite{
	private PlayerBullet bullet;
	int i = 0;
	public Player(View view){
		super(view, R.drawable.player1);
		x = (view.getWidth()-spriteWidth)/2;
		y = view.getHeight() - spriteHeight;
	}
	
	public void drawSelf(Canvas canvas){
		if(i%3 != 2)
			i++;
		else{
			i=0;
			fire();
		}
		super.drawSelf(canvas);
	}
	public void moveTo(int x, int y){
		this.x = x - spriteWidth/2;
		this.y = y - spriteHeight;
		
	}
	public void fire(){
		bullet = PlayerBulletManager.getOneBullet();
		bullet.setPosition(x+spriteWidth/2-bullet.spriteWidth/2, y-bullet.spriteHeight);
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
