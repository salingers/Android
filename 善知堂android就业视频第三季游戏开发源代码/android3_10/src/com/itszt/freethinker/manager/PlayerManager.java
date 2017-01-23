package com.itszt.freethinker.manager;

import android.graphics.Canvas;
import android.view.View;

import com.itszt.freethinker.entity.Player;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-3-11
 */

public class PlayerManager {
	private Player player; 
	public PlayerManager(View view){
		this.player = new Player(view);
	}
	public void drawPlayer(Canvas canvas){
		player.drawSelf(canvas);
	}
	public void moveTo(int x, int y){
		player.moveTo(x, y);
	}
	public Player getPlayer(){
		return player;
	}
}
