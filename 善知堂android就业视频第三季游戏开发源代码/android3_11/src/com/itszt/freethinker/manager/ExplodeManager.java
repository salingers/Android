package com.itszt.freethinker.manager;

import android.graphics.Canvas;
import android.view.View;

import com.itszt.freethinker.entity.Explode;
import com.itszt.freethinker.entity.PlayerBullet;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-3-20
 */

public class ExplodeManager {
	private static Explode[] explodes = new Explode[8];
	public ExplodeManager(View view){
		for(int i = 0; i<explodes.length; i++){
			explodes[i] = new Explode(view);
		}
	}
	public void drawExplodes(Canvas canvas){
		for(Explode explode : explodes){
			if(explode.flag){
				explode.drawSelf(canvas);
			}
		}
	}
	public static Explode getExplode(){
		for(Explode pb : explodes){
			if(!pb.flag){
				pb.flag = true;
				return pb;
			}
		}
		return null;
	}
}
