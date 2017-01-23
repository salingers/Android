package com.itszt.freethinker;

import com.itszt.freethinker.GameView.MyThread;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private GameView gameView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("activity", String.valueOf(Thread.currentThread().getId()));
        gameView = new GameView(this);
        setContentView(gameView);
    }
}