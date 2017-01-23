package com.itszt.freethinker.manager;

import android.graphics.Canvas;
import android.view.View;

import com.itszt.freethinker.entity.EnemyBullet;
import com.itszt.freethinker.entity.PlayerBullet;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-3-20
 */

public class EnemyBulletManager {
	private EnemyBullet[] pbs = new EnemyBullet[128];
	public EnemyBulletManager(View view){
		for(int i = 0; i<pbs.length; i++){
			pbs[i] = new EnemyBullet(view);
		}
	}
	public void drawEnemyBullet(Canvas canvas){
		for(EnemyBullet pb : pbs){
			if(pb.flag){
				pb.move();
				pb.drawSelf(canvas);
			}
		}
	}
	public EnemyBullet getOneBullet(){
		for(EnemyBullet pb : pbs){
			if(!pb.flag){
				pb.flag = true;
				return pb;
			}
		}
		return null;
	}
}
