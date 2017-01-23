package com.itszt.freethinker.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private GameView gameView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	gameView.onKeyDown(keyCode, event);
    	return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	gameView.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }
}