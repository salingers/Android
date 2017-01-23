package com.itszt.freethinker.manager;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.view.View;

import com.itszt.freethinker.entity.Enemy;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) 
 * author: freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-3-11
 */

public class EnemyManager {
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	public EnemyManager(View view){
		for(int i = 0; i<5; i++){
			enemys.add(new Enemy(view));
		}
	}
	int i = 0;
	public void drawEnemys(Canvas canvas){
		for(Enemy enemy : enemys){
			enemy.move();
			if(enemy.flag){
				if(i%12 != 11)
					i++;
				else{
					i=0;
					enemy.fire();
				}
				enemy.drawSelf(canvas);
				enemy.enemyRamCheck();
			}
		}
	}
}
