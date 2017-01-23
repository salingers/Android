package com.itszt.freethinker.ui;

import com.itszt.freethinker.entity.PlayerBullet;
import com.itszt.freethinker.manager.BackGroundManager;
import com.itszt.freethinker.manager.EnemyBulletManager;
import com.itszt.freethinker.manager.EnemyManager;
import com.itszt.freethinker.manager.ExplodeManager;
import com.itszt.freethinker.manager.PlayerBulletManager;
import com.itszt.freethinker.manager.PlayerManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * company: http://www.itszt.com ( or http://itszt.losoon.com) author:
 * freethinker(ÍõÖÎ¹ú) email: 1942623403@qq.com 2012-2-22
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback,
		Runnable {
	private SurfaceHolder sh = null;

	private boolean isRuning = true;
	private Canvas c = null;
	
	private PlayerManager playerManager = null;
	private BackGroundManager backGroundManager = null;
	private EnemyManager enemyManager = null;
	private PlayerBulletManager pbm = null;
	private EnemyBulletManager ebm = null;
	private ExplodeManager explodeManager = null;
	public PlayerManager getPlayerManger(){
		return playerManager;
	}
	public PlayerBulletManager getPlayerBulletManger(){
		return pbm;
	}
	public EnemyBulletManager getEnemyBulletManger(){
		return ebm;
	}
	public GameView(Context context) {
		super(context);
		this.setFocusable(true);
		sh = this.getHolder();
		sh.addCallback(this);

	}

	@Override
	public void run() {
		while (isRuning) {
			drawView();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void drawView() {
		try {
			if (sh != null) {
				c = sh.lockCanvas();
				c.drawColor(Color.BLACK);
				backGroundManager.drawBackGround(c);
				enemyManager.drawEnemys(c);
				playerManager.drawPlayer(c);
				pbm.drawPlayerBullet(c);
				ebm.drawEnemyBullet(c);
				explodeManager.drawExplodes(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				sh.unlockCanvasAndPost(c);
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		playerManager = new PlayerManager(this);
		backGroundManager = new BackGroundManager(this);
		enemyManager = new EnemyManager(this);
		pbm = new PlayerBulletManager(this);
		ebm = new EnemyBulletManager(this);
		explodeManager = new ExplodeManager(this);
		new Thread(this).start();
		isRuning = true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		isRuning = false;

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
			isRuning = false;
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		playerManager.moveTo((int)event.getX(), (int)event.getY());
		return super.onTouchEvent(event);
	}
}
