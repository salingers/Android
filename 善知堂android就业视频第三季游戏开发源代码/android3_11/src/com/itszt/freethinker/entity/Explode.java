package com.itszt.freethinker.entity;

import java.util.ArrayList;
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

public class Explode extends Sprite{
	private ArrayList<Bitmap> bs = new ArrayList<Bitmap>();
	private Bitmap partBitmap = null;
	int i = 2;
	public Explode(View view) {
		super(view, R.drawable.explode2);
		
		for(int i = 0; i<3; i++){
			partBitmap = Bitmap.createBitmap(sprite, i*(sprite.getWidth()/3), 0, sprite.getWidth()/3, sprite.getHeight());
			bs.add(partBitmap);
		}
	}
	public void drawSelf(Canvas canvas) {
		canvas.drawBitmap(bs.get(i--), x, y, null);
		if(i == -1){
			i = 2;
			flag = false;
		}
	}
	@Override
	public void move() {
	}
}
