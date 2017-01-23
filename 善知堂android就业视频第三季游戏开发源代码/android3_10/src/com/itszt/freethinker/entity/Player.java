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

public class Player {
	private int x;
	private int y;
	private Bitmap player = null;
	private PlayerBullet bullet;
	int i = 0;
	private int width;
	private int height;
	public Player(View view){
		player =  BitmapFactory.decodeResource(view.getResources(),
				R.drawable.player1);
		width = player.getWidth();
		height = player.getHeight();
		x = (view.getWidth()-width)/2;
		y = view.getHeight() - height;
	}
	
	public void drawSelf(Canvas canvas){
		if(i%3 != 2)
			i++;
		else{
			i=0;
			fire();
		}
		canvas.drawBitmap(player, x, y, null);
	}
	public void moveTo(int x, int y){
		this.x = x - player.getWidth()/2;
		this.y = y - player.getHeight();
		
	}
	public void fire(){
		bullet = PlayerBulletManager.getOneBullet();
		bullet.setPosition(x+width/2-bullet.getBulletHigth()/2, y-bullet.getBulletHigth());
	}
	public int getX(){
		return x;
	}
}
