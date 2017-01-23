package com.itszt.freethinker;

import java.util.ArrayList;

import android.graphics.Canvas;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker
 *	email: 1942623403@qq.com
 *		2012-2-13
 */

public class BallsManager {
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	public void addBall(Ball ball){
		balls.add(ball);
	}
	public void drawBalls(Canvas canvas){
		for(Ball ball : balls){
			ball.drawBall(canvas);
			ball.move();
		}
	}
}
