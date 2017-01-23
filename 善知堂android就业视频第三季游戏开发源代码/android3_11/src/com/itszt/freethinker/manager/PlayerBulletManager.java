package com.itszt.freethinker.manager;

import android.graphics.Canvas;
import android.view.View;

import com.itszt.freethinker.entity.PlayerBullet;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-3-20
 */

public class PlayerBulletManager {
	private static PlayerBullet[] pbs = new PlayerBullet[128];
	public PlayerBulletManager(View view){
		for(int i = 0; i<pbs.length; i++){
			pbs[i] = new PlayerBullet(view);
		}
	}
	public void drawPlayerBullet(Canvas canvas){
		for(PlayerBullet pb : pbs){
			if(pb.flag){
				pb.move();
				pb.drawSelf(canvas);
			}
		}
	}
	public static PlayerBullet getOneBullet(){
		for(PlayerBullet pb : pbs){
			if(!pb.flag){
				pb.flag = true;
				return pb;
			}
		}
		return null;
	}
	public static PlayerBullet[] getAllBullets(){
		return pbs;
	}
}
