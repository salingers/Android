package com.itszt.freethinker;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private GameView gameView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
    }
 
}